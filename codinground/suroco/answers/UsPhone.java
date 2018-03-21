
import java.util.Scanner;

public class UsPhone {


    static String find_phone_number(String phnNumber) {
        boolean numberFound = false;
        int n = phnNumber.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(phnNumber.charAt(i))) {
                if (i + 11 < n) {
                    if (phnNumber.charAt(i + 3) == '-' && phnNumber.charAt(i + 7) == '-') {
                        for (int j = 1; j <= 11; j++) {
                            if (j != 3 && j != 7) {
                                if (Character.isDigit(phnNumber.charAt(i + j))) {
                                    numberFound = true;
                                } else {
                                    numberFound = false;
                                    break;
                                }
                            }
                        }
                        if (numberFound) {
                            return phnNumber.substring(i, i + 12);
                        }
                    }
                }
            }
            if (phnNumber.charAt(i) == '(') {
                if (i + 13 <= n) {
                    System.out.print("in side if 2.1");
                    if (phnNumber.charAt(i + 4) == ')' && phnNumber.charAt(i + 5) == ' ' && phnNumber.charAt(i + 9) == '-') {
                        for (int j = 1; j <= 13; j++) {

                            System.out.println("2nd" + i + j);
                            if (j != 4 && j != 5 && j != 9) {
                                if (Character.isDigit(phnNumber.charAt(i + j))) {
                                    numberFound = true;
                                } else {
                                    numberFound = false;
                                    break;
                                }
                            }
                        }
                        if (numberFound) {
                            return phnNumber.substring(i, i + 14);
                        }
                    }
                }

            }
        }
        return "NONE";

    }
    public static void main(String[] args){
      String out =find_phone_number("1234567890");
      System.out.println("Output :"+out);
    }

}