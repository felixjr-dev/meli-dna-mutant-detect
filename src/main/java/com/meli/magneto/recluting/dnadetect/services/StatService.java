package com.meli.magneto.recluting.dnadetect.services;

import com.meli.magneto.recluting.dnadetect.exceptions.StatCalculationException;
import com.meli.magneto.recluting.dnadetect.model.rest.DnaAnalyzeStat;

public interface StatService {

    DnaAnalyzeStat getStat() throws StatCalculationException;

}
