import java.util.ArrayList;

public class JavaChangeVariableValueTranslator implements ITranslator{

    public Tuple tokenize(String[] string, int count) {

        if (count == string.length - 1)
            return null;
        if (!string[count + 1].equals("=")){
            return null;
        }

        var variableToken = new Token();
        variableToken.nameTranslator = "variable";
        variableToken.variableType = string[count];
        count+=2;
        var stringBuilder = new StringBuilder();
        while (!string[count].contains(";")) {
            stringBuilder.append(string[count]).append(" ");
            count++;
        }
        stringBuilder.append(string[count].split(";")[0]);

        variableToken.returnedVariable = stringBuilder.toString();
        count++;
        return new Tuple(variableToken, count);
    }

}
