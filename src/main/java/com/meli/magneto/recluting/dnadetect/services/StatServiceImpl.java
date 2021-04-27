package com.meli.magneto.recluting.dnadetect.services;

import com.meli.magneto.recluting.dnadetect.exceptions.StatCalculationException;
import com.meli.magneto.recluting.dnadetect.model.rest.DnaAnalyzeStat;
import com.meli.magneto.recluting.dnadetect.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService{

    @Autowired
    DnaRepository dnaRepository;

    @Override
    public DnaAnalyzeStat getStat() throws StatCalculationException {
        DnaAnalyzeStat stat = new DnaAnalyzeStat();
        Long mutantCount = dnaRepository.countMutantsDna();
        Long humansCount = dnaRepository.countHumansDna();
        if(mutantCount==null || humansCount==null){
            throw new StatCalculationException("Error when calculate stat");
        }
        Double ratio =  humansCount==0L? 0d: mutantCount*1d/humansCount;
        stat.setCountHumanDna(humansCount);
        stat.setCountMutantDna(mutantCount);
        stat.setRatio(ratio);
        return stat;
    }
}
