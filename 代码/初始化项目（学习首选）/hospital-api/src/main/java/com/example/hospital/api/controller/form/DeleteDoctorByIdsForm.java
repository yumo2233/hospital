package com.example.hospital.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Pzr
 * @create 2023/1/13 - 20:06
 */
@Data
public class DeleteDoctorByIdsForm {
    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;
}
