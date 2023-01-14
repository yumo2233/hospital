package com.example.hospital.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Pzr
 * @create 2023/1/14 - 13:36
 */
@Data
public class DeleteMedicalDeptByIdsForm {
    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;
}

