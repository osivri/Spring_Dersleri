package com.example.repository;

import com.example.models.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository extends JpaRepository<Personel, Long> {

    @Query(value = "from Personel")
    public Page<Personel> findAllPageable(Pageable pageable);
}