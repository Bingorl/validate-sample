package com.example.validator.common;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zhangbin.
 * @date 2020/6/5.
 */
@Slf4j
public abstract class BaseController {

    public void render(HttpServletResponse response) {
        render("请求成功", response);
    }

    public void render(Object object, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(object);
            writer.flush();
        } catch (Exception e) {
            log.error("渲染数据异常：{}", e);
        }

    }
}
