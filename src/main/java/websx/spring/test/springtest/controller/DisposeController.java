package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.service.impl.DisposeService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/dispose")
@RestController
public class DisposeController {

    @Autowired
    private DisposeService disposeService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllDispose(){
        List<Dispose> allDispose = disposeService.findAllDispose();
        return JsonUtils.getJson(allDispose,allDispose!=null?0:1);
    }

    @RequestMapping(value = "/findByGid",method = RequestMethod.POST)
    public Map<String,Object> findByGidDispose(@PathParam("gid") Long gid){
        Dispose allByGidDispose = disposeService.findAllByGidDispose(gid);
        return JsonUtils.getJson(allByGidDispose,allByGidDispose!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveDispose(@PathParam("gid") Long gid,
                                          @PathParam("systemDown") String systemDown,
                                          @PathParam("handlerDown") String handlerDown,
                                          @PathParam("ramDown") String ramDown,
                                          @PathParam("gpuDown") String gpuDown,
                                          @PathParam("storeDown") String storeDown,
                                          @PathParam("deviceDown") String deviceDown,
                                          @PathParam("systemUp") String systemUp,
                                          @PathParam("handlerUp") String handlerUp,
                                          @PathParam("ramUp") String ramUp,
                                          @PathParam("gpuUp") String gpuUp,
                                          @PathParam("storeUp") String storeUp,
                                          @PathParam("deviceUp") String deviceUp,
                                          @PathParam("care") String care){
        Dispose dispose=disposeService.findAllByGidDispose(gid);
        if (dispose!=null){
            return JsonUtils.getJson(dispose,1);
        }else {
            dispose=Dispose.builder().gid(gid).systemDown(systemDown).handlerDown(handlerDown).ramDown(ramDown).gpuDown(gpuDown).storeDown(storeDown).deviceDown(deviceDown)
                    .systemUp(systemUp).handlerUp(handlerUp).ramUp(ramUp).gpuUp(gpuUp).storeUp(storeUp).deviceUp(deviceUp).care(care).build();
            dispose = disposeService.saveDispose(dispose);
            return JsonUtils.getJson(dispose,dispose!=null?0:1);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> updateDispose(@PathParam("gid") Long gid,
                                            @PathParam("systemDown") String systemDown,
                                            @PathParam("handlerDown") String handlerDown,
                                            @PathParam("ramDown") String ramDown,
                                            @PathParam("gpuDown") String gpuDown,
                                            @PathParam("storeDown") String storeDown,
                                            @PathParam("deviceDown") String deviceDown,
                                            @PathParam("systemUp") String systemUp,
                                            @PathParam("handlerUp") String handlerUp,
                                            @PathParam("ramUp") String ramUp,
                                            @PathParam("gpuUp") String gpuUp,
                                            @PathParam("storeUp") String storeUp,
                                            @PathParam("deviceUp") String deviceUp,
                                            @PathParam("care") String care){
        Dispose dispose=disposeService.findAllByGidDispose(gid);
        if (dispose==null){
            return JsonUtils.getJson(dispose,1);
        }else {
            dispose=Dispose.builder().gid(gid).systemDown(systemDown).handlerDown(handlerDown).ramDown(ramDown).gpuDown(gpuDown).storeDown(storeDown).deviceDown(deviceDown)
                    .systemUp(systemUp).handlerUp(handlerUp).ramUp(ramUp).gpuUp(gpuUp).storeUp(storeUp).deviceUp(deviceUp).care(care).build();
            dispose = disposeService.updateDispose(dispose);
            return JsonUtils.getJson(dispose,dispose!=null?0:1);
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> deleteDispose(@PathParam("gid") Long gid){
        Dispose allByGidDispose = disposeService.deleteDispose(gid);
        return JsonUtils.getJson(allByGidDispose,allByGidDispose!=null?0:1);
    }
}
