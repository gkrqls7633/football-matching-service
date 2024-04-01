package com.mateam.application.adapter.out.persistence.sample;


import com.mateam.application.adapter.out.persistence.sample.entity.SampleEntity;
import com.mateam.config.annotation.ReadDatabase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@ReadDatabase
//@Mapper
public interface ReadSampleRepository {
    String getSample(SampleEntity sampleEntity);
}
