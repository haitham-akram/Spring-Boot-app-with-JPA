/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haitham.springbootapp.controllers;


import com.haitham.springbootapp.models.Course;
import com.haitham.springbootapp.models.Registration;
import com.haitham.springbootapp.models.Studant;
import com.haitham.springbootapp.repositories.CourseRepository;
import com.haitham.springbootapp.repositories.RegistrationRepository;
import com.haitham.springbootapp.repositories.StudantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Haitham
 */
@RestController
public class MainController {
    @Autowired
    StudantRepository studantRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    RegistrationRepository registrationRepository;
    
            
  @RequestMapping("/") 
  public String Index(){
  return String.format("%s","JPA Using Spring Boot");
  }
  
  @RequestMapping("/showall")
  public String ShowAll(){ 
      Studant student = studantRepository.findById(1).get();
      Course course= courseRepository.findById(1).get();
        Registration registration = new Registration();
//      registration.setCourseid(course);
//      registration.setStudantid(student);
      registration.setSemester("fall2019");
      List<Registration>registrations = registrationRepository.findAll();
      String str="";
      for(Registration re: registrations){ 
      str+=re+"<br>";
      }
  return String.format("%s", str);
  }
  
  @RequestMapping("/show/(id)")
  public String show(@PathVariable Integer id){ 
      Studant student = studantRepository.findById(id).get();
      return String.format("%s",student);
      }
 
  }
  

