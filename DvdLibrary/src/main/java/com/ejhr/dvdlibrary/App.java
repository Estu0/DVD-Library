/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejhr.dvdlibrary;

import com.ejhr.dvdlibrary.controller.DvdLibraryController;
import com.ejhr.dvdlibrary.dao.DvdLibraryDao;
import com.ejhr.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.ejhr.dvdlibrary.ui.DvdLibraryView;
import com.ejhr.dvdlibrary.ui.UserIO;
import com.ejhr.dvdlibrary.ui.UserIOConsoleImpl;

/**
 * @author Estuardo Joel Higueros Reyes
 * estuar0jhr@gmail.com
 * 8/24/2022
 * Purpose: DVD Library Assessment
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl(); 
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }   
    
}
