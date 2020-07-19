package com.example.reservation_system.handler;

import com.example.reservation_system.config.ProjectUrlConfig;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler extends AbstractHandler {
    @Autowired
    private ProjectUrlConfig projectUrl;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
//        String msg = String.format("type:%s, event:%s, key:%s",
//            wxMessage.getMsgType(), wxMessage.getEvent(),
//            wxMessage.getEventKey());\
        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
        item.setDescription("预约排号时间：8.00-18.00");
        item.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590922222424&di=e855862d3b8d17835a4f4d600f9c3a48&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F01%2F36%2F72%2F87573c25cfeb04a.jpg");
        item.setUrl(projectUrl.getProject() + "/login/to_login");
        System.out.println(item.getUrl());
        item.setTitle("微信排队");

        WxMpXmlOutNewsMessage m = WxMpXmlOutMessage.NEWS()
            .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
            .addArticle(item)
            .build();

        return m;
//        String msg = "http://www.baidu.com";//项目地址
//        if (EventType.VIEW.equals(wxMessage.getEvent())) {
//            return null;
//        }
//        return WxMpXmlOutMessage.TEXT().content(msg)
//            .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
//            .build();
    }

}
