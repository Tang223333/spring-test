package websx.spring.test.springtest.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.NewsMutual;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface INewsMutualService {

    List<NewsMutual> findAllNewsMutual();

    NewsMutual findByNidNewsMutual(Long nid);

    NewsMutual saveNewsMutual(NewsMutual newsMutual);

    NewsMutual updateNewsMutual(NewsMutual newsMutual);

    NewsMutual deleteNewsMutual(Long nid);
}
