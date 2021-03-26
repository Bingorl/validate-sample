package com.example.validator.exception;

import com.example.validator.common.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 统一异常处理
 *
 * @author zhangbin.
 * @date 2020/6/5.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public void methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletResponse response) {
        BindingResult bindingResult = e.getBindingResult();
        bindingResultException(bindingResult, response);
    }

    @ExceptionHandler({BindException.class})
    public void bindException(BindException e, HttpServletResponse response) {
        BindingResult bindingResult = e.getBindingResult();
        bindingResultException(bindingResult, response);
    }

    private void bindingResultException(BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult != null) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            if (!CollectionUtils.isEmpty(fieldErrors)) {
                render(fieldErrors.get(0).getDefaultMessage(), response);
            }
        }
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(ConstraintViolationException e, HttpServletResponse response) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            List<ConstraintViolation<?>> list = new ArrayList(constraintViolations);
            render(list.get(0).getMessage(), response);
        }
    }
}
