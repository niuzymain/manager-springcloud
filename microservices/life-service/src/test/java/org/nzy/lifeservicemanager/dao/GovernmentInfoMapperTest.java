package org.nzy.lifeservicemanager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nzy.lifeservicemanager.entity.GovernmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GovernmentInfoMapperTest {

    @Autowired
    private GovernmentInfoMapper governmentInfoMapper;

    @Test
    public void testSelect(){
        GovernmentInfo governmentInfoList = new GovernmentInfo();
        governmentInfoList.setInfoTitle("asdas");
        governmentInfoList.setInfoDetail("sdfadfsdfsdfsdfsdfsd");
        governmentInfoMapper.insert(governmentInfoList);
    }

}