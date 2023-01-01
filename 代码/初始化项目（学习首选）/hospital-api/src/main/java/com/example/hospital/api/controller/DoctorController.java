package com.example.hospital.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.bean.BeanUtil;
import com.alibaba.druid.sql.PagerUtils;
import com.example.hospital.api.common.PageUtils;
import com.example.hospital.api.common.R;
import com.example.hospital.api.controller.form.SearchDoctorByPageForm;
import com.example.hospital.api.controller.form.SearchDoctorContentForm;
import com.example.hospital.api.service.DoctorService;
import com.example.hospital.api.service.impl.DoctorServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pzr
 * @create 2022/12/20 - 20:49
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    private DoctorService doctorService;

    @PostMapping("/searchByPage")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT","DOCTOR:SELECT"},mode = SaMode.OR)
    public R searchPage(@RequestBody @Valid SearchDoctorByPageForm form){
        Map param = BeanUtil.beanToMap(form);
        int page = form.getPage();
        int length = form.getLength();
        int start =(page-1)*length;
        param.put("start",start);
        PageUtils pagerUtils = doctorService.searchByPage(param);
        return R.ok().put("result",pagerUtils);
    }

    @PostMapping("/searchByContent")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT","DOCTOR:SELECT"},mode = SaMode.OR)
    public R searchContent(@RequestBody @Valid SearchDoctorContentForm form){
        HashMap map = doctorService.searchContent(form.getId());
        return R.ok(map);
    }

}
