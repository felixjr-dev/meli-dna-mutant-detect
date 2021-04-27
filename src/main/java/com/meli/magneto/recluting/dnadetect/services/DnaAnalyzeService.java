package com.meli.magneto.recluting.dnadetect.services;

import com.meli.magneto.recluting.dnadetect.exceptions.DNABadStructureException;

public interface DnaAnalyzeService {

    boolean isMutant(String[] dna) throws DNABadStructureException;
}
