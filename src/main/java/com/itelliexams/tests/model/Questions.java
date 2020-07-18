package com.itelliexams.tests.model;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
public class Questions {

    private ZonedDateTime date;
    private String question;
    private List<String> answer;

}
