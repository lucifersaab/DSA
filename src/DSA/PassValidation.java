package DSA;

import java.util.Scanner;

public class PassValidation {
    static boolean upflag;
    static boolean lowflag;
    static boolean numflag;
    static boolean startflag;
    static boolean sizeflag;

    public static void main(String args[]) {

        String in;
        boolean validPassword;
        do {
            System.out.println("Enter password:");
            Scanner sc = new Scanner(System.in);
            in = sc.next();

            validPassword = isValidPassword(in);
            if(!validPassword){
                System.out.println("Password requirements:");
                if(!sizeflag){
                    System.out.println("Password's length should be atleast 6 characters to atmost 9 characters");
                }
                if(!upflag){
                    System.out.println("Password must have an uppercase alphabet");
                }
                if(!lowflag){
                    System.out.println("Password must have an lowercase alphabet");
                }
                if(!startflag) {
                    System.out.println("Password mus start with a letter");

                }
                if(!numflag) {
                    System.out.println("Password must have a number");

                }
            }
            System.out.println("Password is valid:" + validPassword);
        } while (!validPassword);

    }


    public static boolean isValidPassword(String password) {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String upalphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowalphabets = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";

        boolean isValid = true;
        if (password.length() > 9 || password.length() < 6) {
            sizeflag=false;
            isValid = false;
        }
        else sizeflag=true;

        for (int i = 0; i < alphabets.length(); i++) {

            if (password.charAt(0) == alphabets.charAt(i)) {
                isValid = true;
                startflag=true;
                break;
            }
            isValid = false;
            startflag=false;
        }

        for (int l = 0; l < password.length(); l++) {

            for (int i = 0; i < upalphabets.length(); i++) {

                if (password.charAt(l) == upalphabets.charAt(i)) {
                    isValid = true;
                    upflag= true;
                    break;
                }
                isValid = false;
                upflag=false;

            }

            for (int i = 0; i < lowalphabets.length(); i++) {

                if (password.charAt(l) == lowalphabets.charAt(i)) {
                    isValid = true;
                    lowflag=true;
                    break;
                }
                isValid = false;
                lowflag= false;
            }

            for (int i = 0; i < number.length(); i++) {

                if (password.charAt(l) == number.charAt(i)) {
                    isValid = true;
                    numflag=true;
                    break;
                }

                isValid = false;
                numflag=false;

            }
        }
        return isValid;
    }
}
