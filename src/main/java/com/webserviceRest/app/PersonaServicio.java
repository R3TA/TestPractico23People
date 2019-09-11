/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceRest.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author reta_
 */
@Service
public class PersonaServicio{
   @Autowired
   PersonaDAO personadao;
   
   public void actualizarPersona(Long id, String nombre, String apellido){
       personadao.actualizarPersona(id, nombre, apellido); 
   }
   
    
}
