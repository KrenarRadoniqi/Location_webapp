package com.example.locationsweb.controller;

import com.example.locationsweb.model.Location;
import com.example.locationsweb.repositories.LocationsRepository;
import com.example.locationsweb.services.LocationService;
import com.example.locationsweb.util.AttributeNames;
import com.example.locationsweb.util.Mappings;
import com.example.locationsweb.util.ReportUtil;
import com.example.locationsweb.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    Mappings mappings;
    @Autowired
    LocationsRepository locationsRepository;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    LocationService service;

    @Autowired
    ServletContext sc;

    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @RequestMapping(Mappings.SHOW_CREATE)
    public String showCreate(ModelMap modelMap){
        modelMap.addAttribute(mappings);
        return ViewNames.CREATE_LOCATION;
    }
    @RequestMapping(Mappings.SAVE_LOCATION)
    public String saveLoc(@ModelAttribute(AttributeNames.LOCATION) Location location,
                               ModelMap modelMap){
        Location saveLocation = service.saveLocation(location);
        String message="Location Saved with ID: "+saveLocation.getId();
        modelMap.addAttribute("msg",message);
        return ViewNames.CREATE_LOCATION;
    }
    @RequestMapping(Mappings.DISPLAY_LOCATIONS)
    public String displayLocations(ModelMap modelMap){
        List<Location> locations=service.getLocations();
        modelMap.addAttribute("locations", locations);
        return ViewNames.DISPLAY_LOCATIONS;
    }
    @RequestMapping(Mappings.DELETE_LOCATION)
    public String deleteLocation(@RequestParam("id") int id){
        Location location=service.getLocationById(id);
        service.deleteLocation(location);
        return "redirect:/" +Mappings.DISPLAY_LOCATIONS;
    }
    @RequestMapping(Mappings.EDIT_LOCATION)
    public String editLocation(@RequestParam("id") int id, ModelMap modelMap){
        Location location=service.getLocationById(id);
        modelMap.addAttribute("location", location);
        return ViewNames.EDIT_LOCATION;
    }
    @RequestMapping(Mappings.UPDATE_LOCATION)
    public String updateLoc(@ModelAttribute(AttributeNames.LOCATION) Location location,
                               ModelMap modelMap){
        service.updateLocation(location);
        List<Location> locations=service.getLocations();
        modelMap.addAttribute("locations",locations);
        return ViewNames.DISPLAY_LOCATIONS;
    }
    @RequestMapping("/generateReport")
    public String generateReport(){
        String path=sc.getRealPath("/");
        List<Object[]> data=locationsRepository.typeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }
}
