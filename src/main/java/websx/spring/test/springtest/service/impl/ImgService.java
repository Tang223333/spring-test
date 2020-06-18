package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.mapper.IImgMapper;
import websx.spring.test.springtest.service.IImgService;

import java.util.List;

@Service
public class ImgService implements IImgService {

    @Autowired
    private IImgMapper iImgMapper;

    @Override
    public List<Img> findAllImg() {
        return iImgMapper.findAllImg();
    }
}
