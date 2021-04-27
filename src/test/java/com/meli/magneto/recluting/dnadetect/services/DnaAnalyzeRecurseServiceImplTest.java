package com.meli.magneto.recluting.dnadetect.services;

import com.meli.magneto.recluting.dnadetect.exceptions.DNABadStructureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaAnalyzeRecurseServiceImplTest {

    private String[] dnaHorizontal = {
            "ATGCGA",
            "CAGTGC",
            "TTTTAA",
            "AGAAGG",
            "CCCGTA",
            "TCACTG"
    };
    private String[] dnaVertical = {
            "ATGCAA",
            "CAGTGC",
            "TTATGT",
            "AGAAAG",
            "CCAGTA",
            "TCACTG"
    };
    private String[] dnaDiagonalR = {
            "TGGCGA",
            "CATTGC",
            "TTATGT",
            "AGTATG",
            "CCCTTA",
            "TCACTG"
    };
    private String[] dnaDiagonalL = {
            "ATGCGA",
            "CGGTGC",
            "TTATGT",
            "AGTATG",
            "CTCCTA",
            "TCACTG"
    };
    private String[] dnaNormal = {
            "ATGCGA",
            "CTGTGC",
            "TTATGT",
            "ACAATG",
            "CCTCTA",
            "TCACTG"};
    private String[] badDna = {"ATGCSSSGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    DnaAnalyzeRecurseServiceImpl dnaAnalyzeService = new DnaAnalyzeRecurseServiceImpl();

    @Test
    void isMutant() throws DNABadStructureException {
        assertTrue(dnaAnalyzeService.isMutant(dnaHorizontal));
    }

    @Test
    void isMutantVertical() throws DNABadStructureException {
        assertTrue(dnaAnalyzeService.isMutant(dnaVertical));
    }

    @Test
    void isMutantDiagonalL() throws DNABadStructureException {
        assertTrue(dnaAnalyzeService.isMutant(dnaDiagonalL));
    }


    @Test
    void isMutantDiagonalR() throws DNABadStructureException {
        assertTrue(dnaAnalyzeService.isMutant(dnaDiagonalR));
    }

    @Test
    void shouldThrowBadDnaStructureException() {
        assertThrows(DNABadStructureException.class, () -> dnaAnalyzeService.isMutant(badDna));
    }

    @Test
    void isNormal() throws DNABadStructureException {
        assertFalse(dnaAnalyzeService.isMutant(dnaNormal));
    }

}