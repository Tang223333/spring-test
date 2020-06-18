package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.GameCollect;
import websx.spring.test.springtest.mapper.IGameCollectMapper;
import websx.spring.test.springtest.service.IGameCollectService;

import java.util.List;

@Service
public class GameCollectService implements IGameCollectService {

    @Autowired
    private IGameCollectMapper iGameCollectMapper;


    @Override
    public List<GameCollect> findAllGameCollect() {
        return iGameCollectMapper.findAllGameCollect();
    }
}
