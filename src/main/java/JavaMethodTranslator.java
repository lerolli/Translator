public class JavaMethodTranslator implements ITranslator {

    public Tuple tokenize(String[] string, int count) {
        if (!string[count].equals("public"))
            return null;

        while (!string[count].equals("{"))
            count++;
        var t = new Token();
        t.nameTranslator = "0";
        return new Tuple(t, count);
    }
}
