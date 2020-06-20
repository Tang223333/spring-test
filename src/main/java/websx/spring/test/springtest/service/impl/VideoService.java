package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Img;
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

    @Override
    public Video findByIdVideo(Long id) {
        return iVideoMapper.findByIdVideo(id);
    }

    @Override
    public List<Video> findByKeyVideo(String vKeys) {
        return iVideoMapper.findByKeyVideo(vKeys);
    }


    @Override
    public Video saveVideo(Video video) {
        iVideoMapper.saveVideo(video);
        video=iVideoMapper.findAllVideo().get(iVideoMapper.findAllVideo().size()-1);
        return video;
    }

    @Override
    public Video deleteByIdVideo(Long id) {
        Video video=iVideoMapper.findByIdVideo(id);
        iVideoMapper.deleteByIdVideo(id);
        return video;
    }

    @Override
    public List<Video> deleteByKeyVideo(String vKeys) {
        List<Video> videos=iVideoMapper.findByKeyVideo(vKeys);
        iVideoMapper.deleteByKeyVideo(vKeys);
        return videos;
    }

}
