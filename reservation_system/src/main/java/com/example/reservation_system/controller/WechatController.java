package com.example.reservation_system.controller;

import com.example.reservation_system.config.ProjectUrlConfig;
import com.example.reservation_system.result.CodeMsg;
import com.example.reservation_system.result.Result;
import com.example.reservation_system.service.WechatService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Willing
 * @date 2020/4/7
 */
//@Controller
//@RequestMapping("/wechat")
//@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class WechatController {
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private ProjectUrlConfig projectUrl;
    @Autowired
    private WechatService wechatService;

    @RequestMapping("/authorize")
    public String authorize(){
        String url= projectUrl.getWechatMpAuthorize()+"/wechat/userInfo";//重定向地址 配置到配置文件中去
        String redirectUrl = null;
        try {
            //第三个参数为附加参数，我们传过去啥，就会带回来啥。最多128字节
            redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //重定向
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public Result<String> userInfo(@RequestParam("code")String code,
                           @RequestParam("state")String returnUrl, ModelAndView modelAndView){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            //return Result.error(CodeMsg.GET_OPENID_ERROR);
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        //modelAndView.addObject("openI");
        System.out.println(openId);
        return Result.success(openId);
        //return "redirect:"+returnUrl+"?openid="+openId;//重定向
    }
}
