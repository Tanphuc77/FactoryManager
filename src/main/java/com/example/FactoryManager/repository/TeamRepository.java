package com.example.FactoryManager.repository;

import com.example.FactoryManager.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
