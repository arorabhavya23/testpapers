package com.itelliexams.tests.service;

import com.itelliexams.tests.model.Questions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsProcessor {
    public Questions buildQuestions(){
        List<String> answerList = buildAnswers();
        return Questions
                .builder()
                .question("This is the first question?")
                .answer(answerList)
                .date(ZonedDateTime.now())
                .build();
    }

    private List<String> buildAnswers(){
        List<String> answers = new ArrayList<>();
        answers.add("option one");
        answers.add("option two");
        answers.add("option three");
        answers.add("option four");
        return answers;
    }
}
