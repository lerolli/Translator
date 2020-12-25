public class JavaPrintTranslation implements ITranslator{
    @Override
    public Tuple tokenize(String[] string, int count) {
        if (!string[count].contains("System.out.println"))
            return null;
        var printToken = new Token();
        printToken.name = "WriteConsole";
        printToken.ReturnedVariable = string[count].split("\\(")[1].split("\\)")[0];
        count++;
        printToken.nameTranslator = "print";
        return new Tuple(printToken, count);
    }
}
