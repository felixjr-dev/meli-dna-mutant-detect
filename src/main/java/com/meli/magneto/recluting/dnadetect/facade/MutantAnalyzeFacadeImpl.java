package com.meli.magneto.recluting.dnadetect.facade;

import com.meli.magneto.recluting.dnadetect.exceptions.DNABadStructureException;
import com.meli.magneto.recluting.dnadetect.model.es.DnaRecord;
import com.meli.magneto.recluting.dnadetect.repositories.DnaESCustomRepository;
import com.meli.magneto.recluting.dnadetect.repositories.DnaRepository;
import com.meli.magneto.recluting.dnadetect.services.DnaAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantAnalyzeFacadeImpl implements MutantAnalyzeFacade{
    @Autowired
    DnaAnalyzeService dnaAnalyzeService;

    @Autowired
    DnaRepository dnaRepository;

    @Override
    public boolean analyzeDna(String[] dna) throws DNABadStructureException {
        DnaRecord  dnaRecord = new DnaRecord();
        dnaRecord.setDna(dna);
        dnaRecord.setMutantInd(dnaAnalyzeService.isMutant(dna));
        dnaRepository.save(dnaRecord);
        return dnaRecord.getMutantInd();
    }

}
