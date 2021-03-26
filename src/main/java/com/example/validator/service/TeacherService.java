package com.example.validator.service;

import com.example.validator.model.TeacherInfo;
import com.example.validator.validation.annotation.Phone;
import org.springframework.validation.annotation.Validated;

/**
 * @author zhangbin.
 * @date 2020/6/5.
 */
@Validated
public interface TeacherService {

    void add(TeacherInfo info);

    void update(TeacherInfo info);

    void updateEmail(String email);

    void updatePhone(@Phone String phone);

    void search(TeacherInfo info);
}
