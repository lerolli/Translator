public class JavaPrintTranslator implements ITranslator{

    public Tuple tokenize(String[] string, int count) {
        if (!string[count].contains("System.out.println"))
            return null;

        var printToken = new Token();
        printToken.nameTranslator = "print";
        printToken.name = "WriteConsole";
        printToken.returnedVariable = string[count].split("\\(")[1].split("\\)")[0];
        count++;
        return new Tuple(printToken, count);
    }
}
