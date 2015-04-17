package com.test.req;
/** 
 * 图片消息 
 *  
 * @author guwei 
 * @date 2015年1月14日09:56:13
 */  
public class ImageMessage extends BaseReqMessage{

    // 图片链接  
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }  
    
    
}
