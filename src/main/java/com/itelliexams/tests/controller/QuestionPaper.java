package com.itelliexams.tests.controller;

import com.itelliexams.tests.model.Questions;
import com.itelliexams.tests.service.QuestionsProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Response;

@Controller
public class QuestionPaper {

    @Autowired
    private QuestionsProcessor questionsProcessor;

    @RequestMapping("/getquestions")
    public ResponseEntity<Questions> getQuestions(){

        return ResponseEntity.ok(questionsProcessor.buildQuestions());
    }
}
