package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.GameMutual;

import java.util.List;

@Repository
public interface IGameMutualMapper {

    @Select("select * from game_mutual;")
    List<GameMutual> findAllGameMutual();

    @Select("select * from game_mutual where gid=#{gid}")
    GameMutual findByGidGameMutual(Long gid);

    @Insert("insert into game_mutual(gid,collects,comments,grades,goods,bads)" +
            "values(#{gid},#{collects},#{comments},#{grades},#{goods},#{bads});")
    void saveGameMutual(GameMutual gameMutual);

    @Update("update game_mutual set collects=#{collects},comments=#{comments}" +
            ",grades=#{grades},goods=#{goods},bads=#{bads} where gid=#{gid};")
    void updateGameMutual(GameMutual gameMutual);

    @Delete("delete from game_mutual where gid=#{gid};")
    void deleteGameMutual(Long gid);
}
