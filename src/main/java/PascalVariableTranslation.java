public class PascalVariableTranslation implements ITranslator {

    public Tuple tokenize(String[] string, int count) {
        if (count == string.length - 1)
            return null;
        if (!string[count + 1].equals(":="))
            return null;
        var variableToken = new Token();
        variableToken.nameTranslator = "variable";
        variableToken.variableType = string[count];
        count+= 2;
        while (!string[count].contains(";")) {
            if (variableToken.returnedVariable == null)
                variableToken.returnedVariable = string[count] + " ";
            else
                variableToken.returnedVariable += string[count] + " ";
            count++;
        }
        variableToken.returnedVariable += string[count].split(";")[0];
        count++;
        return new Tuple(variableToken, count);
    }
}
