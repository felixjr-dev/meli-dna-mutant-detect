package com.meli.magneto.recluting.dnadetect.controllers.stats;

import com.meli.magneto.recluting.dnadetect.exceptions.StatCalculationException;
import com.meli.magneto.recluting.dnadetect.model.rest.DnaAnalyzeStat;
import org.springframework.web.bind.annotation.GetMapping;

public interface StatsController {

    @GetMapping(value = "/stats")
    DnaAnalyzeStat getStats() throws StatCalculationException;


}
