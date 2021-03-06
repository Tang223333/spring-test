package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.News;
import websx.spring.test.springtest.mapper.INewsMapper;
import websx.spring.test.springtest.service.INewsService;

import java.util.List;

@Service
public class NewsService implements INewsService {

    @Autowired
    private INewsMapper iNewsMapper;


    @Override
    public List<News> findAllNews() {
        return iNewsMapper.findAllNews();
    }

    @Override
    public List<News> findAll2News(Integer page) {
        page=(page-1)*10;
        return iNewsMapper.findAll2News(page);
    }

    @Override
    public News findByIdNews(Long id) {
        return iNewsMapper.findByIdNews(id);
    }

    @Override
    public List<News> findByAidNews(Long aid) {
        return iNewsMapper.findByAidNews(aid);
    }

    @Override
    public News findByTitleNews(String title) {
        return iNewsMapper.findByTitleNews(title);
    }

    @Override
    public List<News> findByLikeTitleNews(String title) {
        return iNewsMapper.findByLikeTitleNews(title);
    }

    @Override
    public News findByAidTitleNews(Long aid, String title) {
        return iNewsMapper.findByAidTitleNews(aid,title);
    }

    @Override
    public News saveNews(News news) {
        iNewsMapper.saveNews(news);
        news=iNewsMapper.findAllNews().get(iNewsMapper.findAllNews().size()-1);
        return news;
    }

    @Override
    public News updateNews(News news) {
        iNewsMapper.updateNews(news);
        news=iNewsMapper.findByIdNews(news.getId());
        return news;
    }

    @Override
    public News deleteNews(Long id) {
        News news=iNewsMapper.findByIdNews(id);
        iNewsMapper.deleteNews(id);
        return news;
    }
}
