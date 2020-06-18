package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.NewsCollect;

import java.util.List;

@Repository
public interface INewsCollectMapper {

    @Select("select * from news_collect;")
    List<NewsCollect> findAllNewsCollect();
}
