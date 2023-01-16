package com.example.hospital.patient.wx.api.service;

import java.util.HashMap;

/**
 * @author Pzr
 * @create 2023/1/17 - 0:40
 */
public interface UserService {
    public HashMap loginOrRegister(String code, String nickname, String photo, String sex);
}
