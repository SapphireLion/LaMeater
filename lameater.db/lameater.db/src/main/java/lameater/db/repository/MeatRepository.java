package lameater.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lameater.db.meat.Meat;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MeatRepository extends JpaRepository<Meat,Integer>{

}