package com.example.validator.model;

import com.example.validator.validation.annotation.Birthday;
import com.example.validator.validation.annotation.IdentityNum;
import com.example.validator.validation.annotation.Phone;
import com.example.validator.validation.ValidatedGroups;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * @author zhangbin.
 * @date 2020/6/5.
 */
@Data
public class TeacherInfo {

    @Null(message = "id必须为空", groups = ValidatedGroups.AddGroup.class)
    @NotNull(message = "id不能为空", groups = ValidatedGroups.UpdateGroup.class)
    @Min(value = 1, message = "id最小值为1", groups = ValidatedGroups.UpdateGroup.class)
    private Integer id;
    @NotBlank(message = "姓名不能为空",
            groups = {
                    ValidatedGroups.AddGroup.class,
                    ValidatedGroups.UpdateGroup.class,
                    ValidatedGroups.SearchGroup.class})
    private String realName;
    @Birthday(groups = {ValidatedGroups.AddGroup.class, ValidatedGroups.UpdateGroup.class})
    private String birthday;
    @NotNull(message = "年龄不能为空", groups = {ValidatedGroups.AddGroup.class, ValidatedGroups.UpdateGroup.class})
    @Range(min = 1, max = 100, message = "年龄最小值不能小于1", groups = {ValidatedGroups.AddGroup.class, ValidatedGroups.UpdateGroup.class})
    private Integer age;
    @Phone(groups = {
            ValidatedGroups.AddGroup.class,
            ValidatedGroups.UpdateGroup.class,
            ValidatedGroups.SearchGroup.class})
    private String phone;
    @Email(message = "邮箱格式不正确", groups = {ValidatedGroups.AddGroup.class, ValidatedGroups.UpdateGroup.class})
    private String email;
    @IdentityNum(groups = {
            ValidatedGroups.AddGroup.class,
            ValidatedGroups.UpdateGroup.class,
            ValidatedGroups.SearchGroup.class})
    private String identityNum;
}
