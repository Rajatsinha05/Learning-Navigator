package com.Navigator.controller;

import com.Navigator.Controllers.StudentController;
import com.Navigator.Models.Student;
import com.Navigator.Service.Impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceImpl studentService;

    @Test
    public void testGetAllStudents_Success() throws Exception {
        Student student1 = new Student();
        student1.setName("Ravi Kumar");
        student1.setRegistrationId(123);

        Student student2 = new Student();
        student2.setName("Anshu Singh");
        student2.setRegistrationId(456);

        List<Student> students = Arrays.asList(student1, student2);

        Mockito.when(studentService.getAllStudents()).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Ravi Kumar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Anshu Singh"));
    }

    @Test
    public void testGetStudentByRegistrationId_Success() throws Exception {
        Student student = new Student();
        student.setName("Rajat Sharma");
        student.setRegistrationId(789);

        Mockito.when(studentService.getStudentByRegistrationId(789L)).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/students/789"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Rajat Sharma"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.registrationId").value(789));
    }

    @Test
    public void testCreateStudent_Success() throws Exception {
        Student newStudent = new Student();
        newStudent.setName("Ravi Verma");
        newStudent.setRegistrationId(987);

        Mockito.when(studentService.createStudent(Mockito.any(Student.class))).thenReturn(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Ravi Verma\",\"registrationId\":987}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ravi Verma"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.registrationId").value(987));
    }



}
