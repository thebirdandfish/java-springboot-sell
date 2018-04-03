package top.linxz.sell.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import top.linxz.sell.config.ProjectUrlConfig;
import top.linxz.sell.exception.SellerAuthorizeException;

@ControllerAdvice
public class SelerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat("http://sell.springboot.cn/sell/qr/")
                .concat(projectUrlConfig.getOpenid()));
    }
}
