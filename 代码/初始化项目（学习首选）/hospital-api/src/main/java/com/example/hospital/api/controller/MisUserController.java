package com.example.hospital.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.example.hospital.api.common.R;
import com.example.hospital.api.controller.form.LoginForm;
import com.example.hospital.api.service.MisUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author Pzr
 * @create 2022/11/30 - 20:58
 */
@RestController
@RequestMapping("/mis_user")
public class MisUserController {

    @Resource
    private MisUserService misUserService;

    @PostMapping("/login")
    public R login(@RequestBody @Valid LoginForm form){
        Map param = BeanUtil.beanToMap(form);
        Integer userId = misUserService.login(param);
        if(userId != null){
            StpUtil.login(userId);
            String token = StpUtil.getTokenValue();
            List<String> permissions = StpUtil.getPermissionList();
            //StpInterfaceImpl()方法调用了Dao会查询用户的权限并返给SaToken框架
            //在这调工具类的方法就可以从saToken里拿到权限列表了
            return R.ok().put("result",true).put("token",token)
                    .put("permissions",permissions);
        }
        return R.ok().put("result",false);
    }
    @GetMapping("/logout")
    @SaCheckLogin
    public R logout(){
        StpUtil.logout();
        return R.ok();
    }
}
