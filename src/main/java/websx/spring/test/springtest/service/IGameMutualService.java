package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.entity.GameComment;
import websx.spring.test.springtest.entity.GameMutual;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IGameMutualService {

    List<GameMutual> findAllGameMutual();
}
