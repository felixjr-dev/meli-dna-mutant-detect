package com.meli.magneto.recluting.dnadetect.controllers.mutant;


import com.meli.magneto.recluting.dnadetect.model.rest.EvaluateDNARequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface MutantService {

    @RequestMapping(value = "/mutant/", method = RequestMethod.POST)
    ResponseEntity<?> evaluateDNA(@RequestBody EvaluateDNARequest request);
}
