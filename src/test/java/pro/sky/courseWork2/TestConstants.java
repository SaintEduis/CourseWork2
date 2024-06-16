package pro.sky.courseWork2;

import pro.sky.courseWork2.domain.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConstants {
    public static final Question A_QUESTION = new Question("A", "a");
    public static final Question B_QUESTION = new Question("B", "b");
    public static final Question C_QUESTION = new Question("C", "c");
    public static final String EMPTY_STRING = "";
    public static final List<Question> QUESTION_LIST = new ArrayList<>(List.of(A_QUESTION));
    public static final Map<String, Question> ONLY_A_QUESTION_MAP = new HashMap<>(Map.of("A", A_QUESTION));
    public static final Map<String, Question> QUESTION_MAP = new HashMap<>(Map.of("A", A_QUESTION, "B", B_QUESTION, "C", C_QUESTION));
}
