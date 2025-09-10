package com.Shruti.quizApp.DAO;

import com.Shruti.quizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
