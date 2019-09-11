/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webserviceRest.app;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reta_
 */
@Repository
public interface PersonaDAO extends CrudRepository<Persona, Long>{
   @Transactional
   @Modifying(clearAutomatically = true)
   @Query(value = "UPDATE Persona p SET p.nombre = :nombre, p.apellido = :apellido WHERE p.id = :id", nativeQuery = true)
   public void actualizarPersona(@Param("id") Long id, @Param("nombre") String nombre, @Param("apellido") String apellido);
}
