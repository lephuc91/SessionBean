package com.example.SessionBean.businesslogic;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SearchFacadeLocal {
    List wineSearch(String wineType);
}
