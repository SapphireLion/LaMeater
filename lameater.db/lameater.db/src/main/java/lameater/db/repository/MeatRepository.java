package lameater.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lameater.db.meat.Meat;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MeatRepository extends JpaRepository<Meat,Integer>{

	// Query for Meat By Name
	@Query(value= "FROM meats WHERE name = :name")
	List<Meat> findByName(@Param("name") String name);
	
	//Query for Meat by Category
	@Query(value = "FROM meats WHERE category:=category")
	List<Meat> findbyTeam(@Param("category") String category);
	
	//Query for Meat by Category AND Name
	@Query(value = "FROM meats WHERE category = :category AND NAME = :name")
	Meat findByCategoryAndName(@Param("category") String category, @Param("name") String name);
	
	//Query for Update User Temp
	@Modifying
	@Query("UPDATE Meat m set m.usertemp = ?1 WHERE m.category = ?2 AND m.name=?3")
	int setUserTemp(int usertemp, String category, String name);
}