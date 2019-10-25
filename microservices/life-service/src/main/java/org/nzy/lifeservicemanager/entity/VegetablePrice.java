package org.nzy.lifeservicemanager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "veg_price")
public class VegetablePrice {
    private long id;
    private String vegName;
    private float price;
}
