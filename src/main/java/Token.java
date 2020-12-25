import java.util.ArrayList;

public class Token {
    String nameTranslator;
    Boolean isPublic;
    Boolean isStatic;
    String variable;
    String ReturnedVariable;
    String name;
    String minValueFor;
    String maxValueFor;
    String step;
    ArrayList<Token> childrenTokens;

    public Token(){
        childrenTokens = new ArrayList<>();
    }


}
