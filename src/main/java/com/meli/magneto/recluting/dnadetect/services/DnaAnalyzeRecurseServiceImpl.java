package com.meli.magneto.recluting.dnadetect.services;

import com.meli.magneto.recluting.dnadetect.enums.DNANitrogenousBase;
import com.meli.magneto.recluting.dnadetect.exceptions.DNABadStructureException;
import org.springframework.stereotype.Service;

@Service
public class DnaAnalyzeRecurseServiceImpl implements DnaAnalyzeService{

    public static final int CONSECUTIVE_REPEAT_COUNT = 4;
    public static final String SECUENCE_LENGTH_IS_DIFFERENT = "Secuence length is different. Row:%s, Size:%d ";
    public static final String INVALID_BASE_WAS_DETECTED = "Invalid base was detected. Base:%s - Row: %s ";
    private String[] dna;



    @Override
    public boolean isMutant(String[] dna) throws DNABadStructureException {
        this.dna = dna;
        isValidDNAStructure(dna);
        int size = dna.length;
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                if(foundMutantPattern(i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean foundMutantPattern(int i, int j) {
        return foundHorizontalPattern(i,j,0)
                || foundVerticalPattern(i,j,0)
                || foundDiagonalLeftPattern(i,j,0)
                || foundDiagonalRightPattern(i,j,0);
    }

    private boolean foundHorizontalPattern(int i, int j, int counter) {
        if(j == dna.length-1) {
            return false;
        }
        if(counter==CONSECUTIVE_REPEAT_COUNT-1) {
            return true;
        }
        Character current = dna[i].charAt(j);
        Character next = dna[i].charAt(j+1);
        if(current.equals(next)){
            return foundHorizontalPattern(i,j+1,++counter);
        }else{
            return false;
        }

    }

    private boolean foundVerticalPattern(int i, int j, int counter) {
        if(i == dna.length-1) {
            return false;
        }
        if(counter==CONSECUTIVE_REPEAT_COUNT-1) {
            return true;
        }
        Character current = dna[i].charAt(j);
        Character next = dna[i+1].charAt(j);
        if(current.equals(next)){
            return foundVerticalPattern(i+1,j,++counter);
        }else{
            return false;
        }
    }

    private boolean foundDiagonalLeftPattern(int i, int j, int counter) {
        if((CONSECUTIVE_REPEAT_COUNT-1) - counter > j ){
            return false;
        }
        if((CONSECUTIVE_REPEAT_COUNT-1) - counter > (dna.length-1-i)) {
            return false;
        }
        if(counter==CONSECUTIVE_REPEAT_COUNT-1) {
            return true;
        }
        Character current = dna[i].charAt(j);
        Character next = dna[i+1].charAt(j-1);
        if(current.equals(next)){
            return foundDiagonalLeftPattern(i+1,j-1,++counter);
        }else{
            return false;
        }

    }

    private boolean foundDiagonalRightPattern(int i, int j, int counter) {
        if((CONSECUTIVE_REPEAT_COUNT-1) - counter > dna.length-1-j ){
            return false;
        }
        if((CONSECUTIVE_REPEAT_COUNT-1) - counter > (dna.length-1-i)) {
            return false;
        }
        if(counter==CONSECUTIVE_REPEAT_COUNT-1) {
            return true;
        }
        Character current = dna[i].charAt(j);
        Character next = dna[i+1].charAt(j+1);
        if(current.equals(next)){
            return foundDiagonalRightPattern(i+1,j+1,++counter);
        }else{
            return false;
        }

    }

    private void isValidDNAStructure(String[] dna) throws DNABadStructureException{
        for (int i = 0; i < dna.length; i++) {
            String row = dna[i].toUpperCase();
            if (row.length() != dna.length) {
                throw  new DNABadStructureException(String.format(SECUENCE_LENGTH_IS_DIFFERENT, row, row.length()));
            }
            for (int j = 0; j < row.length(); j++) {
                DNANitrogenousBase base = DNANitrogenousBase.getDNANitrogenousBaseByChar(row.charAt(j));
                if (base == null) {
                    throw new DNABadStructureException(String.format(INVALID_BASE_WAS_DETECTED,row.charAt(j), row));
                }
            }

        }
    }
}
