package coop.tecso.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coop.tecso.examen.model.PhysicalPerson;

@Repository
public interface PhysicalPersonRepository extends JpaRepository<PhysicalPerson, Integer>{

	List<PhysicalPerson> findByCurrentAccountTrue();

}
