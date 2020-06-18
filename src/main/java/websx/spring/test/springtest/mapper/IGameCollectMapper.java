package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.GameCollect;

import java.util.List;

@Repository
public interface IGameCollectMapper {

    @Select("select * from game_collect;")
    List<GameCollect> findAllGameCollect();
}
