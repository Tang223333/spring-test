package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;
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

    @Override
    public Type findByIdType(Long id) {
        return iTypeMapper.findByIdType(id);
    }

    @Override
    public List<Type> findByKeyType(String tKeys) {
        return iTypeMapper.findAllKeyType(tKeys);
    }

    @Override
    public List<Type> findByValueType(String value) {
        return iTypeMapper.findByValueType(value);
    }

    @Override
    public List<Type> findByValueType2(String value,Integer page) {
        page=(page-1)*5;
        return iTypeMapper.findByValueType2(value,page);
    }

    @Override
    public Type saveType(Type type) {
        iTypeMapper.saveType(type);
        type=iTypeMapper.findAllType().get(iTypeMapper.findAllType().size()-1);
        return type;
    }

    @Override
    public Type deleteByIdType(Long id) {
        Type type=iTypeMapper.findByIdType(id);
        iTypeMapper.deleteByIdType(id);
        return type;
    }

    @Override
    public List<Type> deleteByKeyType(String tKeys) {
        List<Type> types=iTypeMapper.findAllKeyType(tKeys);
        iTypeMapper.deleteByKeyType(tKeys);
        return types;
    }
}
