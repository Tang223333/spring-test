package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.entity.NewsCollect;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface INewsCollectService {

    List<NewsCollect> findAllNewsCollect();

    NewsCollect findByIdNewsCollect(Long id);

    List<NewsCollect> findByNidNewsCollect(Long nid);

    List<NewsCollect> findByAidNewsCollect(Long aid);

    NewsCollect findByNidAidNewsCollect(Long nid,Long aid);

    NewsCollect saveNewsCollect(NewsCollect newsCollect);

    NewsCollect deleteNewsCollect(Long id);
}
