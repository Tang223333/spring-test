package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.entity.GameMutual;
import websx.spring.test.springtest.mapper.IGameCommentMapper;
import websx.spring.test.springtest.mapper.IGameMutualMapper;
import websx.spring.test.springtest.service.IGameMutualService;

import java.util.List;

@Service
public class GameMutualService implements IGameMutualService {

    @Autowired
    private IGameMutualMapper iGameMutualMapper;

    @Override
    public List<GameMutual> findAllGameMutual() {
        return iGameMutualMapper.findAllGameMutual();
    }
}
