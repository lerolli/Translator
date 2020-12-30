public class JavaCloseBracketTranslation implements ITranslator {

    public Tuple tokenize(String[] string, int count) {
        if (!string[count].equals("}"))
            return null;

        var openBracketToken = new Token();
        openBracketToken.nameTranslator = "closeBracket";
        openBracketToken.variableType = "}";
        count++;
        return new Tuple(openBracketToken, count);
    }
}

