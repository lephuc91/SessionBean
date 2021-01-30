package com.example.SessionBean.businesslogic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

@Singleton(name = "ShopperCount")
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ShopperCountBean {
    private int shopperCounter = 0;

    @Lock(LockType.WRITE)
    public void incrementShopperCount() {
        shopperCounter++;
    }

    @Lock(LockType.READ)
    public int getShopperCount() {
        return shopperCounter;
    }

    public void resetCounter(){
        shopperCounter = 0;
    }

    @PostConstruct
    public void applicationStartup() {
        System.out.println("From applicationStartup method.");
        resetCounter();
    }

    @PreDestroy
    public void applicationShutdown() {
        System.out.println("From applicationShutdown method.");
    }
}
