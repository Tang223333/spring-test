package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Game;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IGameService {

    List<Game> findAllGame();

    Game findByIdGame(Long id);

    List<Game> findByLikeNameGame(String name);

    Game findByNameGame(String name);

    Game saveGame(Game game);

    Game updateGame(Game game);

    Game deleteGame(Long id);
}
