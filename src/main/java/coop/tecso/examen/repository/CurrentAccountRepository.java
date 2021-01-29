package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coop.tecso.examen.model.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer>{

}
