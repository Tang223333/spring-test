package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.ConcernForum;

import java.util.List;

@Repository
public interface IConcernForumMapper {

    @Select("select * from concern_forum;")
    List<ConcernForum> findAllConcernForum();

    @Select("select * from concern_forum where id=#{id};")
    ConcernForum findByIdConcernForum(Long id);

    @Select("select * from concern_forum where aid=#{aid}")
    List<ConcernForum> findByAidConcernForum(Long aid);

    @Select("select * from concern_forum where gid=#{gid}")
    List<ConcernForum> findByGidConcernForum(Long gid);

    @Select("select * from concern_forum where aid=#{aid} and gid=#{gid}")
    ConcernForum findByAidGidConcernForum(Long aid,Long gid);

    @Insert("insert into concern_forum(gid,aid,time)" +
            "values(#{gid},#{aid},#{time});")
    void saveConcernForum(ConcernForum concernForum);

    @Delete("delete from concern_forum where id=#{id};")
    void deleteConcernForum(Long id);
}
