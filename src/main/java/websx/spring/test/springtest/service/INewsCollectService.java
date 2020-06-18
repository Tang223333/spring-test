package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.NewsCollect;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface INewsCollectService {

    List<NewsCollect> findAllNewsCollect();
}
