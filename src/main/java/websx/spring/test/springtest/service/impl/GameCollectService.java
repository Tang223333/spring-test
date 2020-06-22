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

    @Override
    public GameCollect findByIdGameCollect(Long id) {
        return iGameCollectMapper.findByIdGameCollect(id);
    }

    @Override
    public List<GameCollect> findByAidGameCollect(Long aid) {
        return iGameCollectMapper.findByAidGameCollect(aid);
    }

    @Override
    public List<GameCollect> findByGidGameCollect(Long gid) {
        return iGameCollectMapper.findByGidGameCollect(gid);
    }

    @Override
    public GameCollect findByAidGidGameCollect(Long aid, Long gid) {
        return iGameCollectMapper.findByAidGidGameCollect(aid,gid);
    }

    @Override
    public GameCollect saveGameCollect(GameCollect gameCollect) {
        iGameCollectMapper.saveGameCollect(gameCollect);
        gameCollect=iGameCollectMapper.findAllGameCollect().get(iGameCollectMapper.findAllGameCollect().size()-1);
        return gameCollect;
    }

    @Override
    public GameCollect deleteGameCollect(Long id) {
        GameCollect gameCollect=iGameCollectMapper.findByIdGameCollect(id);
        iGameCollectMapper.deleteGameCollect(id);
        return gameCollect;
    }
}
