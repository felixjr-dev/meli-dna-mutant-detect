package com.meli.magneto.recluting.dnadetect.repositories;

import com.meli.magneto.recluting.dnadetect.model.es.DnaRecord;

public interface DnaRepository{

    Long countMutantsDna();

    Long countHumansDna();

    <S extends DnaRecord> S save(S entity);
}
