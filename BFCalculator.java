/**
 * Author Luke Walters
 * Purpose of this file is store and evaluate numbers passed in by either QuickCalculator.java or InteractiveCalculator.java
*/

public class BFCalculator {

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

    //The field that is used to hold Fractions that will be stored
    BigFraction last = new BigFraction(0);
    
    //the array used for the store method
    BigFraction[] stored = new BigFraction[26];

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

    
    /**
    * Evaluates a string expression given and returns the result as a BigFraction
    * @param exp - String
    * @return - BigFraction
    */
    public BigFraction evaluate(String exp) {
        //Checks to see if an emnpty String was given
        if(exp.equals("")){
            return new BigFraction(0);
        }//if(empty)
        
        int base = 97;
        int maxAlph = 122;
        //checks if the first value is a char or number
        String[] holderStr = exp.split("\\s+");
        String charChecker = holderStr[0];
        int j = charChecker.charAt(0);

        if(!(expressionChecker(holderStr))){

            System.err.println("The expression is not in a valid format");
            return null;
        }

        if((j >= base) && (j <= maxAlph)){
            BigFraction holder1 = (stored[j - base]);
            for (int i = 1; i < holderStr.length; i++) {
            charChecker = holderStr[i+1];
            j = charChecker.charAt(0);

            //checks if the (i + 1) value is a char and evalutes accordingly
            if ((j >= base) && (j <= 122)){
                BigFraction nextHolder = (stored[j - base]);

                if(holderStr[i].equals("+")){
                    holder1 = holder1.add(nextHolder);
                }
                if(holderStr[i].equals("-")){
                    holder1 = holder1.subtract(nextHolder);
                }
                if(holderStr[i].equals("/")){
                    holder1 = holder1.divideFrac(nextHolder);
                }
                if(holderStr[i].equals("*")){
                    holder1 = holder1.multiplyFrac(nextHolder);
                }
                i++;
            }
            else{
                BigFraction nextHolder = new BigFraction(holderStr[i+1]);
                if(holderStr[i].equals("+")){
                    holder1 = holder1.add(nextHolder);
                }
                if(holderStr[i].equals("-")){
                    holder1 = holder1.subtract(nextHolder);
                }
                if(holderStr[i].equals("/")){
                    holder1 = holder1.divideFrac(nextHolder);
                }
                if(holderStr[i].equals("*")){
                    holder1 = holder1.multiplyFrac(nextHolder);
                }
                i++;
            }
        }
        this.last = holder1;
        return holder1;
        }
        
        
        else{
        BigFraction holder1 = new BigFraction(holderStr[0]);
        for (int i = 1; i < holderStr.length; i++) {
            charChecker = holderStr[i+1];
            j = charChecker.charAt(0);
            if ((j >= 97) && (j <= 122)){
                BigFraction nextHolder = (stored[j - base]);
                if(holderStr[i].equals("+")){
                    holder1 = holder1.add(nextHolder);
                }
                if(holderStr[i].equals("-")){
                    holder1 = holder1.subtract(nextHolder);
                }
                if(holderStr[i].equals("/")){
                    holder1 = holder1.divideFrac(nextHolder);
                }
                if(holderStr[i].equals("*")){
                    holder1 = holder1.multiplyFrac(nextHolder);
                }
                i++;
            }
            else{
                BigFraction nextHolder = new BigFraction(holderStr[i+1]);
                if(holderStr[i].equals("+")){
                    holder1 = holder1.add(nextHolder);
                }
                if(holderStr[i].equals("-")){
                    holder1 = holder1.subtract(nextHolder);
                }
                if(holderStr[i].equals("/")){
                    holder1 = holder1.divideFrac(nextHolder);
                }
                if(holderStr[i].equals("*")){
                    holder1 = holder1.multiplyFrac(nextHolder);
                }
                i++;
            }
        }
        this.last = holder1;
        return holder1;
        
        }
        
    }//evaluate(expression)

    /**
     * Stores a value as a Fraction to be later recalled.
     * @return - BigFraction[]
     */
    public BigFraction[] store(char register) {
        int base = 97;
        int charVal = register;
        charVal -= base;
        this.stored[charVal] = this.last;

        return stored;
    }//store(Fraction)


    /**
     * Checks to see if the arithmatic expression is kosher
     * @param exp - String[]
     * @return - boolean
     */
    public boolean expressionChecker(String[] exp){
        String preVal = "none";
        String temp = "none";
        for(int i = 0; i < exp.length - 1; i++){
            int j = exp[i].charAt(0);
            if(((j >= 97) && (j <= 122)) || (Character.isDigit(exp[i].charAt(0)))){
                temp = "number";
                if(temp.equals(preVal)){
                    return false;
                }//if(temp == preVal)
                else{
                    preVal = "number";
                }//else(temp == preVal)
            }//if(number or alphabet)
            if((exp[i].charAt(0) == '+') || (exp[i].charAt(0) == '/') || (exp[i].charAt(0) == '-') || (exp[i].charAt(0) == '*')){
                temp = "arithmetic";
                if(temp.equals(preVal)){
                    return false;
                }//if(temp == preVal)
                else{
                    preVal = "arithmetic";
                }//else(temp == preVal)
            }//if(number or alphabet) 
        }
        return true;
    }//expressionChecker(expression)


}//BFCalculator

