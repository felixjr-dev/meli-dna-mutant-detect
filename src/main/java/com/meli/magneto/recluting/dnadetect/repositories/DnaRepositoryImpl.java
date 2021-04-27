package com.meli.magneto.recluting.dnadetect.repositories;

import com.meli.magneto.recluting.dnadetect.model.es.DnaRecord;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class DnaRepositoryImpl implements DnaRepository {

    public static final String DNA_INDEX = "dna";
    public static final String MUTANT_IND = "mutantInd";
    @Qualifier("elasticsearchClient")
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired
    DnaESCustomRepository dnaESCustomRepository;

    @Override
    public Long countMutantsDna(){
        CountRequest countRequest = new CountRequest();
        countRequest.indices(DNA_INDEX);
        countRequest.query(QueryBuilders.termQuery(MUTANT_IND, true));
        try {
            CountResponse countResponse = restHighLevelClient.count(countRequest, RequestOptions.DEFAULT);
            return countResponse.getCount();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Long countHumansDna() {
        CountRequest countRequest = new CountRequest();
        countRequest.indices("dna");
        countRequest.query(QueryBuilders.termQuery(MUTANT_IND, false));
        try {
            CountResponse countResponse = restHighLevelClient.count(countRequest, RequestOptions.DEFAULT);
            return countResponse.getCount();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public <S extends DnaRecord> S save(S entity) {
        return dnaESCustomRepository.save(entity);
    }

}
