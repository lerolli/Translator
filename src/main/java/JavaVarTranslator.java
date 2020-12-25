public class JavaVarTranslator implements ITranslator{

    public Tuple tokenize(String[] string, int count) {

        var variableNames = new String[]{"byte", "short", "int", "long", "float", "double", "Char", "String", "Boolean", };
        var tokenVar = new Token();

        for (int i = 0; i < variableNames.length; i++) {
            if (variableNames[i].equals(string[count])) {
                tokenVar.variable = string[count];
                break;
            }
        }
        if (tokenVar.variable == null)
            return null;

        count++;
        tokenVar.name = string[count];
        count+=2;
        tokenVar.ReturnedVariable = string[count];
        count++;
        return new Tuple(tokenVar, count);
    }
}
