package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Game;

import java.util.List;

@Repository
public interface IGameMapper {

    @Select("select * from game;")
    List<Game> findAllGame();
}
