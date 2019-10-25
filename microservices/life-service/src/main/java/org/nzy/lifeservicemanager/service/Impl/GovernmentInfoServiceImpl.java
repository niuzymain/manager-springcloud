package org.nzy.lifeservicemanager.service.Impl;

import org.nzy.lifeservicemanager.dao.GovernmentInfoMapper;
import org.nzy.lifeservicemanager.entity.GovernmentInfo;
import org.nzy.lifeservicemanager.service.GovernmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GovernmentInfoServiceImpl implements GovernmentInfoService {
    @Autowired
    private GovernmentInfoMapper governmentInfoMapper;
    @Override
    public int addGovernmentInfo(GovernmentInfo governmentInfo) {
        int res = governmentInfoMapper.insert(governmentInfo);
        return res;
    }

    @Override
    public int editGovernmentInfo(GovernmentInfo governmentInfo) {
        int res = governmentInfoMapper.updateById(governmentInfo);
        return res;
    }

    @Override
    public int removeGovernmentInfo(long governmentInfoId) {
        int res = governmentInfoMapper.deleteById(governmentInfoId);
        return res;
    }

    @Override
    public List<GovernmentInfo> queryGovernmentInfo(GovernmentInfo governmentInfo) {
        return governmentInfoMapper.selectList(null);

    }

    @Override
    public GovernmentInfo queryGovernmentInfoById(long governmentInfoId) {
        return governmentInfoMapper.selectById(governmentInfoId);
    }
}
