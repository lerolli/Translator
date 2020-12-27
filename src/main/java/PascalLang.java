import java.util.ArrayList;
import java.util.List;

public class PascalLang implements ILanguage {
    List<ITranslator> translatorList;

    public PascalLang(){
        translatorList = new ArrayList<>();
    }
    public void register(ITranslator translator) {
        translatorList.add(translator);
    }

    public ArrayList<Token> translateString(String string) {
        var tokenList = new ArrayList<Token>();
        var counter = 0;
        var isUpdate = false;
        var arrayString = string.split("[ \n\r]");
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

    public String translateToken(ArrayList<Token> arrayToken) {
        var resultString = new StringBuilder();
        resultString.append("Begin \n");
        for (Token token : arrayToken) {
            switch (token.nameTranslator) {
                case "for":
                    resultString.append("for ").append("var ").append(token.name).append(" := ")
                                .append(token.minValueFor).append(" to ").append(token.maxValueFor).append(" do \n");
                    break;
                case "print":
                    resultString.append("writeln(").append(token.ReturnedVariable).append(") \n");
                    break;
                case "variable":
                    resultString.append(token.variable).append(" := ").append(token.ReturnedVariable).append("; \n");
                    break;
                case "var":
                    resultString.append("var ").append(token.name).append(" := ")
                                .append(token.ReturnedVariable).append("; \n");
                    break;
                case "openBracket":
                    resultString.append("Begin \n");
                    break;
                case "closeBracket":
                    resultString.append("end; \n");
            }
        }
        resultString.append("end.");

        return resultString.toString();
    }
}
