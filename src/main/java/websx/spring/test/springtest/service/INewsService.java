package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.News;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface INewsService {

    List<News> findAllNews();

    List<News> findAll2News(Integer page);

    News findByIdNews(Long id);

    List<News> findByAidNews(Long aid);

    News findByTitleNews(String title);

    List<News> findByLikeTitleNews(String title);

    News findByAidTitleNews(Long aid,String title);

    News saveNews(News news);

    News updateNews(News news);

    News deleteNews(Long id);
}
