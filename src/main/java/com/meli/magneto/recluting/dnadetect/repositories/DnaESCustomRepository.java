package com.meli.magneto.recluting.dnadetect.repositories;

import com.meli.magneto.recluting.dnadetect.model.es.DnaRecord;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;

public interface DnaESCustomRepository extends ElasticsearchRepository<DnaRecord, String> {
    @Async
    <S extends DnaRecord> S save(S entity);

}
