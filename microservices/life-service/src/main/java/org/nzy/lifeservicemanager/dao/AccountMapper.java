package org.nzy.lifeservicemanager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.nzy.lifeservicemanager.entity.Account;

public interface AccountMapper extends BaseMapper<Account> {
    int insertInto(Account account);
    Account selectByLogIn(Account account);
}
