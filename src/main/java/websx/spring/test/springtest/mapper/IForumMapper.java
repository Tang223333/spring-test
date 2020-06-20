package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Forum;

import java.util.List;

@Repository
public interface IForumMapper {

    @Select("select * from forum;")
    List<Forum> findAllForum();

    @Select("select * from forum where id=#{id};")
    Forum findByIdForum(Long id);

    @Select("select * from forum where aid=#{aid};")
    List<Forum> findByAidForum(Long aid);

    @Select("select * from forum where name=#{name};")
    Forum findByNameForum(String name);

    @Insert("insert into forum(aid,concerns,invitations,views,name,logo,ip) values" +
            "(#{aid},#{concerns},#{invitations},#{views},#{name},#{logo},#{ip});")
    void saveForum(Forum forum);

    @Update("update forum set aid=#{aid},concerns=#{concerns},invitations=#{invitations},views=#{views}," +
            "name=#{name},logo=#{logo},ip=#{ip} where id=#{id};")
    void updateForum(Forum forum);

    @Delete("delete from forum where id=#{id};")
    void deleteForum(Long id);
}
