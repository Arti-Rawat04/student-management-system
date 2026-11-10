
package com.student.student_mangement.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void testStudentConstructorAndGetters() {

        Student student = new Student(
                "Aarti",
                "aarti@gmail.com",
                "Computer Science",
                21
        );

        assertEquals("Aarti", student.getName());
        assertEquals("aarti@gmail.com", student.getEmail());
        assertEquals("Computer Science", student.getCourse());
        assertEquals(21, student.getAge());
    }

    @Test
    void testStudentSetters() {

        Student student = new Student();

        student.setId(1L);
        student.setName("Rahul");
        student.setEmail("rahul@gmail.com");
        student.setCourse("Java");
        student.setAge(22);

        assertEquals(1L, student.getId());
        assertEquals("Rahul", student.getName());
        assertEquals("rahul@gmail.com", student.getEmail());
        assertEquals("Java", student.getCourse());
        assertEquals(22, student.getAge());
    }
}
