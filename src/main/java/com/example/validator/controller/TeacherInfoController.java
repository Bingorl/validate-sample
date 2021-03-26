package com.example.validator.controller;

import com.example.validator.common.BaseController;
import com.example.validator.model.TeacherInfo;
import com.example.validator.service.TeacherService;
import com.example.validator.validation.ValidatedGroups;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author zhangbin.
 * @date 2020/6/5.
 */
@Api(tags = "教师管理")
@RestController
@RequestMapping("/teacher/")
@Validated
public class TeacherInfoController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("添加教师")
    @PostMapping("add")
    public void add(@Validated({ValidatedGroups.AddGroup.class}) @RequestBody TeacherInfo info, HttpServletResponse response) {
        teacherService.add(info);
        render(response);
    }

    @ApiOperation("编辑教师")
    @PostMapping("update")
    public void update(@Validated({ValidatedGroups.UpdateGroup.class}) @RequestBody TeacherInfo info, HttpServletResponse response) {
        teacherService.update(info);
        render(response);
    }

    @ApiOperation("修改邮箱接口")
    @PostMapping("updateEmail")
    public void updateEmail(@RequestParam(required = false)
                            @NotBlank(message = "邮箱不能为空")
                            @Email(message = "邮箱格式不正确") String email, HttpServletResponse response) {
        teacherService.updateEmail(email);
        render(response);
    }

    @ApiOperation("修改手机号接口")
    @PostMapping("updatePhone")
    public void updatePhone(@RequestParam(required = false) String phone, HttpServletResponse response) {
        teacherService.updatePhone(phone);
        render(response);
    }

    @ApiOperation("教师条件列表")
    @PostMapping("search")
    public void search(@Validated({ValidatedGroups.SearchGroup.class}) @ModelAttribute TeacherInfo info, HttpServletResponse response) {
        teacherService.search(info);
        render(response);
    }
}
