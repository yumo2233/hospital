package com.example.hospital.api.service.impl;

import com.example.hospital.api.db.dao.MedicalDeptDao;
import com.example.hospital.api.service.MedicalDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Pzr
 * @create 2022/12/27 - 23:44
 */
@Service
public class MedicalDeptServiceImpl implements MedicalDeptService {
    @Resource
    private MedicalDeptDao medicalDeptDao;

    @Override
    public ArrayList<HashMap> searchAll(){
        ArrayList<HashMap> list = medicalDeptDao.searchAll();
        return list;
    }
}
