package com.meli.magneto.recluting.dnadetect.enums;

public enum DNANitrogenousBase {

    ADENINE('A'),
    THYMINE('T'),
    CYTOSINE('C'),
    GUANINE('G');

    private char base;

    DNANitrogenousBase(Character base) {
        this.base = base;
    }

    public static DNANitrogenousBase getDNANitrogenousBaseByChar(final Character base)
    {
        for (DNANitrogenousBase type : DNANitrogenousBase.values())
            if (type.base == base) {
                return type;
            }
        return null;
    }
}
