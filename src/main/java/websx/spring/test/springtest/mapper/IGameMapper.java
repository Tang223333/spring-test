package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Game;

import java.util.List;

@Repository
public interface IGameMapper {

    @Select("select * from game;")
    List<Game> findAllGame();

    @Select("select * from game where id=#{id};")
    Game findByIdGame(Long id);

    @Insert("insert into game(name,money,describes,download,comment,grade,good,bad,video,img,type,pType,developer,publisher,team,time) values\n" +
            "(#{name},#{money},#{describes},#{download},#{comment},#{grade},#{good},#{bad},#{video},#{img},#{type},#{pType},#{developer},#{publisher},#{team},#{time});")
    void saveGame(Game game);
}
