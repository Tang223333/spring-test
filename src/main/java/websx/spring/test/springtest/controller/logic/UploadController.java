package websx.spring.test.springtest.controller.logic;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RequestMapping("/upload")
@RestController
public class UploadController {

    @PostMapping("/alogo")
    public String uploadALogo(MultipartFile file, HttpServletRequest request){
        //获取项目classes/static的地址
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        staticPath=staticPath.replace("/target/classes/","/src/main/resources/");
        staticPath = staticPath.substring(1, staticPath.length());
        String fileName = file.getOriginalFilename();  //获取文件名

        // 图片存储目录及图片名称
        String url_path = "logo/account" + File.separator + fileName;
        url_path=url_path.replace("\\","/");
        //图片保存路径
        String savePath = staticPath + File.separator + url_path;
        savePath=savePath.replace("\\","/");
        System.out.println("图片保存地址："+savePath);
        // 访问路径=静态资源路径+文件目录路径
        String visitPath ="" + url_path;
        visitPath=visitPath.replace("\\","/");
        System.out.println("图片访问uri："+visitPath);
        File saveFile = new File(savePath);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitPath;
    }

    @PostMapping("/flogo")
    public String uploadFLogo(MultipartFile file, HttpServletRequest request){
        //获取项目classes/static的地址
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        staticPath=staticPath.replace("/target/classes/","/src/main/resources/");
        staticPath = staticPath.substring(1, staticPath.length());
        String fileName = file.getOriginalFilename();  //获取文件名

        // 图片存储目录及图片名称
        String url_path = "logo/forum" + File.separator + fileName;
        url_path=url_path.replace("\\","/");
        //图片保存路径
        String savePath = staticPath + File.separator + url_path;
        savePath=savePath.replace("\\","/");
        System.out.println("图片保存地址："+savePath);
        // 访问路径=静态资源路径+文件目录路径
        String visitPath ="" + url_path;
        visitPath=visitPath.replace("\\","/");
        System.out.println("图片访问uri："+visitPath);
        File saveFile = new File(savePath);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitPath;
    }
}
