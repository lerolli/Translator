public class JavaPrintTranslation implements ITranslator{
    @Override
    public Tuple tokenize(String[] string, int count) {
        if (string[count].indexOf("System.out.println") == -1)
            return null;
        var printToken = new Token();
        printToken.name = "WriteConsole";
        printToken.ReturnedVariable = string[count].split("\\(")[1].split("\\)")[0];
        count++;
        return new Tuple(printToken, count);
    }
}
