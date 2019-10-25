package org.nzy.lifeservicemanager.service.Impl;

import org.nzy.lifeservicemanager.dao.VegetablePriceMapper;
import org.nzy.lifeservicemanager.entity.VegetablePrice;
import org.nzy.lifeservicemanager.service.VegetablePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetablePriceServiceImpl implements VegetablePriceService {
    @Autowired
    private VegetablePriceMapper vegetablePriceMapper;

    @Override
    public int addPrice(VegetablePrice vegetablePrice) {
        return vegetablePriceMapper.insert(vegetablePrice);
    }

    @Override
    public int editPrice(VegetablePrice vegetablePrice) {
        return vegetablePriceMapper.updateById(vegetablePrice);
    }

    @Override
    public int deletePrice(long vegetablePriceId) {
        return vegetablePriceMapper.deleteById(vegetablePriceId);
    }

    @Override
    public List<VegetablePrice> queryPrice(VegetablePrice vegetablePrice) {
        return vegetablePriceMapper.selectList(null);
    }

    @Override
    public VegetablePrice queryPriceById(long vegetablePriceId) {
        return vegetablePriceMapper.selectById(vegetablePriceId);
    }
}
