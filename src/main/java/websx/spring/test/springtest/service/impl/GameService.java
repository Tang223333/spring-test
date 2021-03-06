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
    public List<Game> find20Game() {
        return iGameMapper.find20Game();
    }

    @Override
    public Game findByIdGame(Long id) {
        return iGameMapper.findByIdGame(id);
    }

    @Override
    public List<Game> findByLikeNameGame(String name) {
        return iGameMapper.findByLikeNameGame(name);
    }

    @Override
    public Game findByNameGame(String name) {
        return iGameMapper.findByNameGame(name);
    }

    @Override
    public Game findByImgGame(String imgs) {
        return iGameMapper.findByImgGame(imgs);
    }

    @Override
    public Game findByVideoGame(String videos) {
        return iGameMapper.findByVideoGame(videos);
    }

    @Override
    public Game findByTypeGame(String types) {
        return iGameMapper.findByTypeGame(types);
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
