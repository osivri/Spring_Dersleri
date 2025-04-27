package com.example.repository;

import com.example.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // HQL -> Sınıf ve değişken isimleri kullanılır
    // SQL -> Tablo ve kolon isimleri kullanılır
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();

    @Query(value = "from Student s WHERE s.id= :id")
    Optional<Student> findStudentById(Integer id);


}
