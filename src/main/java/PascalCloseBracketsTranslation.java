public class PascalCloseBracketsTranslation implements ITranslator {

    public Tuple tokenize(String[] string, int count) {

        if (!string[count].equals("end;"))
            return null;

        count++;
        var tokenCloseBrackets = new Token();
        tokenCloseBrackets.nameTranslator = "closeBracket";
        return new Tuple(tokenCloseBrackets, count);
    }
}
