//Author Luke Walters
//This calculator will take input to be evaluated or stored from user input until the user types 'QUIT'.

import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {
    
    //main method expects no command line arguments
    public static void main(String[] args) throws Exception{
    String entryStatement = "This is the interactive calculator please input either a string in the form of 'STORE char' or a proper mathamatical expression in order to quit type 'QUIT'";
    Scanner myScan = new Scanner(System.in);
    BFCalculator reader = new BFCalculator();
    PrintWriter pen = new PrintWriter(System.out, true);
     //Prints out instructions on how to utilize the calculator
    pen.println(entryStatement);   


    while (true){
        String inputStr= myScan.nextLine();      
        if (inputStr.equals("QUIT")){
            break;
        }
        pen.print(inputStr + " = ");
        if (inputStr.indexOf("STORE") == 0){
            reader.store(inputStr.charAt(6));
            pen.println("Stored");
        }
        else {
        pen.println(reader.evaluate(inputStr));
        }
        
    



  
    }
    pen.flush();
    myScan.close();
}
}