package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Dispose;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IDisposeService {

    List<Dispose> findAllDispose();

    Dispose findAllByGidDispose(Long gid);

    Dispose saveDispose(Dispose dispose);

    Dispose updateDispose(Dispose dispose);

    Dispose deleteDispose(Long gid);
}
