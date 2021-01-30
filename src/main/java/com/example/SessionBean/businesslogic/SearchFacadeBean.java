package com.example.SessionBean.businesslogic;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.interceptor.InvocationContext;

@Stateless(name = "SearchFacade")
public class SearchFacadeBean implements SearchFacade, SearchFacadeLocal {
    public SearchFacadeBean() {
    }

    HashMap countryMap = new HashMap();

    public List wineSearch(String wineType) {
        List wineList = new ArrayList();
        if (wineType.equals("Red")) {
            wineList.add("Bordeaux");
            wineList.add("Merlot");
            wineList.add("Pinot Noir");
        }
        else if (wineType.equals("White")) {
            wineList.add("Chardonnay");
        }
        return wineList;
    }

    @PostConstruct
    public void initializeCountryWineList(){
        // countryMap is HashMap
        countryMap.put("Australia", "Sauvignon Blanc");
        countryMap.put("Australia", "Grenache");
        countryMap.put("France","Gewurztraminer");
        countryMap.put("France","Bordeaux");
    }

    @PreDestroy
    public void destroyWineList(){
        countryMap.clear();
    }

    public Object TimeLog(InvocationContext ctx) throws Exception{
        String beanClassName = ctx.getClass().getName();
        String businessMethodName = ctx.getMethod().getName();
        String target = beanClassName + "." + businessMethodName;
        long startTime = System.currentTimeMillis();
        System.out.println("Invoking "+ target);
        try {
            return ctx.proceed();
        }
        finally {
            System.out.println("Exiting" + target);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println ("Business method" + businessMethodName +
                    "in" + beanClassName + "takes" + totalTime + "ms to execute");
        }
    }
}