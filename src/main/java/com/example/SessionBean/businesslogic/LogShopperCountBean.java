package com.example.SessionBean.businesslogic;

import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

@Singleton
@Startup
@DependsOn("ShopperCount")
public class LogShopperCountBean {
    private final Logger log = Logger.getLogger("LogShopperCount.class");
    public void logShopperCount() {
    }
}
