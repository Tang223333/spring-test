package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.mapper.IDisposeMapper;
import websx.spring.test.springtest.service.IDisposeService;

import java.util.List;

@Service
public class DisposeService implements IDisposeService {

    @Autowired
    private IDisposeMapper iDisposeMapper;

    @Override
    public List<Dispose> findAllDispose() {
        return iDisposeMapper.findAllDispose();
    }

    @Override
    public Dispose findAllByGidDispose(Long gid) {
        return iDisposeMapper.findByGidDispose(gid);
    }

    @Override
    public Dispose saveDispose(Dispose dispose) {
        iDisposeMapper.saveDispose(dispose);
        dispose=iDisposeMapper.findAllDispose().get(iDisposeMapper.findAllDispose().size()-1);
        return dispose;
    }

    @Override
    public Dispose updateDispose(Dispose dispose) {
        iDisposeMapper.updateDispose(dispose);
        dispose=iDisposeMapper.findByGidDispose(dispose.getGid());
        return dispose;
    }

    @Override
    public Dispose deleteDispose(Long gid) {
        Dispose dispose=iDisposeMapper.findByGidDispose(gid);
        iDisposeMapper.deleteDispose(gid);
        return dispose;
    }
}
