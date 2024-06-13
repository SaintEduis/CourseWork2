package pro.sky.courseWork2.services;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.domain.Question;
import pro.sky.courseWork2.exceptions.QuestionAlreadyAddedException;
import pro.sky.courseWork2.exceptions.QuestionIsNotExistsException;
import pro.sky.courseWork2.exceptions.QuestionRepositoryIsEmptyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{
    private Map<String, Question> questions = new HashMap<>();


    @Override
    public void addQuestion(String question, String answer) {
        if (!(questions.containsKey(question))) {
            questions.put(question, new Question(question, answer));
        } else {
            throw new QuestionAlreadyAddedException();
        }
    }

    @Override
    public void removeQuestion(String question) {
        if (questions.containsKey(question)) {
            questions.remove(question);
        } else {
            throw new QuestionIsNotExistsException();
        }
    }

    @Override
    public Map<String, Question> getAll() {
        if (!(questions.isEmpty())) {
            return questions;
        } else {
            throw new QuestionRepositoryIsEmptyException();
        }
    }

    @Override
    public Question getRandomQuestion() {
        if (!(questions.isEmpty())) {
            Random random = new Random();
            return questions.get(questions.entrySet().stream().findAny().orElse(null).getKey());
        } else {
            throw new QuestionRepositoryIsEmptyException();
        }
    }
}
