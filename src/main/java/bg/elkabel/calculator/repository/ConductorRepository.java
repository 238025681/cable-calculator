/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.elkabel.calculator.repository;

import bg.elkabel.calculator.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kalin
 */
public interface ConductorRepository extends JpaRepository<Conductor, Long> {

	
	Conductor findOneByName(String name);
	
}
