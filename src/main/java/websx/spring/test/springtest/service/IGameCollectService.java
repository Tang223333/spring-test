package websx.spring.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.ConcernForum;
import websx.spring.test.springtest.entity.GameCollect;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IGameCollectService {

    List<GameCollect> findAllGameCollect();

    GameCollect findByIdGameCollect(Long id);

    List<GameCollect> findByAidGameCollect(Long aid);

    List<GameCollect> findByGidGameCollect(Long gid);

    GameCollect findByAidGidGameCollect(Long aid,Long gid);

    GameCollect saveGameCollect(GameCollect gameCollect);

    GameCollect deleteGameCollect(Long id);
}
