package org.nzy.lifeservicemanager.controller;

import com.alibaba.fastjson.JSON;
import org.nzy.lifeservicemanager.entity.VegetablePrice;
import org.nzy.lifeservicemanager.service.VegetablePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vegprice")
public class VegetablePriceController {

    @Autowired
    private VegetablePriceService vegetablePriceService;

    @PostMapping("addprice")
    public Map<String, Object> addPrice(HttpServletRequest request) {
        Map<String, Object> resMap = new HashMap<>();
        VegetablePrice vegetablePrice = JSON.parseObject(request.getParameter("jsonstr"), VegetablePrice.class);
        int res = vegetablePriceService.addPrice(vegetablePrice);
        if (res > 0) {
            resMap.put("success", true);
        } else {
            resMap.put("success", false);
            resMap.put("error", "add fail");
        }
        return resMap;
    }

    @PostMapping("editprice")
    public Map<String, Object> editPrice(HttpServletRequest request) {
        Map<String, Object> resMap = new HashMap<>();
        VegetablePrice vegetablePrice = JSON.parseObject(request.getParameter("jsonstr"), VegetablePrice.class);
        int res = vegetablePriceService.editPrice(vegetablePrice);
        if (res > 0) {
            resMap.put("success", true);
        } else {
            resMap.put("success", false);
            resMap.put("error", "edit fail");
        }
        return resMap;
    }

    @PostMapping("removeprice")
    public Map<String, Object> removePrice(long vegpriceId) {
        Map<String, Object> resMap = new HashMap<>();
        int res = vegetablePriceService.deletePrice(vegpriceId);
        if (res > 0) {
            resMap.put("success", true);
        } else {
            resMap.put("success", false);
            resMap.put("error", "remove fail");
        }
        return resMap;
    }

    @GetMapping("listprice")
    public Map<String, Object> listPrice() {
        Map<String, Object> resMap = new HashMap<>();
        List<VegetablePrice> vegetablePriceList = vegetablePriceService.queryPrice(null);

        resMap.put("success", true);
        resMap.put("data", vegetablePriceList);

        return resMap;
    }

    @GetMapping("listpricebyid")
    public Map<String, Object> listPriceById(String vegpriceId) {
        Map<String, Object> resMap = new HashMap<>();
        VegetablePrice vegetablePrice = vegetablePriceService.queryPriceById(Long.parseLong(vegpriceId));
        resMap.put("success", true);
        resMap.put("data", vegetablePrice);

        return resMap;
    }
}
