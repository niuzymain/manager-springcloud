package org.nzy.lifeservicemanager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "gov_info")
public class GovernmentInfo {
    @TableId(value = "info_id")
    private long infoId;
    private String infoTitle;
    private String infoDetail;
    private Date createTime;
    private Date editTime;


}
