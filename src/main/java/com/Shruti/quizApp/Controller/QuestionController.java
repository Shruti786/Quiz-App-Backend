package com.Shruti.quizApp.Controller;


import com.Shruti.quizApp.Model.Question;
import com.Shruti.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        //using response entity to customize the Http status code
        return questionService.getAllQuestions();

    }
    //get question with category: Basic or  Advance
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>>getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }
    //get question with cat and difficulty level
    @GetMapping("/category/{category}/difficulty_level/{difficulty_level}")
    public List<Question> getQuestionsByCategoryAndDifficulty(@PathVariable String category, @PathVariable("difficulty_level") String difficultyLevel) {
        return questionService.getQuestionsByCategoryAndDifficulty(category, difficultyLevel);
    }
    //addingquestion
    @PostMapping("/add")
    public  ResponseEntity <String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
       // return "Success";
    }
//    @PutMapping("/id/{id}")
//    public String updateQuestion(@RequestBody Question question, @PathVariable Integer id){
//        return questionService.updateQuestion(question,id);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

}
