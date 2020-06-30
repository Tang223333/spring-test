package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Game;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IGameService {

    List<Game> findAllGame();

    List<Game> find20Game();

    Game findByIdGame(Long id);

    List<Game> findByLikeNameGame(String name);

    Game findByNameGame(String name);

    Game findByImgGame(String imgs);

    Game findByVideoGame(String videos);

    Game findByTypeGame(String types);

    Game saveGame(Game game);

    Game updateGame(Game game);

    Game deleteGame(Long id);
}
