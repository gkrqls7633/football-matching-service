package com.mateam.application.biz.sample.service;

import com.mateam.application.adapter.out.persistence.sample.entity.SampleEntity;
import com.mateam.application.biz.sample.port.in.SampleInPort;
import com.mateam.application.biz.sample.port.out.SamplePersistenceOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService implements SampleInPort {

    private final SamplePersistenceOutPort samplePersistenceOutPort;

    @Autowired
    public SampleService(SamplePersistenceOutPort samplePersistenceOutPort) {
        this.samplePersistenceOutPort = samplePersistenceOutPort;
    }


    @Override
    public String selectSample(String dgctPtrStfSum) {

        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setDgctPtrStfNum(dgctPtrStfSum);

        String res = samplePersistenceOutPort.getSample(sampleEntity);

        return res;
    }

}
