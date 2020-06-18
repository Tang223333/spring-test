package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.mapper.IGameMapper;
import websx.spring.test.springtest.service.IGameService;

import java.util.List;

@Service
public class GameService implements IGameService {

    @Autowired
    private IGameMapper iGameMapper;

    @Override
    public List<Game> findAllGame() {
        return iGameMapper.findAllGame();
    }
}
