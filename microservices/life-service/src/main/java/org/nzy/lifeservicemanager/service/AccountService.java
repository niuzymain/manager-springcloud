package org.nzy.lifeservicemanager.service;

import org.nzy.lifeservicemanager.entity.Account;

import java.util.List;

public interface AccountService {
    int addAccount(Account account);

    int editAccount(Account account);

    int removeAccount(long accountId);

    List<Account> queryAccount(Account account);

}
