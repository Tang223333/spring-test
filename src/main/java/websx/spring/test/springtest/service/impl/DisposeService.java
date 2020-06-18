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
}
