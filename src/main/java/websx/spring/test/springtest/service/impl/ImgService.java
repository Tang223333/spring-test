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

    @Override
    public Img findByIdImg(Long id) {
        return iImgMapper.findByIdImg(id);
    }

    @Override
    public List<Img> findByKeyImg(String iKeys) {
        return iImgMapper.findByKeyImg(iKeys);
    }

    @Override
    public Img saveImg(Img img) {
        iImgMapper.saveImg(img);
        img=iImgMapper.findAllImg().get(iImgMapper.findAllImg().size()-1);
        return img;
    }

    @Override
    public Img deleteByIdImg(Long id) {
        Img img=iImgMapper.findByIdImg(id);
        iImgMapper.deleteByIdImg(id);
        return img;
    }

    @Override
    public List<Img> deleteImg(String iKeys) {
        List<Img> imgs=iImgMapper.findByKeyImg(iKeys);
        iImgMapper.deleteByKeyImg(iKeys);
        return imgs;
    }


}
