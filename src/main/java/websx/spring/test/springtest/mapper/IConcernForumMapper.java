package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.ConcernForum;

import java.util.List;

@Repository
public interface IConcernForumMapper {

    @Select("select * from game_collect;")
    List<ConcernForum> findAllConcernForum();
}
