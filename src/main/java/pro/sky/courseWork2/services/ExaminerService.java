package pro.sky.courseWork2.services;

import pro.sky.courseWork2.domain.Question;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(Integer amount);
}
