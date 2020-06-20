package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Type;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface ITypeService {

    List<Type> findAllType();

    Type findByIdType(Long id);

    List<Type> findByKeyType(String tKeys);

    Type saveType(Type type);

    Type deleteByIdType(Long id);

    List<Type> deleteByKeyType(String tKeys);
}
