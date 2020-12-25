public class JavaForTranslator implements ITranslator {

    public Tuple tokenize(String[] string, int count) {
        if (!string[count].equals("for"))
            return null;

        var tokenFor = new Token();
        tokenFor.name = "for";
        count+=4;
        tokenFor.minValueFor = string[count].split(";")[0];
        count+=3;
        tokenFor.maxValueFor = string[count];
        count++;
        tokenFor.step = string[count].split("\\)")[0];
        count++;
        return new Tuple(tokenFor, count);
    }
}
