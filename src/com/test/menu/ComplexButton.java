package com.test.menu;
/** 
 * 一级按钮
 *  
 * @author guwei  
 * @date 2015年1月14日14:41:31
 */  
public class ComplexButton extends Button{

    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }  
    
}
