/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejhr.dvdlibrary.dao;

import com.ejhr.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Estuardo
 */
public interface DvdLibraryDao {
    /**
     * Adds the given DVD to the library and associates it with the given
     * title. If there is already a DVD associated with the given
     * title it will return that DVD object, otherwise it will
     * return null.
     *
     * @param title id with which DVD is to be associated
     * @param dvd dvd to be added to the library
     * @return the Dvd object previously associated with the given  
     * title if it exists, null otherwise
     */
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    /**
     * Returns a List of all DVDs in the library.
     *
     * @return List containing all DVDs in the library.
     */
    List<Dvd> getAllDvds()throws DvdLibraryDaoException;;

    /**
     * Returns the dvd object associated with the given title.
     * Returns null if no such dvd exists
     *
     * @param title Title of the DVD to retrieve
     * @return the Dvd object associated with the given title,  
     * null if no such dvd exists
     */
    Dvd getDvd(String title) throws DvdLibraryDaoException;;

    /**
     * Removes from the library the dvd associated with the given title.
     * Returns the Dvd object that is being removed or null if
     * there is no Dvd associated with the given title
     *
     * @param title Title of dvd to be removed
     * @return Dvd object that was removed or null if no dvd
     * was associated with the given title
     */
    Dvd removeDvd(String title) throws DvdLibraryDaoException;;
    
    // EDIT SEGMENT
    
    /**
     * Edits the DVD release date from the library the DVD associated with the given title.Returns the DVD object that is being edited or null if there is no DVD
     *  associated with the given title.
     * @param title title of DVD to be edited
     * @param releaseDate release date of DVD to be changed to
     * @return Dvd object that was edited or null if no DVD was associated with the 
     * given DVD title
     * @throws com.chloe.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd changeReleaseDate(String title, String releaseDate) throws DvdLibraryDaoException;
    
    /**
     * Edits the DVD MPAA rating date from the library the DVD associated with the given title.Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param mpaaRating MPAA rating of DVD to be changed to    
     * @return Dvd object that was edited or null if no DVD was associated with the
     * given DVD title
     * @throws com.chloe.dvdlibrary.dao.DvdLibraryDaoException    
     */
    Dvd changeMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException;
    
    
    /**
     * Edits the DVD MPAA rating date from the library the DVD associated with the given title.Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param directorName director name of DVD to be changed to    
     * @return Dvd object that was edited or null if no DVD was associated with the
     * given DVD title
     * @throws com.chloe.dvdlibrary.dao.DvdLibraryDaoException    
     */    
    Dvd changeDirectorName(String title, String directorName) throws DvdLibraryDaoException;
    
    
      /**
     * Edits the DVD MPAA rating date from the library the DVD associated with the given title.Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param userRating user rating of DVD to be changed to    
     * @return Dvd object that was edited or null if no DVD was associated with the
     * given DVD title    
     * @throws com.chloe.dvdlibrary.dao.DvdLibraryDaoException    
     */     
    Dvd changeUserRating(String title, String userRating) throws DvdLibraryDaoException;
    
    
      /**
     * Edits the DVD studio name from the library the DVD associated with the given title.Returns the DVD object that is being edited or null if there is no DVD
     * associated with the given title.
     * @param title title of DVD to be edited
     * @param studioName name of the studio of DVD to be changed to    
     * @return Dvd object that was edited or null if no DVD was associated with the
     * given DVD title    
     * @throws com.chloe.dvdlibrary.dao.DvdLibraryDaoException    
     */     
    Dvd changeStudioName(String title, String studioName) throws DvdLibraryDaoException;   
    
    
}
