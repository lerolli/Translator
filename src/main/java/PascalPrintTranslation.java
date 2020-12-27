public class PascalPrintTranslation implements ITranslator {
    @Override
    public Tuple tokenize(String[] string, int count) {
        if (!string[count].contains("writeln"))
            return null;
        var printToken = new Token();
        printToken.nameTranslator = "print";
        printToken.variable = string[count].split("\\(")[1].split("\\)")[0];
        count++;
        return new Tuple(printToken, count);
    }
}
