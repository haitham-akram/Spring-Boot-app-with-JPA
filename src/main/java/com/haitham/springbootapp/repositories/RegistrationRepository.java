/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haitham.springbootapp.repositories;

import com.haitham.springbootapp.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Haitham
 */
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
    
}
