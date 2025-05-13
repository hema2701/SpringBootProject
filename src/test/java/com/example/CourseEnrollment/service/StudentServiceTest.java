package com.example.CourseEnrollment.service;

import com.example.CourseEnrollment.dto.StudentDTO;
import com.example.CourseEnrollment.model.Student;
import com.example.CourseEnrollment.repository.StudentRepository;
//import com.example.CourseEnrollment.util.DTOMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void testSaveStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("Hema");
        studentDTO.setEmail("hema@example.com");

        Student mockStudent = new Student();
        mockStudent.setId(1L);
        mockStudent.setName("Hema");
        mockStudent.setEmail("hema@example.com");

        when(studentRepository.save(any(Student.class))).thenReturn(mockStudent);

        StudentDTO savedStudent = studentService.saveStudent(studentDTO);

        assertEquals("Hema", savedStudent.getName());
        assertEquals("hema@example.com", savedStudent.getEmail());
    }
}