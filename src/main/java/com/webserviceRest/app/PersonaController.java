/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceRest.app;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author reta_
 */
@RestController
@RequestMapping(path="persona",method = RequestMethod.GET)
public class PersonaController {   
    @Autowired
    PersonaDAO personadao;
    
    @RequestMapping(path="",method = RequestMethod.GET)
    public ModelAndView vistaPersona(ModelAndView model){
        model.setViewName("persona");
        return model;
    }

    //POST
    @PostMapping("/add")
    //@RequestMapping(path="/add", method = RequestMethod.POST)
    public @ResponseBody String crearPersona(@RequestParam String nombre, @RequestParam String apellido){
        Persona p = new Persona(nombre,apellido);
        personadao.save(p);
        return "Persona ingresada exitosamente";
    }
    
    //GET
    @GetMapping("/get{id}")
    public @ResponseBody Optional<Persona> obtenerPersonaporId(@RequestParam Long id){      
       return personadao.findById(id);
    }
    
    //GETALL
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Persona> obtenerListaPersonas(){      
       return personadao.findAll();
    }
    
    //PUT
    @PutMapping("/update")
    public @ResponseBody String actualizarPersona(@RequestParam Long id, @RequestParam String nombre, @RequestParam String apellido){
        Persona p = new Persona(nombre,apellido);
        personadao.actualizarPersona(id, nombre, apellido);
        return "Persona actualizada exitosamente";
    }
    
    //DELETE
    @DeleteMapping("/delete{id}")
    public @ResponseBody String eliminarPersona(@RequestParam Long id){
        //Persona p = new Persona(nombre,apellido);
        personadao.deleteById(id);
        return "Persona eliminada exitosamente";
    }
}
