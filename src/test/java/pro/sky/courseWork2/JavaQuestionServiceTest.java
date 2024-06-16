package pro.sky.courseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.courseWork2.exceptions.BadQuestionRequestException;
import pro.sky.courseWork2.exceptions.QuestionAlreadyAddedException;
import pro.sky.courseWork2.exceptions.QuestionIsNotExistsException;
import pro.sky.courseWork2.exceptions.QuestionRepositoryIsEmptyException;
import pro.sky.courseWork2.services.JavaQuestionService;
import pro.sky.courseWork2.services.QuestionService;
import java.util.stream.Stream;
import static pro.sky.courseWork2.TestConstants.*;

public class JavaQuestionServiceTest {
    private final QuestionService out = new JavaQuestionService();

    public static Stream<Arguments> provideParamsForAddQuestion() {
        return Stream.of(
                Arguments.of(A_QUESTION.getQuestion(), A_QUESTION.getAnswer()),
                Arguments.of(B_QUESTION.getQuestion(), B_QUESTION.getAnswer()),
                Arguments.of(C_QUESTION.getQuestion(), C_QUESTION.getAnswer())
        );
    }

    public static Stream<Arguments> provideParamsForRemoveQuestion() {
        return Stream.of(
                Arguments.of("A"),
                Arguments.of("B")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddQuestion")
    public void addQuestion(String question, String answer) {
        out.addQuestion(question, answer);
    }

    @Test
    public void invalidAddQuestion() {
        out.addQuestion(A_QUESTION.getQuestion(), A_QUESTION.getAnswer());

        Assertions.assertThrows(BadQuestionRequestException.class,
                () -> out.addQuestion(EMPTY_STRING, A_QUESTION.getAnswer()));
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                () -> out.addQuestion(A_QUESTION.getQuestion(), A_QUESTION.getAnswer()));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForRemoveQuestion")
    public void removeQuestion(String question) {
        out.addQuestion(A_QUESTION.getQuestion(), A_QUESTION.getAnswer());
        out.addQuestion(B_QUESTION.getQuestion(), B_QUESTION.getAnswer());

        out.removeQuestion(question);
    }

    @Test
    public void invalidRemoveQuestion() {
        Assertions.assertThrows(BadQuestionRequestException.class,
                () -> out.removeQuestion(EMPTY_STRING));
        Assertions.assertThrows(QuestionIsNotExistsException.class,
                () -> out.removeQuestion(A_QUESTION.getQuestion()));
    }

    @Test
    public void getAll() {
        out.addQuestion(A_QUESTION.getQuestion(), A_QUESTION.getAnswer());
        out.addQuestion(B_QUESTION.getQuestion(), B_QUESTION.getAnswer());
        out.addQuestion(C_QUESTION.getQuestion(), C_QUESTION.getAnswer());

        Assertions.assertEquals(QUESTION_MAP, out.getAll());
    }

    @Test
    public void invalidGetAll() {
        Assertions.assertThrows(QuestionRepositoryIsEmptyException.class,
                out::getAll);
    }

    @Test
    public void getRandomQuestion() {
        out.addQuestion(A_QUESTION.getQuestion(), A_QUESTION.getAnswer());
        out.addQuestion(B_QUESTION.getQuestion(), B_QUESTION.getAnswer());
        out.addQuestion(C_QUESTION.getQuestion(), C_QUESTION.getAnswer());

        out.getRandomQuestion();
    }

    @Test
    public void invalidGetRandomQuestion() {
        Assertions.assertThrows(QuestionRepositoryIsEmptyException.class,
                out::getRandomQuestion);
    }
}
