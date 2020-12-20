import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static String getTextFromFile(String fullPath)
    {
        File file = new File(fullPath);
        if (!file.exists())
        {
            System.out.println("File '" + fullPath + "' doesn't exist.");
            return null;
        }
        if (file.length() == 0)
        {
            System.out.println("File '" + fullPath + "' is empty.");
            return null;
        }
        String text = null;
        try
        {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");
            text = scanner.next();
            scanner.close();
        }
        catch (FileNotFoundException ignored) { }
        return text;
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the full path to the program file: ");
        //String fullPath = scanner.nextLine();
        var fullPath = "C:\\Users\\zahar\\Documents\\temp.txt";
        scanner.close();
        String source = getTextFromFile(fullPath);

        Translator tr = new Translator();
        ILanguage pascal = new PascalLang();
        pascal.register(new PascalForTranslator());
        pascal.register(new PascalVarTranslator());

        ILanguage java = new JavaLang();
        java.register(new JavaForTranslator());
        java.register(new JavavVarTranslator());

        tr.register("pascal", pascal);
        tr.register("java", java);

        String tokens = tr.translate("java", "pascal", source);
        System.out.println(tokens);
    }
}
