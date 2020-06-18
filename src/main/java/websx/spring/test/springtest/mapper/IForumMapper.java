package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Forum;

import java.util.List;

@Repository
public interface IForumMapper {

    @Select("select * from forum;")
    List<Forum> findAllForum();
}
