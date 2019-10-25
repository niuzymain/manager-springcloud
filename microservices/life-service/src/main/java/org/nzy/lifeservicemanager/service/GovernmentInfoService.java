package org.nzy.lifeservicemanager.service;

import org.nzy.lifeservicemanager.entity.GovernmentInfo;

import java.util.List;

public interface GovernmentInfoService {
    int addGovernmentInfo(GovernmentInfo governmentInfo);

    int editGovernmentInfo(GovernmentInfo governmentInfo);

    int removeGovernmentInfo(long governmentInfoId);

    List<GovernmentInfo> queryGovernmentInfo(GovernmentInfo governmentInfo);

    GovernmentInfo queryGovernmentInfoById(long governmentInfoId);
}
