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
        while (!string[count].contains(";")) {
            if (variableToken.ReturnedVariable == null)
                variableToken.ReturnedVariable = string[count] + " ";
            else
                variableToken.ReturnedVariable += string[count] + " ";
            count++;
        }
        variableToken.ReturnedVariable += string[count].split(";")[0];
        count++;
        variableToken.nameTranslator = "variable";
        return new Tuple(variableToken, count);
    }
}
