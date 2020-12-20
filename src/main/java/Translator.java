import java.util.HashMap;

public class Translator{
    HashMap<String, ILanguage> languageDictionary;
    public Translator(){
        languageDictionary = new HashMap<>();
    }

    public void register(String language, ILanguage l) {
        languageDictionary.put(language,l);
    }

    public String translate(String language1, String language2, String str) {

        if (!(languageDictionary.containsKey(language1) && languageDictionary.containsKey(language2)))
            return null;
        var languageInput = languageDictionary.get(language1);
        var languageOutput = languageDictionary.get(language2);

        var tokenResult =  languageInput.translateString(str);
        var strOutputLanguage = languageOutput.translateToken(tokenResult);

        return strOutputLanguage;
    }
}
