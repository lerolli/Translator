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
        var arrayString = string.split("[ \r\n\t]");
        arrayString = removeEmptyCells(arrayString);
        while (counter < arrayString.length) {
            if (arrayString[counter].equals(""))
                counter++;
            else {
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
        }
            return tokenList;
    }

    private String[] removeEmptyCells(String[] arrayString) {
        var listString = new ArrayList<String>();
        for (String str : arrayString){
            if (!str.equals(""))
                listString.add(str);
        }
        return toArray(listString);
    }

    private String[] toArray(ArrayList<String> listString) {
        var arrayString = new String[listString.size()];
        for (int i = 0; i < listString.size(); i++) {
            arrayString[i] = listString.get(i);
        }
        return arrayString;
    }


    public String translateToken(ArrayList<Token> arrayToken) {

        var resultString = new StringBuilder();
        resultString.append("public class JavaResult { \n");
        resultString.append("\n");
        resultString.append("public static void main() { \n");
        for (Token token : arrayToken) {
            switch (token.nameTranslator) {
                case "for":
                    resultString.append("for (").append(token.variable).append(" ").append(token.name).append(" = ")
                                .append(token.minValueFor).append("; ").append(token.name).append("<=")
                                .append(token.maxValueFor).append("; ").append(token.name).append("++) ");
                    break;
                case "print":
                    resultString.append("System.out.println(").append(token.variable).append("); \n");
                    break;
                case "variable":
                    resultString.append(token.variable).append(" = ").append(token.ReturnedVariable).append("; \n");
                    break;
                case "var":
                    resultString.append("var ").append(token.name).append(" = ")
                            .append(token.ReturnedVariable).append("; \n");
                    break;
                case "openBracket":
                    resultString.append("{ \n");
                    break;
                case "closeBracket":
                    resultString.append("}\n");
            }
        }
        resultString.append("} \n");
        resultString.append("}");

        return resultString.toString();
    }
}
