package com.example.hospital.api.controller.form;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Pzr
 * @create 2023/1/15 - 13:51
 */
@Data
public class SearchMedicalDeptSubByIdForm {
    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    private Integer id;
}

