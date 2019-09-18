import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CsvToObjConverter converter = new CsvToObjConverter();
        // prompt for csv delimeter
        String delimeter = promptForCsvDelimeter();
        converter.setDelimiter(delimeter);
        converter.setFilePath("C2ImportCalEventSample.csv");
        converter.convertFileToObjs();
        converter.printObjects();

    }

    public static String promptForCsvDelimeter() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose a column seperator for your CSV file");
        System.out.print(
                "1. Commas \n2. Semicolon \n"
        );
        System.out.println("enter 1 for 2");
       try {
           int answer = in.nextInt();
           if (answer == 1) {
               return ",";
           } else if (answer == 2) {
               return ";";
           } else {

               System.out.println("you have not entered 1 or 2");
               return promptForCsvDelimeter();
           }
       } catch (InputMismatchException e){
           System.out.println("you have not entered 1 or 2");
           return promptForCsvDelimeter();
       }

    }


}

