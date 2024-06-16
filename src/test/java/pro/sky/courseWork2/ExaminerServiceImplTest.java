package pro.sky.courseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseWork2.exceptions.BadAmountException;
import pro.sky.courseWork2.services.ExaminerServiceImpl;
import pro.sky.courseWork2.services.JavaQuestionService;
import static pro.sky.courseWork2.TestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private JavaQuestionService mockJava = Mockito.mock(JavaQuestionService.class);

    private final ExaminerServiceImpl out = new ExaminerServiceImpl(mockJava);

    @Test
    public void getRandomQuestion() {
        Mockito.when(mockJava.getAll()).thenReturn(ONLY_A_QUESTION_MAP);
        Mockito.when(mockJava.getRandomQuestion()).thenReturn(A_QUESTION);
        Assertions.assertEquals(QUESTION_LIST, out.getQuestions(1));
    }

    @Test
    public void invalidGetRandomQuestion() {
        Assertions.assertThrows(BadAmountException.class,
                () -> out.getQuestions(1));
    }
}
