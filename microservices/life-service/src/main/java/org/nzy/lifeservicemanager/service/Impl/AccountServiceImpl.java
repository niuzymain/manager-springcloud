package org.nzy.lifeservicemanager.service.Impl;

import org.nzy.lifeservicemanager.dao.AccountMapper;
import org.nzy.lifeservicemanager.entity.Account;
import org.nzy.lifeservicemanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int addAccount(Account account) {
        int res = accountMapper.insert(account);
        if(res > 0){
            return 1;
        }
        else{
            return res;
        }
    }

    @Override
    public int editAccount(Account account) {
        int res = accountMapper.updateById(account);
        if(res > 0){
            return 1;
        }
        else{
            return res;
        }
    }

    @Override
    public int removeAccount(long accountId) {
        int res = accountMapper.deleteById(accountId);
        if(res > 0){
            return 1;
        }
        else{
            return res;
        }
    }

    @Override
    public List<Account> queryAccount(Account account) {
        List<Account> accountList = accountMapper.selectList(null);
        return accountList;
    }
}
