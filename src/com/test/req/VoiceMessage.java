package com.test.req;
/** 
 * 音频消息 
 *  
 * @author guwei 
 * @date 2015年1月14日09:58:25
 */  
public class VoiceMessage extends BaseReqMessage{
 // 媒体ID  
    private String MediaId;  
    // 语音格式  
    private String Format;
    
    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getFormat() {
        return Format;
    }
    public void setFormat(String format) {
        Format = format;
    } 
    
    
}
