package com.defender.common.handler;

import com.defender.common.exception.DefenderException;
import com.defender.common.utils.ExceptionUtils;
import com.defender.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** 通用异常处理器
 * @author guanlibin
 * @version 1.0
 * @since 2020/9/30 12:43
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        log.info(ExceptionUtils.getMessage(e));
        return R.error().message(e.getMessage());
    }

    @ExceptionHandler(DefenderException.class)
    public R error(DefenderException e) {
        return R.error().code(e.getCode()).message(e.getMessage());
    }
}
