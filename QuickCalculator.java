/**
 * Author Luke Walters
 * Takes in command line arguments and either stores or evaluates them utilzing the BFCalculator file and BigFraction
 */

import java.io.PrintWriter;


public class QuickCalculator {

    /**
     * Main argument checks to see that a command line argument was given and then either stores or evaluates based on the content of the input
     * Expects input in the form of "STORE char" or any number and proper numerical evaluation.
     * @param args - String
     * @throws Exception
     */

    public static void main(String[] args) throws Exception{
        BFCalculator reader = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);
        if(args.length == 0){
            pen.println("You must an input that is either STORE or a numerical expression");
            return;
        }//if(args == 0)

        //for each input checks to see if it either needs to be stored or evaluated.
        for (int i = 0; i < args.length; i++){
            String inputStr = args[i];
            pen.print(inputStr + " = ");
            if (inputStr.indexOf("STORE") == 0){
                reader.store(inputStr.charAt(6));
                pen.println("Stored");
            }//if(STORE)
            else {
            pen.println(reader.evaluate(inputStr));
            }//else
        }//for(args.length)
        pen.flush();

    }//main
}//QuickCalculator