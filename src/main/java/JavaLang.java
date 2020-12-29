import java.util.ArrayList;
import java.util.List;

public class JavaLang implements ILanguage {
    List<ITranslator> translatorList;

    public JavaLang() {
        translatorList = new ArrayList<>();
    }

    public void register(ITranslator iTranslator) {
        translatorList.add(iTranslator);
    }

    public ArrayList<Token> translateString(String string) {
        var tokenList = new ArrayList<Token>();
        var counter = 0;
        var isUpdate = false;

        var arrayString = createArray(string);
        var count = arrayString.length;
        while (counter < arrayString.length) {
            for (ITranslator iTranslator : translatorList) {
                var tuple = iTranslator.tokenize(arrayString, counter);
                if (tuple != null) {
                    tokenList.add(tuple.token);
                    counter = tuple.count;
                    isUpdate = true;
                    if (counter >= arrayString.length)
                        break;
                }
            }
            if (isUpdate)
                isUpdate = false;
            else
                return null;
        }
        return tokenList;
    }

    private String[] createArray(String string) {
        var arrayString = string.split("[ \r\n\t]");
        var listString = new ArrayList<String>();
        for (String str : arrayString) {
            if (!str.equals(""))
                listString.add(str);
        }
        return toArray(listString);
    }

    private String[] toArray(ArrayList<String> listString) {
        var arrayString = new String[listString.size() - 2];
        for (int i = 0; i < listString.size() - 2; i++) {
            arrayString[i] = listString.get(i);
        }
        return arrayString;
    }

    public String translateToken(ArrayList<Token> arrayToken) {

        var stringBuilder = new StringBuilder();
        stringBuilder.append("public class JavaResult { \n ");
        stringBuilder.append("\n");
        stringBuilder.append("public static void main() ");
        for (Token token : arrayToken) {
            switch (token.nameTranslator) {
                case "for":
                    stringBuilder.append("for (").append(token.variableType).append(" ").append(token.name).append(" = ")
                            .append(token.minValueFor).append("; ").append(token.name).append("<=")
                            .append(token.maxValueFor).append("; ").append(token.name).append("++) ");
                    break;
                case "print":
                    stringBuilder.append("System.out.println(").append(token.variableType).append("); \n");
                    break;
                case "variable":
                    stringBuilder.append(token.variableType).append(" = ").append(token.returnedVariable).append("; \n");
                    break;
                case "var":
                    stringBuilder.append("var ").append(token.name).append(" = ")
                            .append(token.returnedVariable).append("; \n");
                    break;
                case "openBracket":
                    stringBuilder.append("{ \n");
                    break;
                case "closeBracket":
                    stringBuilder.append("} \n");
            }
        }
        stringBuilder.append("} \n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

