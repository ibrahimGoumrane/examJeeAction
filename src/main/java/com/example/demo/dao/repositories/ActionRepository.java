package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
}
