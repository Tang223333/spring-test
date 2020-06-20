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

    @Override
    public GameMutual findByGidGameMutual(Long gid) {
        return iGameMutualMapper.findByGidGameMutual(gid);
    }

    @Override
    public GameMutual saveGameMutual(GameMutual gameMutual) {
        iGameMutualMapper.saveGameMutual(gameMutual);
        gameMutual=iGameMutualMapper.findAllGameMutual().get(iGameMutualMapper.findAllGameMutual().size()-1);
        return gameMutual;
    }

    @Override
    public GameMutual updateGameMutual(GameMutual gameMutual) {
        iGameMutualMapper.updateGameMutual(gameMutual);
        gameMutual=iGameMutualMapper.findByGidGameMutual(gameMutual.getGid());
        return gameMutual;
    }

    @Override
    public GameMutual deleteGameMutual(Long gid) {
        GameMutual gameMutual=iGameMutualMapper.findByGidGameMutual(gid);
        iGameMutualMapper.deleteGameMutual(gid);
        return gameMutual;
    }
}
