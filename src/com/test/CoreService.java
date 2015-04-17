package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.res.Article;
import com.test.res.NewsMessage;
import com.test.res.TextMessage;


public class CoreService {
    /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
             // 接收用户发送的文本消息内容  
                String content = requestMap.get("Content");  
  
                // 创建图文消息  
                NewsMessage newsMessage = new NewsMessage();  
                newsMessage.setToUserName(fromUserName);  
                newsMessage.setFromUserName(toUserName);  
                newsMessage.setCreateTime(new Date().getTime());  
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                newsMessage.setFuncFlag(0);  
  
                List<Article> articleList = new ArrayList<Article>();  
                // 单图文消息  
                if ("1".equals(content)) {  
                    Article article = new Article();  
                    article.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article.setUrl("http://our315.com/admin/");  
                    articleList.add(article);  
                    // 设置图文消息个数  
                    newsMessage.setArticleCount(articleList.size());  
                    // 设置图文消息包含的图文集合  
                    newsMessage.setArticles(articleList);  
                    // 将图文消息对象转换成xml字符串  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 单图文消息---不含图片  
                else if ("2".equals(content)) {  
                    Article article = new Article();  
                    article.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    // 图文消息中可以使用QQ表情、符号表情  
                    article.setDescription("成功成功成功成功成功成功成功成功成功成功");
                    // 将图片置为空  
                    article.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article.setUrl("http://our315.com/admin/");  
                    articleList.add(article);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 多图文消息  
                else if ("3".equals(content)) {  
                    Article article1 = new Article();  
                    article1.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article1.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article1.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article1.setUrl("http://our315.com/admin/");  
  
                    Article article2 = new Article();  
                    article2.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article2.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article2.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article2.setUrl("http://our315.com/admin/");  
  
                    Article article3 = new Article();  
                    article3.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article3.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article3.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article3.setUrl("http://our315.com/admin/");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 多图文消息---首条消息不含图片  
                else if ("4".equals(content)) {  
                    Article article1 = new Article();  
                    article1.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article1.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    // 将图片置为空  
                    article1.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article1.setUrl("http://our315.com/admin/");  
  
                    Article article2 = new Article();  
                    article2.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article2.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article2.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article2.setUrl("http://our315.com/admin/");  
  
                    Article article3 = new Article();  
                    article3.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article3.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article3.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article3.setUrl("http://our315.com/admin/");  
  
                    Article article4 = new Article();  
                    article4.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article4.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article4.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article4.setUrl("http://our315.com/admin/");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    articleList.add(article4);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // 多图文消息---最后一条消息不含图片  
                else if ("5".equals(content)) {  
                    Article article1 = new Article();  
                    article1.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article1.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article1.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article1.setUrl("http://our315.com/admin/");  
  
                    Article article2 = new Article();  
                    article2.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article2.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    article2.setPicUrl("http://scf.suning.com/portal/images/newpage/banner1.jpg");  
                    article2.setUrl("http://our315.com/admin/");  
  
                    Article article3 = new Article();  
                    article3.setTitle("测试测试测试测试测试测试测试测试测试测试测试测试");  
                    article3.setDescription("成功成功成功成功成功成功成功成功成功成功");  
                    // 将图片置为空  
                    article3.setPicUrl("");  
                    article3.setUrl("http://our315.com/admin/");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                } 
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "谢谢您的关注！";  
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                }  
            }  
  
            if(null == respMessage){
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
}
