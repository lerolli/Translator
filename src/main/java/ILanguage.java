import java.util.ArrayList;

public interface ILanguage {
    void register(ITranslator a);


    ArrayList<Token> translateString(String a);

    String translateToken(ArrayList<Token> a);
}
