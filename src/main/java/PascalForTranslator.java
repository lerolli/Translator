public class PascalForTranslator implements ITranslator {

    public Tuple tokenize(String[] string, int count) {
        if (! string[count].equals("for"))
            return null;
        var tokenFor = new Token();
        tokenFor.nameTranslator = "for";
        count += 1;
        tokenFor.variable = string[count];
        count++;
        tokenFor.name = string[count];
        count += 2;
        tokenFor.minValueFor = string[count];
        count += 2;
        tokenFor.maxValueFor = string[count];
        count+= 2;
        return new Tuple(tokenFor, count);
    }
}
