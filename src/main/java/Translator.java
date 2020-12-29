import java.util.HashMap;

public class Translator{

    HashMap<String, ILanguage> languageDictionary;

    public Translator(){
        languageDictionary = new HashMap<>();
    }

    public void register(String language, ILanguage l) {
        languageDictionary.put(language,l);
    }

    /**
     * Транслирует строку из одного языка программирования в другой
     *
     * Указывается исходный язык, целевой, исходный текст программы.
     *
     * @param inputLanguage исходный язык, из которого надо конвертировать код
     * @param outputLanguage целевой язык, в который надо конвертировать код
     * @param str код в формате строки, который надо транслировать из одного языка в другой
     * @return возвращает оттранслированный код
     */

    public String translate(String inputLanguage, String outputLanguage, String str) {

        if (!(languageDictionary.containsKey(inputLanguage) && languageDictionary.containsKey(outputLanguage)))
            return null;
        var languageInput = languageDictionary.get(inputLanguage);
        var languageOutput = languageDictionary.get(outputLanguage);

        var tokenArrayList =  languageInput.translateString(str);
        if (tokenArrayList == null) throw new NullPointerException();

        return languageOutput.translateToken(tokenArrayList);
    }
}
