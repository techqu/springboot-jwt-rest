package com.quguang.springbootjwtdemo.common;

/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String SCExceptionHandler(HttpServletRequest request, Exception e) {
        String ret;
        try {
            if (!(e instanceof SCException)) {
                throw e;
            }

            SCException ke = (SCException)e;
            ret = ReturnUtils.getErrJson(ke.getData(), ke.getErrorType());
        } catch (Exception var5) {
            log.error("全局异常处理错误", var5);
            ret = ReturnUtils.getErrJson("", BaseErrorType.OPERATE_ERROR);
        }

        return ret;
    }
}
