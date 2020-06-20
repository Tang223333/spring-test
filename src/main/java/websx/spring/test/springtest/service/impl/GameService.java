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

    @Override
    public Game findByIdGame(Long id) {
        return iGameMapper.findByIdGame(id);
    }

    @Override
    public List<Game> findByNameGame(String name) {
        return iGameMapper.findByNameGame(name);
    }

    @Override
    public Game saveGame(Game game) {
        iGameMapper.saveGame(game);
        game=iGameMapper.findAllGame().get(iGameMapper.findAllGame().size()-1);
        return game;
    }

    @Override
    public Game updateGame(Game game) {
        iGameMapper.updateGame(game);
        game=iGameMapper.findByIdGame(game.getId());
        return game;
    }

    @Override
    public Game deleteGame(Long id) {
        Game game=iGameMapper.findByIdGame(id);
        iGameMapper.deleteGame(id);
        return game;
    }

}
