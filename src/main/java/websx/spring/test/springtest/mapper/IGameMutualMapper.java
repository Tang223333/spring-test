package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.GameMutual;

import java.util.List;

@Repository
public interface IGameMutualMapper {

    @Select("select * from game_mutual;")
    List<GameMutual> findAllGameMutual();
}
