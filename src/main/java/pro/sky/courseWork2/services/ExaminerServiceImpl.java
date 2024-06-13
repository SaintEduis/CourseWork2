package pro.sky.courseWork2.services;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.domain.Question;
import pro.sky.courseWork2.exceptions.BadAmountException;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Set<Question> getQuestions(Integer amount) {
        if (amount > 0 && amount <= javaQuestionService.getAll().size()) {
            Set<Question> questionArray = new HashSet<>();

            while (questionArray.size() != amount) {
                questionArray.add(javaQuestionService.getRandomQuestion());
            }

            return questionArray;
        } else {
            throw new BadAmountException();
        }
    }
}
