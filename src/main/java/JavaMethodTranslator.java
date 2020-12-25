public class JavaMethodTranslator implements ITranslator {

    public Tuple tokenize(String[] string, int count) {

        var variableNames = new String[]{"void", "String", "Boolean", "int"};

        var tokenMethod = new Token();

        if (string[count].equals("public")) {
            tokenMethod.isPublic = true;
            count++;
        }
        else
            return null;

        if (string[count].equals("static")) {
            tokenMethod.isStatic = true;
            count++;
        }


        for (String variableName : variableNames) {
            if (variableName.equals(string[count])) {
                tokenMethod.variable = string[count];
                count++;

                var a = string[count].split("[(]");
                tokenMethod.name = a[0];
                var childrenToken = new Token();
                childrenToken.variable = a[1];
                count++;
                while (!string[count].contains(")")) {
                    if (!string[count].contains(",")) {
                        childrenToken.variable = string[count];
                    }
                    else{
                        var temp = string[count].split(",")[0];
                        childrenToken.name = temp;
                        tokenMethod.childrenTokens.add(childrenToken);
                        childrenToken = new Token();
                    }
                    count++;
                }
                childrenToken.name = string[count].split("\\)")[0];
                tokenMethod.childrenTokens.add(childrenToken);
                count++;
                tokenMethod.nameTranslator = "method";
                return new Tuple(tokenMethod, count);
            }

        }
        return null;
    }

}
