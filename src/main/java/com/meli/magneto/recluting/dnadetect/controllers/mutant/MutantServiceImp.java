package com.meli.magneto.recluting.dnadetect.controllers.mutant;


import com.meli.magneto.recluting.dnadetect.exceptions.DNABadStructureException;
import com.meli.magneto.recluting.dnadetect.facade.MutantAnalyzeFacade;
import com.meli.magneto.recluting.dnadetect.model.rest.EvaluateDNARequest;
import com.meli.magneto.recluting.dnadetect.services.DnaAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantServiceImp implements MutantService{

    @Autowired
    MutantAnalyzeFacade mutantAnalyzeFacade;

    @Override
    public ResponseEntity<?> evaluateDNA(EvaluateDNARequest request) {

        try {
            if(mutantAnalyzeFacade.analyzeDna(request.getDna())){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (DNABadStructureException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
