/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejhr.dvdlibrary.dao;

import com.ejhr.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Estuardo
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd (String title, Dvd dvd) 
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd newDvd = dvds.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() 
     throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) 
     throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) 
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd removedDvd = dvds.remove(title);
        writeLibrary();
        return removedDvd;
    }
    
    @Override
    public Dvd changeReleaseDate(String title, String releaseDate)
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setReleaseDate(releaseDate);
        writeLibrary();
        return dvdToEdit;
    }
    
    @Override
    public Dvd changeMpaaRating(String title, String mpaaRating) 
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setMpaa(mpaaRating);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeDirectorName(String title, String directorName) 
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setDirectorName(directorName);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd changeUserRating(String title, String userRating)
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setRating(userRating);
        writeLibrary();
        return dvdToEdit;
    }
    
    @Override
    public Dvd changeStudioName(String title, String studioName) 
     throws DvdLibraryDaoException {
        loadLibrary();
        Dvd dvdToEdit = dvds.get(title);
        dvdToEdit.setStudio(studioName);
        writeLibrary();
        return dvdToEdit;
    }
    
    private Dvd unmarshallDvd(String dvdAsText){
        // dvdAsText is expecting a line read in from file.
        // For example, it might look like this:
        // Alien::1979::R::Ridley Scott::20th Century::9/10
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in dvdTokens.
        // Which should look like this:
        // ______________________________________________
        // |     |    |   |            |            |
        // |Alien|1979| R |Ridley Scott|20th Century|9/10
        // |     |    |   |            |            |
        // ----------------------------------------------
        //   [0]  [1]  [2]     [3]          [4]       [5]
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Given the pattern above, the title is in index 0 of the array.
        String title = dvdTokens[0];

        // Which we can then use to create a new Dvd object to satisfy
        // the requirements of the Dvd constructor.
        Dvd dvdFromFile = new Dvd(title);

        // However, there are remaining tokens that need to be set into the
        // new dvd object. Do this manually by using the appropriate setters.

        // Index 1 - ReleaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - Mpaa
        dvdFromFile.setMpaa(dvdTokens[2]);

        // Index 3 - DirectorName
        dvdFromFile.setDirectorName(dvdTokens[3]);
        
        // Index 4 - Studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - Rating
        dvdFromFile.setRating(dvdTokens[5]);

        // We have now created a dvd.
        return dvdFromFile;
    }
    
    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load library data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent DVD unmarshalled
        Dvd currentDvd;
        // Go through LIBRARY_FILE line by line, decoding each line into a 
        // Dvd object by calling the unmarshallDvd method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Dvd
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the DVD id as the map key for our DVD object.
            // Put currentDvd into the map using title as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallDvd(Dvd aDvd){
        // We need to turn a Dvd object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // Alien::1979::R::Ridley Scott::20th Century::9/10 

        // Start with the title, since that's supposed to be first.
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // ReleaseDate
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        // Mpaa
        dvdAsText += aDvd.getMpaa() + DELIMITER;

        // DirectorName
        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        // Studio
        dvdAsText += aDvd.getStudio() + DELIMITER;

        // Rating
        dvdAsText += aDvd.getRating();

        // Dvd turned to text. 
        return dvdAsText;
    }
    
    /**
     * Writes all dvds in the lbrary out to a LIBRARY_FILE.  See loadLIBRARY
     * for file format.
     * 
     * @throws DvdLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        // Write out the Dvd objects to the LIBRARY file.

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            // turn DvD into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the Dvd object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
    
}
