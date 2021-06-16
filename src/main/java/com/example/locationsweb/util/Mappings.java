package com.example.locationsweb.util;

import org.springframework.stereotype.Component;

@Component
public class Mappings {
    //constants
    public static final String SHOW_CREATE="showCreate";
    public static final String SAVE_LOCATION="saveloc";
    public static final String UPDATE_LOCATION="updateloc";

    public static final String DISPLAY_LOCATIONS="displayLocations";
    public static final String DELETE_LOCATION="deleteLocation";
    public static final String EDIT_LOCATION="editLocation";
    //constructor is private as object need not be created as all fields are static
    //private Mappings(){}
    public String display(){
        return DISPLAY_LOCATIONS;
    }
}
