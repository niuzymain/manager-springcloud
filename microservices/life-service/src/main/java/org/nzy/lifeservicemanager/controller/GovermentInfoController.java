package org.nzy.lifeservicemanager.controller;

import com.alibaba.fastjson.JSON;
import org.nzy.lifeservicemanager.entity.GovernmentInfo;
import org.nzy.lifeservicemanager.service.GovernmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/govinfo")
public class GovermentInfoController {
    @Autowired
    private GovernmentInfoService governmentInfoService;

    @PostMapping("/addgovinfo")
    public Map<String,Object> addGovInfo(HttpServletRequest request){
        Map<String,Object> resMap = new HashMap<>();
        try{
            GovernmentInfo governmentInfo = JSON.parseObject(request.getParameter("jsonstr"),GovernmentInfo.class);
            governmentInfo.setCreateTime(new Date());
            governmentInfo.setEditTime(new Date());
            int res = governmentInfoService.addGovernmentInfo(governmentInfo);
            if(res > 0){
                resMap.put("success",true);
            }
            else{
                resMap.put("success",false);
                resMap.put("error","add fail");
            }
        }catch (Exception e){
            resMap.put("success",false);
            resMap.put("error",e.getMessage());
        }
        finally {
            return resMap;
        }

    }

    @PostMapping("/editgovinfo")
    public Map<String,Object> editGovInfo(HttpServletRequest request){
        Map<String,Object> resMap = new HashMap<>();
        try{
            GovernmentInfo governmentInfo = JSON.parseObject(request.getParameter("jsonstr"),GovernmentInfo.class);
            int res = governmentInfoService.editGovernmentInfo(governmentInfo);
            if(res > 0){
                resMap.put("success",true);
            }
            else{
                resMap.put("success",false);
                resMap.put("error","add fail");
            }
        }catch (Exception e){
            resMap.put("success",false);
            resMap.put("error",e.getMessage());
        }
        finally {
            return resMap;
        }

    }

    @PostMapping("/removegovinfo")
    public Map<String,Object> removeGovInfo(@RequestParam("govinfoid") Long govinfoId){
        Map<String,Object> resMap = new HashMap<>();
        try{
            int res = governmentInfoService.removeGovernmentInfo(govinfoId);
            if(res > 0){
                resMap.put("success",true);
            }
            else{
                resMap.put("success",false);
                resMap.put("error","add fail");
            }
        }catch (Exception e){
            resMap.put("success",false);
            resMap.put("error",e.getMessage());
        }
        finally {
            return resMap;
        }
    }

    @GetMapping("/listinfo")
    public Map<String,Object> listInfo(){
        Map<String,Object> resMap = new HashMap<>();
        try{
            List<GovernmentInfo> governmentInfoList = governmentInfoService.queryGovernmentInfo(null);
            resMap.put("success",true);
            resMap.put("data",governmentInfoList);
        }catch (Exception e){
            resMap.put("success",false);
            resMap.put("error",e.getMessage());
        }
        return resMap;
    }

    @GetMapping("/listinfobyid")
    public Map<String,Object> listInfoById(@RequestParam("govinfoid") String govinfoId){
        Map<String,Object> resMap = new HashMap<>();
        try{
            GovernmentInfo governmentInfo = governmentInfoService.queryGovernmentInfoById(Long.parseLong(govinfoId));
            resMap.put("success",true);
            resMap.put("data",governmentInfo);
        }catch (Exception e){
            resMap.put("success",false);
            resMap.put("error",e.getMessage());
        }
        return resMap;
    }
}
