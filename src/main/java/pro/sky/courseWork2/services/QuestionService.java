package pro.sky.courseWork2.services;

import pro.sky.courseWork2.domain.Question;
import java.util.Map;

public interface QuestionService {
    void addQuestion(String question, String answer);

    void removeQuestion(String question);

    Map<String, Question> getAll();

    Question getRandomQuestion();
}
