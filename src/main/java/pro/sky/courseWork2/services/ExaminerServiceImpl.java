package pro.sky.courseWork2.services;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.domain.Question;
import pro.sky.courseWork2.exceptions.BadAmountException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public List<Question> getQuestions(Integer amount) {
        if (amount > 0 && amount <= javaQuestionService.getAll().size()) {
           List<Question> questionArray = new ArrayList<>();

            while (questionArray.size() != amount) {
                Question newQuestion = javaQuestionService.getRandomQuestion();
                if (!(questionArray.contains(newQuestion))) {
                   questionArray.add(newQuestion);
                }
            }

            return questionArray;
        } else {
            throw new BadAmountException();
        }
    }
}