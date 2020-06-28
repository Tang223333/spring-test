package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Game;

import java.util.List;

@Repository
public interface IGameMapper {

    @Select("select * from game ;")
    List<Game> findAllGame();

    @Select("select * from game where id=#{id};")
    Game findByIdGame(Long id);

    @Select("select * from game where name like #{name} ;")
    List<Game> findByLikeNameGame(String name);

    @Select("select * from game where name like #{name} ;")
    Game findByNameGame(String name);

    @Insert("insert into game(name,describes,videos,imgs,types,pType,developer,publisher,team,time,status) values" +
            "(#{name},#{describes},#{videos},#{imgs},#{types},#{pType},#{developer},#{publisher},#{team},#{time},#{status});")
    void saveGame(Game game);

    @Update("update game set name=#{name},describes=#{describes},pType=#{pType}," +
            "developer=#{developer},publisher=#{publisher},team=#{team},time=#{time},status=#{status} where id=#{id};")
    void updateGame(Game game);

    @Delete("delete from game where id=#{id};")
    void deleteGame(Long id);

}
