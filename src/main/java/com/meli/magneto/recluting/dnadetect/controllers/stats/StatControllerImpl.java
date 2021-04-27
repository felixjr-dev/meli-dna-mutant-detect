package com.meli.magneto.recluting.dnadetect.controllers.stats;

import com.meli.magneto.recluting.dnadetect.exceptions.StatCalculationException;
import com.meli.magneto.recluting.dnadetect.model.rest.DnaAnalyzeStat;
import com.meli.magneto.recluting.dnadetect.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatControllerImpl implements StatsController{

    @Autowired
    StatService statService;

    @Override
    public DnaAnalyzeStat getStats() throws StatCalculationException {
        return statService.getStat();
    }
}
