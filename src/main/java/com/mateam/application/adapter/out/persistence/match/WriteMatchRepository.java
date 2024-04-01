package com.mateam.application.adapter.out.persistence.match;

import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.domain.match.MatchRequest;
import com.mateam.config.annotation.WriteDatabase;

@WriteDatabase
public interface WriteMatchRepository {

    String insertMatch(MatchEntity matchEntity);

}
