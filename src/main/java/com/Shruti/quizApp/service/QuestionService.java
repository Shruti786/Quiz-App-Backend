package com.Shruti.quizApp.service;

import com.Shruti.quizApp.DAO.QuestionDAO;
import com.Shruti.quizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDao;
    //getAllQuestion
    public ResponseEntity<List<Question>> getAllQuestions() {
        //fetching data from dao layer
        //questionDao.getAllQuestions()
        try{
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    //gestQuestionByCategory
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>( questionDao.findByCategoryIgnoreCase(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    //.getQuestionsByCategoryAndDifficultylevel
    public List<Question> getQuestionsByCategoryAndDifficulty(String category, String difficultyLevel) {
        return questionDao.findByCategoryIgnoreCaseAndDifficultyLevelIgnoreCase(category, difficultyLevel);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>( "Failed", HttpStatus.BAD_REQUEST);
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "Deleted successfully";
    }


//    public String updateQuestion(Question question, Integer id) {
//        questionDao.updateById(id);
//        return "Updated Successfully";
//    }
}
