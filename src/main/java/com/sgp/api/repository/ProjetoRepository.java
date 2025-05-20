package com.sgp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sgp.api.model.Projeto;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

    

}
