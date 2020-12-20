public interface ILanguage {
    public void register(ITranslator a);
    public Token[] translateString(String a);
    public String translateToken(Token[] a);
}
