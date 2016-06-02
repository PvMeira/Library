package util;



public class UIUtil {

    public static final String YES = "yes";
    public static final String NO = "no";
    
    public static void showError(Object msgErro) {
        System.err.println(msgErro);
    }
    
    public static boolean getConfirmation(Object msg) {
        String confirmacao = "NAO";
        do {
            confirmacao = ConsoleReader.scanString(msg+"(yes/no)");
            if (confirmacao.equalsIgnoreCase(YES)) {
                return true;
            }
            else if(confirmacao.equalsIgnoreCase(NO)){
                return false;
            }
            else{
                System.out.println("Invalid option!");
            }                
        }while(confirmacao.equalsIgnoreCase(YES) || 
                confirmacao.equalsIgnoreCase(NO));
        return false;
    } 
    
}