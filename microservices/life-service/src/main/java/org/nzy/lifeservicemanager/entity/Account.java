package org.nzy.lifeservicemanager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "account")
public class Account {
    @TableId(value = "account_id")
    private long accountId;
    private String accountName;
    private String password;
}
