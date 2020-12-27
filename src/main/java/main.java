import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static String getTextFromFile(String fullPath)
    {
        File file = new File(fullPath);
        if (!file.exists()) {
            System.out.println("File '" + fullPath + "' doesn't exist.");
            return null;
        }
        if (file.length() == 0) {
            System.out.println("File '" + fullPath + "' is empty.");
            return null;
        }
        String text = null;
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");
            text = scanner.next();
            scanner.close();
        }
        catch (FileNotFoundException ignored) { }
        return text;
    }


    public static void main(String[] args){

        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Input the full path to the program file: ");
        //String fullPathJava = scanner.nextLine();
        String fullPathJava = "C:\\Users\\zahar\\IdeaProjects\\Translator\\src\\main\\javaprogram.txt";
        //scanner.close();
        String sourceJava = getTextFromFile(fullPathJava);
        String fullPathPascal = "C:\\Users\\zahar\\IdeaProjects\\Translator\\src\\main\\pascalprogram.txt";
        String sourcePascal = getTextFromFile(fullPathPascal);

        Translator tr = new Translator();

        ILanguage pascal = new PascalLang();
        pascal.register(new PascalForTranslator());
        pascal.register(new PascalVarTranslator());
        pascal.register(new PascalVariableTranslation());
        pascal.register(new PascalPrintTranslation());
        pascal.register(new PascalOpenBracketsTranslation());
        pascal.register(new PascalCloseBracketsTranslation());
        pascal.register(new PascalEndProgramTranslator());

        ILanguage java = new JavaLang();
        java.register(new JavaForTranslator());
        java.register(new JavaVarTranslator());
        java.register(new JavaClassTranslator());
        java.register(new JavaMethodTranslator());
        java.register(new JavaVariableTranslator());
        java.register(new JavaPrintTranslation());
        java.register(new JavaOpenBracketTranslator());
        java.register(new JavaCloseBracketTranslation());

        tr.register("pascal", pascal);
        tr.register("java", java);

        String pascalText = tr.translate("java", "pascal", sourceJava);
        //String javaText = tr.translate("pascal", "java", sourcePascal);
        System.out.println(pascalText);
        //System.out.println(javaText);
    }
}
