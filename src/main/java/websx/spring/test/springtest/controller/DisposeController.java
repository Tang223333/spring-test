package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Dispose;
import websx.spring.test.springtest.service.impl.DisposeService;
import websx.spring.test.springtest.utils.JsonUtils;

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
}
