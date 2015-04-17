package com.test.req;


/** 
 * 文本消息 
 *  
 * @author guwei 
 * @date 2015年1月14日09:56:00
 */  
public class TextMessage  extends BaseReqMessage{

    // 消息内容  
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }  

}
