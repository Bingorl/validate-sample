package com.example.validator.validation;

/**
 * 校验分组
 * <p>
 * 当校验注解的groups指定了分组之后,只有满足该分组了校验才会生效
 *
 * @author zhangbin.
 * @date 2020/6/5.
 */
public class ValidatedGroups {

    /**
     * 添加分组
     */
    public interface AddGroup {
    }

    /**
     * 编辑分组
     */
    public interface UpdateGroup {
    }

    /**
     * 搜索分组
     */
    public interface SearchGroup {
    }

}
