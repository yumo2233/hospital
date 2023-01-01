package com.example.hospital.api.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.example.hospital.api.db.dao.MisUserDao;
import com.example.hospital.api.service.MisUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Pzr
 * @create 2022/11/29 - 21:12
 */
@Service
public class MisUserServiceImpl implements MisUserService {
    @Resource
    private MisUserDao misUserDao;

    @Override
    public Integer login(Map param){
        String username = MapUtil.getStr(param, "username");
        String password = MapUtil.getStr(param, "password");
        MD5 md5 = MD5.create();
        String temp = md5.digestHex(username);
        String tempStart = StrUtil.subWithLength(temp,0,6);
        String tempEnd = StrUtil.subSuf(temp,temp.length()-3);//从倒数第三个字符一直取到结尾
        password = md5.digestHex(tempStart+password+tempEnd);
        param.replace("password",password);
        Integer userId = misUserDao.login(param);
        return userId;
    }

}
