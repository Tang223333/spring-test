package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.NewsCollect;
import websx.spring.test.springtest.entity.NewsMutual;
import websx.spring.test.springtest.mapper.INewsMutualMapper;
import websx.spring.test.springtest.service.INewsCollectService;
import websx.spring.test.springtest.service.INewsMutualService;

import java.util.List;

@Service
public class NewsMutualService implements INewsMutualService {

    @Autowired
    private INewsMutualMapper iNewsMutualMapper;

    @Override
    public List<NewsMutual> findAllNewsMutual() {
        return iNewsMutualMapper.findAllNewsMutual();
    }

    @Override
    public NewsMutual findByNidNewsMutual(Long nid) {
        return iNewsMutualMapper.findByNidNewsMutual(nid);
    }

    @Override
    public NewsMutual saveNewsMutual(NewsMutual newsMutual) {
        iNewsMutualMapper.saveNewsMutual(newsMutual);
        newsMutual=iNewsMutualMapper.findAllNewsMutual().get(iNewsMutualMapper.findAllNewsMutual().size()-1);
        return newsMutual;
    }

    @Override
    public NewsMutual updateNewsMutual(NewsMutual newsMutual) {
        iNewsMutualMapper.updateNewsMutual(newsMutual);
        newsMutual=iNewsMutualMapper.findByNidNewsMutual(newsMutual.getNid());
        return newsMutual;
    }

    @Override
    public NewsMutual deleteNewsMutual(Long nid) {
        NewsMutual newsMutual=iNewsMutualMapper.findByNidNewsMutual(nid);
        iNewsMutualMapper.deleteNewsMutual(nid);
        return newsMutual;
    }
}
