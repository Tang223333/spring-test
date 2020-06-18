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
}
