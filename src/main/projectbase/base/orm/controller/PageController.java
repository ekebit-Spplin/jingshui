package orm.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import orm.base.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * 内部jsp 页面跳转
 * Created by 张宏 on 2016/5/5.
 */
@Controller
@Scope("prototype")
public class PageController extends BaseController {
    public String page(@PathVariable String pageName, HttpServletRequest request) {
        String path = request.getRequestURI().replaceAll(".html", "");
        logger.info("请求页面:" + path + ".jsp");
        return path;
    }
}
