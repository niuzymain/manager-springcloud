package org.nzy.lifeservicemanager.service;

import org.nzy.lifeservicemanager.entity.VegetablePrice;

import java.util.List;

public interface VegetablePriceService {

    int addPrice(VegetablePrice vegetablePrice);

    int editPrice(VegetablePrice vegetablePrice);

    int deletePrice(long vegetablePriceId);

    List<VegetablePrice> queryPrice(VegetablePrice vegetablePrice);

    VegetablePrice queryPriceById(long vegetablePriceId);


}
