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

    @Override
    public NewsCollect findByIdNewsCollect(Long id) {
        return iNewsCollectMapper.findByIdNewsCollect(id);
    }

    @Override
    public List<NewsCollect> findByNidNewsCollect(Long nid) {
        return iNewsCollectMapper.findByNidNewsCollect(nid);
    }

    @Override
    public List<NewsCollect> findByAidNewsCollect(Long aid) {
        return iNewsCollectMapper.findByAidNewsCollect(aid);
    }

    @Override
    public NewsCollect findByNidAidNewsCollect(Long nid, Long aid) {
        return iNewsCollectMapper.findByNidAidNewsCollect(nid,aid);
    }

    @Override
    public NewsCollect saveNewsCollect(NewsCollect newsCollect) {
        iNewsCollectMapper.saveNewsCollect(newsCollect);
        newsCollect=iNewsCollectMapper.findAllNewsCollect().get(iNewsCollectMapper.findAllNewsCollect().size()-1);
        return newsCollect;
    }

    @Override
    public NewsCollect deleteNewsCollect(Long id) {
        NewsCollect newsCollect=iNewsCollectMapper.findByIdNewsCollect(id);
        iNewsCollectMapper.deleteNewsCollect(id);
        return newsCollect;
    }
}
