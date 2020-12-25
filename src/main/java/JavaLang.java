import java.util.ArrayList;
import java.util.List;

public class JavaLang implements ILanguage {
    List<ITranslator> translatorList;

    public JavaLang() {
        translatorList = new ArrayList<>();
    }

    public void register(ITranslator iTranslator) {
        translatorList.add(iTranslator);
    }

    public ArrayList<Token> translateString(String string) {
        var tokenList = new ArrayList<Token>();
        var counter = 0;
        var isUpdate = false;
        var arrayString = string.split("[ \r\n\t]");
        while (counter < arrayString.length) {

            if (arrayString[counter] == "")
                counter++;
            else {
                for (ITranslator iTranslator : translatorList) {
                    var tuple = iTranslator.tokenize(arrayString, counter);
                    if (tuple != null) {
                        tokenList.add(tuple.token);
                        counter = tuple.count;
                        isUpdate = true;
                        if (counter >= arrayString.length)
                            break;
                    }
                }
                if (isUpdate)
                    isUpdate = false;
                else
                    return null;
            }
        }
            return tokenList;
    }

    public String translateToken(ArrayList<Token> a) {
        return null;
    }
}