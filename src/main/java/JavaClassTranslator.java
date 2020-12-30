public class JavaClassTranslator implements ITranslator {

    public Tuple tokenize(String[] string, int count) {

        if (count == string.length - 1)
            return null;
        if (!(string[count].equals("public") && string[count + 1].equals("class")))
            return null;

        count+=4;
        var t = new Token();
        t.nameTranslator = "0";
        return new Tuple(t, count);
    }
}
