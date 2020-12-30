public class JavaCreateVariableTranslator implements ITranslator{

    public Tuple tokenize(String[] string, int count) {

        var tokenVar = new Token();
        tokenVar.nameTranslator = "var";
        tokenVar.variableType = findVariableType(string[count]);

        if (tokenVar.variableType == null)
            return null;

        count++;
        tokenVar.name = string[count];
        count+=2;
        tokenVar.returnedVariable = string[count].split(";")[0];
        count++;
        return new Tuple(tokenVar, count);
    }

    private String findVariableType(String string) {
        var variableNames = new String[]{"byte", "short", "int", "long", "float", "double", "Char", "String", "Boolean"};
        for (String variableName : variableNames) {
            if (variableName.equals(string))
                return string;
        }
        return null;
    }
}
