package com.test.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.WeixinUtil;

public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wx8cc813db338acc33";
        // 第三方用户唯一凭证密钥
        String appSecret = "8c86bbf68906e0ddd6777e084c727d3e";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

       if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("申请");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("进度查询");
        btn12.setType("click");
        btn12.setKey("12");
        
        CommonButton btn13 = new CommonButton();
        btn13.setName("还款");
        btn13.setType("click");
        btn13.setKey("13");


        CommonButton btn21 = new CommonButton();
        btn21.setName("贷款历史");
        btn21.setType("click");
        btn21.setKey("21");

    

        CommonButton btn31 = new CommonButton();
        btn31.setName("关于贷款");
        btn31.setType("click");
        btn31.setKey("31");

       

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("贷款申请");
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("我的贷款");
        mainBtn2.setSub_button(new CommonButton[] { btn21 });

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("帮助中心");
        mainBtn3.setSub_button(new CommonButton[] { btn31 });

        /**
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
         * 
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}
