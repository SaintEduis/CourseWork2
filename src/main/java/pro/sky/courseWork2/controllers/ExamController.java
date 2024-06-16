package pro.sky.courseWork2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseWork2.domain.Question;
import pro.sky.courseWork2.exceptions.BadAmountException;
import pro.sky.courseWork2.services.ExaminerServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get")
    public List<Question> getQuestions(@RequestParam("amount") Integer amount) {
        try {
            return examinerService.getQuestions(amount);
        } catch (BadAmountException e) {
            System.out.println("Пользователь ввёл некоректное число в запросе!");
            throw e;
        }
    }
}
