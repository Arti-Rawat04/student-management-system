
package com.student.student_mangement.repository;

import com.student.student_mangement.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testSaveAndFindStudent() {
        Student student = new Student(
            "Aarti", "aarti@gmail.com", "Computer Science", 21
        );

        Student savedStudent = studentRepository.save(student);

        assertThat(savedStudent.getId()).isNotNull();

        Student foundStudent = studentRepository
            .findById(savedStudent.getId())
            .orElse(null);

        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getName()).isEqualTo("Aarti");
    }

    @Test
    void testUpdateStudent() {
        Student student = studentRepository.save(
            new Student("Rahul", "rahul@gmail.com", "Java", 22)
        );

        student.setCourse("Spring Boot");

        Student updatedStudent = studentRepository.save(student);

        assertThat(updatedStudent.getCourse()).isEqualTo("Spring Boot");
    }

    @Test
    void testDeleteStudent() {
        Student student = studentRepository.save(
            new Student("Neha", "neha@gmail.com", "Python", 20)
        );

        Long id = student.getId();

        studentRepository.deleteById(id);

        assertThat(studentRepository.findById(id)).isEmpty();
    }
}
