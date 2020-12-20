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

    public Token[] translateString(String string) {
        var tokenList = new ArrayList<>();
        var counter = 0;
        var isUpdate = false;
        var arrayString = string.split("[ \r\n\t]");
        while (counter != arrayString.length) {

            if (arrayString[counter] != "") {
                for (ITranslator iTranslator : translatorList) {

                    var token = iTranslator.tokenize(arrayString[counter], counter);
                    if (token != null) {
                        tokenList.add(token);
                        isUpdate = true;
                    }
                }

                if (isUpdate)
                    isUpdate = false;
                else
                    return null;
            }
        }
            return (Token[]) tokenList.toArray();

    }

    public String translateToken(Token[] a) {
        return null;
    }
}
