package com.mateam.application.adapter.out.persistence.sample;

import com.mateam.application.adapter.out.persistence.sample.entity.SampleEntity;
import com.mateam.application.biz.sample.port.out.SamplePersistenceOutPort;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
@RequiredArgsConstructor
@Component
public class SamplePersistenceAdapter implements SamplePersistenceOutPort {

    private final ReadSampleRepository readSampleRepository;

    @Override
    public String getSample(SampleEntity sampleEntity) {

        return readSampleRepository.getSample(sampleEntity);
    }
}
