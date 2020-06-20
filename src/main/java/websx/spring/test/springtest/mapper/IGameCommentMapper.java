package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.GameComment;

import java.util.List;

@Repository
public interface IGameCommentMapper {

    @Select("select * from game_comment;")
    List<GameComment> findAllGameComment();

    @Select("select * from game_comment where id=#{id};")
    GameComment findByIdGameComment(Long id);

    @Select("select * from game_comment where gid=#{gid};")
    List<GameComment> findByGidGameComment(Long gid);

    @Select("select * from game_comment where aid=#{aid};")
    List<GameComment> findByAidGameComment(Long aid);

    @Insert("insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) " +
            "values(#{gid},#{aid},#{content},#{goodOrBad},#{grade},#{ip},#{time});")
    void saveGameComment(GameComment gameComment);

    @Update("update game_comment set gid=#{gid},aid=#{aid},content=#{content},goodOrBad=#{goodOrBad}" +
            ",grade=#{grade},ip=#{ip},time=#{time} where id=#{id};")
    void updateGameComment(GameComment gameComment);

    @Delete("delete from game_comment where id=#{id};")
    void deleteGameComment(Long id);
}
