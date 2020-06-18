package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.mapper.IDisposeMapper;
import websx.spring.test.springtest.service.IDisposeService;

@Service
public class DisposeService implements IDisposeService {

    @Autowired
    private IDisposeMapper iDisposeMapper;

    @Override
    public Dispose findByGidDispose(Long gid) {
        return iDisposeMapper.findByGidDispose(gid);
    }

    @Override
    public Dispose saveDispose(Dispose dispose) {
        iDisposeMapper.saveDispose(dispose);
        dispose=iDisposeMapper.findByGidDispose(dispose.getGid());
        return dispose;
    }
}
