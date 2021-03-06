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

    @Select("select * from news order by id limit #{page},10;")
    List<News> findAll2News(Integer page);

    @Select("select * from news where id=#{id};")
    News findByIdNews(Long id);

    @Select("select * from news where aid=#{aid};")
    List<News> findByAidNews(Long aid);

    @Select("select * from news where title=#{title};")
    News findByTitleNews(String title);

    @Select("select * from news where title like #{title};")
    List<News> findByLikeTitleNews(String title);

    @Select("select * from news where aid=#{aid} and title=#{title};")
    News findByAidTitleNews(Long aid,String title);

    @Insert("insert into news(aid,title,writer,time,content,videos,imgs,ip,status) values" +
            "(#{aid},#{title},#{writer},#{time},#{content},#{videos},#{imgs},#{ip},#{status})")
    void saveNews(News news);

    @Update("update news set aid=#{aid},title=#{title},writer=#{writer},time=#{time},content=#{content},videos=#{videos},imgs=#{imgs},ip=#{ip},status=#{status} where id=#{id};")
    void updateNews(News news);

    @Delete("delete from news where id=#{id};")
    void deleteNews(Long id);
}
