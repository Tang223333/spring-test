package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.News;

import java.util.List;

@Repository
public interface INewsMapper {

    @Select("select * from news;")
    List<News> findAllNews();
}
