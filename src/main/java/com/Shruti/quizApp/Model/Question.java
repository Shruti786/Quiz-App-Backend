package com.Shruti.quizApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question_title;
    private  String category;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String correct_answer;



}
