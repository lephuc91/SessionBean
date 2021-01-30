package com.example.SessionBean.businesslogic;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SearchFacade {
    List wineSearch(String wineType);
}
