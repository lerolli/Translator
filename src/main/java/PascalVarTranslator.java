public class PascalVarTranslator implements ITranslator{

    public Tuple tokenize(String[] string, int count) {
        if (!string[count].equals("var"))
            return null;
        var varToken = new Token();
        varToken.nameTranslator = "var";
        count++;
        varToken.name = string[count];
        count += 2;
        varToken.returnedVariable = string[count].split(";")[0];
        count++;
        return new Tuple(varToken, count);
    }
}
