package com.meli.magneto.recluting.dnadetect.model.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "dna")
public class DnaRecord {

    @Id
    private String id;
    private String[] dna;
    private boolean mutantInd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean getMutantInd() {
        return mutantInd;
    }

    public void setMutantInd(boolean mutantInd) {
        this.mutantInd = mutantInd;
    }
}
