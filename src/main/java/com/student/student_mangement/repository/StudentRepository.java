
package com.student.student_mangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student_mangement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
