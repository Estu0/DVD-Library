/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejhr.dvdlibrary.ui;

import com.ejhr.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Estuardo
 */
public class DvdLibraryView {
    
    private UserIO io;
    
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
           io.print("Main Menu");
           io.print("1. Add new DVD");
           io.print("2. Remove DVD");
           io.print("3. Edit DVD");
           io.print("4. List all DVDs");
           io.print("5. Search & display DVD information");
           io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter release date");
        String mpaa = io.readString("Please enter MPAA rating");
        String directorName = io.readString("Please enter director name");
        String studio = io.readString("Please enter studio");
        String rating = io.readString("Please enter rating");
        
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaa(mpaa);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setRating(rating);
        return currentDvd;
    }
    
    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
            "DVD successfully created.  Please hit enter to continue");
    }
    
    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("%s : %s | %s | %s | %s | %s |",
                currentDvd.getTitle(),
                currentDvd.getReleaseDate(),
                currentDvd.getMpaa(),
                currentDvd.getDirectorName(),
                currentDvd.getStudio(),
                currentDvd.getRating() );
                io.print(dvdInfo);
        }
    io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDvdBanner () {
        io.print("=== Display Dvd ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the title.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaa());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getRating());
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    /**
     * Menu for editing selection 
     */
    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }
    
    public int printEditMenuAndGetSelection() {
        io.print("Edit DVD menu");
        io.print("Which information do you want to change?");
        io.print("1. Release date");
        io.print("2. MPAA rating");
        io.print("3. Director's name");
        io.print("4. User rating");
        io.print("5. Studio name");
        io.print("6. Exit edit menu");
        return io.readInt("Please select from the above choices.", 1,6);
    }
    
    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }
    
    public void displayNullDvd(){
        io.print("No such DVD");
    }
    
    public String getReleaseDate() {
        return io.readString("Enter new DVD release date:");
    }

        public String getMpaaRating() {
        return io.readString("Enter new DVD MPAA rating:");
    }
    
    public String getDirectorName() {
        return io.readString("Enter new director's name");
    }
    
    public String getUserRating() {
        return io.readString("Enter new user rating:");
    }
    
    public String getStudioName() {
        return io.readString("Enter new studio name:");
    }
    
    public void displayEditResult(){
        io.print("DVD Successfully edited!");
    }
    
    // Unknown Command and Exit
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
       
    public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}
}