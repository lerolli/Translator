import java.util.ArrayList;

public interface ILanguage {
    public void register(ITranslator a);
    public ArrayList<Token> translateString(String a);
    public String translateToken(ArrayList<Token> a);
}
