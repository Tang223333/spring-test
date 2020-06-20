package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.News;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface INewsService {

    List<News> findAllNews();

    News findByIdNews(Long id);

    List<News> findByAidNews(Long aid);

    News saveNews(News news);

    News updateNews(News news);

    News deleteNews(Long id);
}
