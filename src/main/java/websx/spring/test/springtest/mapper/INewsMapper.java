package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.News;

import java.util.List;

@Repository
public interface INewsMapper {

    @Select("select * from news;")
    List<News> findAllNews();

    @Select("select * from news where id=#{id};")
    News findByIdNews(Long id);

    @Select("select * from news where aid=#{aid};")
    List<News> findByAidNews(Long aid);

    @Insert("insert into news(aid,title,writer,time,content,videos,imgs,ip) values" +
            "(#{aid},#{title},#{writer},#{time},#{content},#{videos},#{imgs},#{ip})")
    void saveNews(News news);

    @Update("update news set aid=#{aid},title=#{title},writer=#{writer},time=#{time},content=#{content},videos=#{videos},imgs=#{imgs},ip=#{ip} where id=#{id};")
    void updateNews(News news);

    @Delete("delete from news where id=#{id};")
    void deleteNews(Long id);
}
