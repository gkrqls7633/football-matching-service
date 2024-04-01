package com.mateam.application.biz.sample.port.out;

import com.mateam.application.adapter.out.persistence.sample.entity.SampleEntity;

public interface SamplePersistenceOutPort {
    String getSample(SampleEntity sampleEntity);
}
