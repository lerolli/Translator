public class JavaVariableTranslator implements ITranslator{

    public Tuple tokenize(String[] string, int count) {
        if (count == string.length - 1)
            return null;
        if (!string[count + 1].equals("=")){
            return null;
        }
        var variableToken = new Token();
        variableToken.variable = string[count];
        count+=2;
        var stringBuilder = new StringBuilder();
        while (!string[count].contains(";")) {
            stringBuilder.append(string[count] + " ");
            count++;
        }
        stringBuilder.append(string[count].split(";")[0]);
        variableToken.ReturnedVariable = stringBuilder.toString();
        count++;
        variableToken.nameTranslator = "variable";
        return new Tuple(variableToken, count);
    }
}
