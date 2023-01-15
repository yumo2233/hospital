package com.example.hospital.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Pzr
 * @create 2023/1/15 - 13:59
 */
@Data
public class DeleteMedicalDeptSubByIdsForm {
    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;
}

