package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.mapper.ITypeMapper;
import websx.spring.test.springtest.mapper.IVideoMapper;
import websx.spring.test.springtest.service.ITypeService;
import websx.spring.test.springtest.service.IVideoService;

import java.util.List;

@Service
public class VideoService implements IVideoService {

    @Autowired
    private IVideoMapper iVideoMapper;


    @Override
    public List<Video> findAllVideo() {
        return iVideoMapper.findAllVideo();
    }
}
