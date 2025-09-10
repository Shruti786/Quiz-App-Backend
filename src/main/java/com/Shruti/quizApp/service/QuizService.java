package com.Shruti.quizApp.service;

import com.Shruti.quizApp.DAO.QuestionDAO;
import com.Shruti.quizApp.DAO.QuizDao;
import com.Shruti.quizApp.Model.Question;
import com.Shruti.quizApp.Model.QuestionWrapper;
import com.Shruti.quizApp.Model.Quiz;
import com.Shruti.quizApp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDAO questionDAO;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions =questionDAO.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz= quizDao.findById(id); //data might come or not
        List<Question> questionsFromDB= quiz.get().getQuestions();
        //to convert each question intoa questionwrapper manually we will use a loop
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz= quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getCorrect_answer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
