package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.mapper.IGameMapper;
import websx.spring.test.springtest.mapper.ITypeVideoImgMapper;
import websx.spring.test.springtest.service.ITypeVideoImgService;

import java.util.List;

@Service
public class TypeVideoImgService implements ITypeVideoImgService {

    @Autowired
    private ITypeVideoImgMapper iTypeVideoImgMapper;

    @Override
    public List<Type> findByKeyType(String tKeys) {
        return iTypeVideoImgMapper.findByKeyType(tKeys);
    }

    @Override
    public List<Video> findByKeyVideo(String vKeys) {
        return iTypeVideoImgMapper.findByKeyVideo(vKeys);
    }

    @Override
    public List<Img> findByKeyImg(String iKeys) {
        return iTypeVideoImgMapper.findByKeyImg(iKeys);
    }
}
