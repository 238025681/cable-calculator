package bg.elkabel.calculator.repository;

import bg.elkabel.calculator.entity.Core;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreRepository extends JpaRepository<Core, Long> {

	public Core findOneByName(String name);
	
	@Query("SELECT c.name from Core AS c")
	public Stream<String> getAllNames();
	
	
}
