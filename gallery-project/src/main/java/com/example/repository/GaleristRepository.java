package com.example.repository;

import com.example.models.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleristRepository extends JpaRepository<Gallerist, Long> {
}
