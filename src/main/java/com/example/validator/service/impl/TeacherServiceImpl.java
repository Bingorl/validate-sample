package com.example.validator.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.validator.model.TeacherInfo;
import com.example.validator.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangbin.
 * @date 2020/6/5.
 */
@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    @Override
    public void add(TeacherInfo info) {
        log.info("add接口：{}\n", JSON.toJSONString(info, true));
    }

    @Override
    public void update(TeacherInfo info) {
        log.info("update接口：{}\n", JSON.toJSONString(info, true));
    }

    @Override
    public void updateEmail(String email) {
        log.info("updateEmail接口：{}", email);
    }

    @Override
    public void updatePhone(String phone) {
        log.info("updatePhone接口：{}", phone);
    }

    @Override
    public void search(TeacherInfo info) {
        log.info("search：{}\n", JSON.toJSONString(info, true));
    }
}
