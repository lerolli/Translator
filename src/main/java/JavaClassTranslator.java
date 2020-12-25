public class JavaClassTranslator implements ITranslator {

    public Tuple tokenize(String[] string, int count) {

        var tokenClass = new Token();

        if (string[count].equals("public")) {
            tokenClass.isPublic = true;
            count++;
        }
        else
            return null;

        tokenClass.nameTranslator = "class";

        if (string[count].equals("static")){
            tokenClass.isStatic = true;
            count++;
        }

        if (string[count].equals("class")){
             tokenClass.variable = "class";
            tokenClass.name = string[count + 1];
             count+=2;
        }
        else return null;

        if (string[count].equals("{")){
            return new Tuple(tokenClass, count);
        }

        return null;
    }
}
