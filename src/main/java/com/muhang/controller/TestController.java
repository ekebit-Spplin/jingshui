package com.muhang.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import orm.base.BaseController;
import wangchao.tools.CaptchaUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * 示例Controller
 *
 * @author 26061
 */
@Controller
@Scope("prototype")
public class TestController extends BaseController{

    /**
     * 默认方法
     */
    @RequestMapping(value = "/test_hello.do")
    public void doHello() throws Exception {
        System.out.println("tetstt");
    }

	/**
	 * 测试验证码
	 *
	 */
	@RequestMapping(value = "/testSign.do")
	public void doTestSign() throws IOException {
		Object[] objects = CaptchaUtils.getCaptchaImage_MEDIUM();
		session.setAttribute("code", objects[1].toString());

		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write((BufferedImage) objects[0], "jpeg", sos);
		sos.close();
	}

}

