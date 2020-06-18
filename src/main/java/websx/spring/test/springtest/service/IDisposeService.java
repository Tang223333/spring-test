package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.mapper.IDisposeMapper;

@Transactional(propagation = Propagation.REQUIRED)
public interface IDisposeService {

    Dispose findByGidDispose(Long gid);

    Dispose saveDispose(Dispose dispose);
}
