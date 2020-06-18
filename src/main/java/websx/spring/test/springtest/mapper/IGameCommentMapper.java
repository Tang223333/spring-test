package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.GameComment;

import java.util.List;

@Repository
public interface IGameCommentMapper {

    @Select("select * from game_comment;")
    List<GameComment> findAllGameComment();
}
