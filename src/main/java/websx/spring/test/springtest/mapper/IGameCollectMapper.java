package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.ConcernForum;
import websx.spring.test.springtest.entity.GameCollect;

import java.util.List;

@Repository
public interface IGameCollectMapper {

    @Select("select * from game_collect;")
    List<GameCollect> findAllGameCollect();

    @Select("select * from game_collect where id=#{id};")
    GameCollect findByIdGameCollect(Long id);

    @Select("select * from game_collect where aid=#{aid} ")
    List<GameCollect> findByAidGidGameCollect(Long aid);

    @Insert("insert into game_collect(gid,aid,time)" +
            "values(#{gid},#{aid},#{time});")
    void saveGameCollect(GameCollect gameCollect);

    @Delete("delete from game_collect where id=#{id};")
    void deleteGameCollect(Long id);
}
