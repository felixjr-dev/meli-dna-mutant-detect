package com.meli.magneto.recluting.dnadetect.facade;

import com.meli.magneto.recluting.dnadetect.exceptions.DNABadStructureException;

public interface MutantAnalyzeFacade {

    boolean analyzeDna(String[] dna) throws DNABadStructureException;
}
