package com.example.hospital.api.controller.form;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Pzr
 * @create 2023/1/15 - 13:43
 */
@Data
public class InsertMedicalDeptSubForm {
    @NotBlank(message = "name不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "name内容不正确")
    private String name;

    @NotNull(message = "deptId不能为空")
    @Min(value = 1, message = "deptId不能小于1")
    private Integer deptId;

    @NotBlank(message = "location不能为空")
    private String location;
}

