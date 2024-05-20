package com.Navigator.controller;

import com.Navigator.Controllers.ExamController;
import com.Navigator.Models.Exam;
import com.Navigator.Service.IExam;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ExamController.class)
public class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IExam examService;

    @Test
    public void testGetAllExams_Success() throws Exception {
        Exam exam1 = new Exam();
        exam1.setExamId(1L);
        Exam exam2 = new Exam();
        exam2.setExamId(2L);

        List<Exam> exams = Arrays.asList(exam1, exam2);

        Mockito.when(examService.getAllExams()).thenReturn(exams);

        mockMvc.perform(MockMvcRequestBuilders.get("/exam"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].examId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].examId").value(2));
    }





}
