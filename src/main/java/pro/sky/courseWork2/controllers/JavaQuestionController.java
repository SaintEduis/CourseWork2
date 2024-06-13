package pro.sky.courseWork2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseWork2.domain.Question;
import pro.sky.courseWork2.exceptions.QuestionAlreadyAddedException;
import pro.sky.courseWork2.exceptions.QuestionIsNotExistsException;
import pro.sky.courseWork2.exceptions.QuestionRepositoryIsEmptyException;
import pro.sky.courseWork2.services.JavaQuestionService;
import java.util.Map;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public String addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        try {
            javaQuestionService.addQuestion(question, answer);
            return "Вопрос успешно добавлен!";
        } catch (QuestionAlreadyAddedException e) {
            throw new QuestionAlreadyAddedException();
        }
    }

    @GetMapping(path = "/remove")
    public String removeQuestion(@RequestParam("question") String question) {
        try {
            javaQuestionService.removeQuestion(question);
            return "Вопрос успешно удалён!";
        } catch (QuestionIsNotExistsException e) {
            throw new QuestionIsNotExistsException();
        }
    }

    @GetMapping()
    public Map<String, Question> getAll() {
        try {
            return javaQuestionService.getAll();
        } catch (QuestionRepositoryIsEmptyException e) {
            throw new QuestionRepositoryIsEmptyException();
        }
    }
}
