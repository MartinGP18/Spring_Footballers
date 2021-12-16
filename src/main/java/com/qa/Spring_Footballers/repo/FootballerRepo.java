package com.qa.Spring_Footballers.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.Spring_Footballers.domain.Footballer;

public interface FootballerRepo extends JpaRepository<Footballer, Long> {

}
