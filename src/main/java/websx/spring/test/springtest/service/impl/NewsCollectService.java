package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.mapper.INewsCollectMapper;
import websx.spring.test.springtest.service.INewsCollectService;

import java.util.List;

@Service
public class NewsCollectService implements INewsCollectService {

    @Autowired
    private INewsCollectMapper iNewsCollectMapper;

    @Override
    public List<NewsCollect> findAllNewsCollect() {
        return iNewsCollectMapper.findAllNewsCollect();
    }
}
