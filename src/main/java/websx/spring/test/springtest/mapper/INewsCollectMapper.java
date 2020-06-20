package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.entity.NewsCollect;

import java.util.List;

@Repository
public interface INewsCollectMapper {

    @Select("select * from news_collect;")
    List<NewsCollect> findAllNewsCollect();

    @Select("select * from news_collect where id=#{id};")
    NewsCollect findByIdNewsCollect(Long id);

    @Select("select * from news_collect where nid=#{nid};")
    List<NewsCollect> findByNidNewsCollect(Long nid);

    @Select("select * from news_collect where aid=#{aid};")
    List<NewsCollect> findByAidNewsCollect(Long aid);

    @Select("select * from news_collect where nid=#{nid} and aid=#{aid};")
    NewsCollect findByNidAidNewsCollect(Long nid,Long aid);

    @Insert("insert into news_collect(nid,aid,time)" +
            "values(#{nid},#{aid},#{time});")
    void saveNewsCollect(NewsCollect newsCollect);

    @Delete("delete from news_collect where id=#{id};")
    void deleteNewsCollect(Long id);
}
