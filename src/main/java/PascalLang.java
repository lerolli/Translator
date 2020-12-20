import java.util.ArrayList;
import java.util.List;

public class PascalLang implements ILanguage {
    List<ITranslator> translatorList;

    public PascalLang(){
        translatorList = new ArrayList<>();
    }
    public void register(ITranslator translator) {
        translatorList.add(translator);
    }

    @Override
    public Token[] translateString(String a) {
        return new Token[0];
    }

    @Override
    public String translateToken(Token[] a) {
        return null;
    }

    public void translate(ITranslator iTranslator) {

    }
}
