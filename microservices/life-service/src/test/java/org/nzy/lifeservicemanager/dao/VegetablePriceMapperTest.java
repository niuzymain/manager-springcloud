package org.nzy.lifeservicemanager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nzy.lifeservicemanager.entity.VegetablePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VegetablePriceMapperTest {
    @Autowired
    private VegetablePriceMapper vegetablePriceMapper;

    @Test
    public void testAdd(){
        VegetablePrice vegetablePrice = new VegetablePrice();
        vegetablePrice.setVegName("白菜");
        vegetablePrice.setPrice(2);
        vegetablePriceMapper.insert(vegetablePrice);
    }

}