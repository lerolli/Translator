public class PascalEndProgramTranslator implements ITranslator{
    @Override
    public Tuple tokenize(String[] string, int count) {
        if (string[count].equals("end.")) {
            count++;
            var tokenCloseBrackets = new Token();
            tokenCloseBrackets.nameTranslator = "end program";
            return new Tuple(tokenCloseBrackets, count);
        }
        return null;
    }
}
