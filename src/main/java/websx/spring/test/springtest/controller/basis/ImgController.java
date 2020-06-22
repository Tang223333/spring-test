package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.service.impl.ImgService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/img")
@RestController
public class ImgController {

    @Autowired
    private ImgService imgService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllVideo(){
        List<Img> imgs = imgService.findAllImg();
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdImg(@PathParam("id") Long id){
        Img img = imgService.findByIdImg(id);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/findByKey",method = RequestMethod.POST)
    public Map<String,Object> findByKeyImg(@PathParam("iKeys") String iKeys){
        System.out.println(iKeys);
        List<Img> imgs = imgService.findByKeyImg(iKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveImg(@PathParam("iKeys") String iKeys,
                                      @PathParam("value") String value){
        Img img=Img.builder().iKeys(iKeys).value(value).build();
        img=imgService.saveImg(img);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Map<String,Object> deleteByIdImg(@PathParam("id") Long id){
        Img img = imgService.deleteByIdImg(id);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.POST)
    public Map<String,Object> deleteImg(@PathParam("iKeys")String iKeys){
        List<Img> imgs = imgService.deleteByKeyImg(iKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }
}
