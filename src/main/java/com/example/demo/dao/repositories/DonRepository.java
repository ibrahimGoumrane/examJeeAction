package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonRepository extends JpaRepository<Don, Integer> {
}
