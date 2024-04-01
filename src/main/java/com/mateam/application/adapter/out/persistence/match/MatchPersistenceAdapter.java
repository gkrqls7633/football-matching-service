package com.mateam.application.adapter.out.persistence.match;

import com.mateam.application.adapter.out.persistence.match.entity.MatchEntity;
import com.mateam.application.biz.match.port.out.MatchOutPort;
import com.mateam.application.domain.match.MatchRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@RequiredArgsConstructor
@Component
public class MatchPersistenceAdapter implements MatchOutPort {

    private final ReadMatchRepository readMatchRepository;
    private final WriteMatchRepository writeMatchRepository;
    @Override
    public String selectMatch() {

        return readMatchRepository.selectMatch();
    }

    @Override
    public List<Map<String, Object>> selectMatchList() {
        List<Map<String, Object>> resultList = readMatchRepository.selectMatchList();

        // 이 부분에서 필요한 가공 작업을 수행할 수 있습니다.
        // 예를 들어, 리스트의 첫 번째 결과만 가져와서 사용할 수 있습니다.
//        Map<String, Object> resultMap = new HashMap<>();
//        if (!resultList.isEmpty()) {
//            resultMap = resultList.get(0);
//        }

        return resultList;
    }

    @Override
    public String insertMatch(MatchEntity matchEntity) {
        return writeMatchRepository.insertMatch(matchEntity);
    }


}
