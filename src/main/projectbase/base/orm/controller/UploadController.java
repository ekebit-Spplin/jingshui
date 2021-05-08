package orm.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import orm.base.BaseController;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 文件上传
 * Created by Administrator on 2016/8/17 0017.
 */
@Controller
@RequestMapping("file")
public class UploadController extends BaseController {

    private String base_path = "C:\\upload\\";

    @RequestMapping(value = "/upload")
    public JSONObject upload() throws IllegalStateException, IOException {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (commonsMultipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "upload_" + pre + myFileName.substring(myFileName.lastIndexOf("."));
                        //定义上传路径
                        if (!new File(base_path).exists())
                            new File(base_path).mkdir();
                        String path = base_path + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
            }
        }
        return this.codeMess(sCode, "上传成功");
    }
}
