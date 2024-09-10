import java.util.Arrays;
import java.util.Scanner;

public class Hungman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = "aa";
        String[] hiddenWord = { "_", "_"};
        String[] hangd = { "_ ", "_"};
        System.out.println("Welcome to hungman");
        System.out.println("Bokstäver att gissa: " + String.join("",
hiddenWord ));

        while (true){
            System.out.println("Gissa en boksta§v");
            String gissning = in.next();
            if (word.contains(gissning))
            {
                System.out.println("Yoouu bra gissning");
                int index = word.indexOf(gissning);
                ///check that there are not several same vocals
                hiddenWord[index] = gissning;
                boolean vunnit = true;

                StringBuilder builder = new StringBuilder(word);
                builder.setCharAt(index, '#');
                word = builder.toString();

                //Testa om du har vunnit.
                for(String str: hiddenWord){
                    if (str.equals("_"))
                    {
                        vunnit = false;
                        break;
                    }
                }
                if (vunnit){
                    System.out.println("Du har vunnit");
                    System.out.println("Hidden word: " +
String.join("", hiddenWord ));
                    break;
                }
             }
            else {

                for(int i = 0; i < hangd.length; i ++){
                    if (hangd[i].equals("_"))
                    {
                        hangd[i] = "#";
                        break;

                    }
                }
                boolean forlorat = true;
                for(String str: hangd){

                    if (str.equals("_"))
                    {
                        forlorat = false;
                    }
                }
                if (forlorat)
                {
                    System.out.println("förlorat ");
                    System.out.println("Inga chanser kvar" +
String.join("", hangd ));
                    break;
                }
                System.out.println("Fel bokstav chanser kvar "
+String.join("", hangd ));

            }
            System.out.println("Hidden word: " + String.join("", hiddenWord ));
        }
        System.out.println("Done");
    }
}