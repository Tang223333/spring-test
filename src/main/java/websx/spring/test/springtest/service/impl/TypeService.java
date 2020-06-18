package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.mapper.ITypeMapper;
import websx.spring.test.springtest.service.ITypeService;

import java.util.List;

@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeMapper iTypeMapper;

    @Override
    public List<Type> findAllType() {
        return iTypeMapper.findAllType();
    }
}
