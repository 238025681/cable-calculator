
package bg.elkabel.calculator.repository;

import bg.elkabel.calculator.entity.Cable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CableRepository extends JpaRepository<Cable, Long>{
	
	
	Cable findOneByName(String name);
}
