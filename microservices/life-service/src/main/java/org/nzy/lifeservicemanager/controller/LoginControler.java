package org.nzy.lifeservicemanager.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.nzy.lifeservicemanager.dao.AccountMapper;
import org.nzy.lifeservicemanager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@RestController
@RequestMapping("/login")
public class LoginControler {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 2、生成验证码
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/getkaptcha")
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("rightCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 3、登录校验
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/checklogin")
    public Map<String,Object> checkLogin(HttpServletRequest request,HttpServletResponse response) {
        Map<String,Object> resMap = new HashMap();
        String code = request.getParameter("code");
        String rightcode = (String)request.getSession().getAttribute("rightCode");
        if(!code.equals(rightcode)){
            resMap.put("success",false);
            resMap.put("errorMsg","验证码错误");
            return resMap;
        }
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new Account();
        account.setAccountName(userName);
        account.setPassword(password);
        Account resAccount = accountMapper.selectByLogIn(account);
        if(resAccount == null){
            resMap.put("success",false);
            resMap.put("errorMsg","用户错误");
        }
        else{
            resMap.put("success",true);
        }
        return resMap;
    }
}