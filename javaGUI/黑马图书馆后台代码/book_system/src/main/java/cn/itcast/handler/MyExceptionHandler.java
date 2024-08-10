package cn.itcast.handler;

import cn.itcast.domain.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object aroundHand(Exception e){
        e.printStackTrace();
        return new ResultInfo(false,null,"操作失败");
    }

}
