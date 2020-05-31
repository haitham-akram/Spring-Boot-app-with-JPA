/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haitham.springbootapp.repositories;

import com.haitham.springbootapp.models.Studant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Haitham
 */
public interface StudantRepository extends JpaRepository<Studant, Integer>{
    
}
