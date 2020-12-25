public class JavaCloseBracketTranslation implements ITranslator {

    public Tuple tokenize(String[] string, int count) {
        if (string[count].equals("}")) {
            var openBracketToken = new Token();
            openBracketToken.variable = "}";
            count++;
            openBracketToken.nameTranslator = "closeBracket";
            return new Tuple(openBracketToken, count);
        }
        return null;
    }
}
