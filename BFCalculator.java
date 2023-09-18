//Author Luke Walters
// Purpose of this file is store and evaluate numbers passed in by either QuickCalculator.java or InteractiveCalculator.java

public class BFCalculator {
    //The field that is used to hold Fractions that will be stored
    BigFraction last = new BigFraction(0);
    
    //the array used for the store method
    BigFraction[] stored = new BigFraction[26];

    //Evaluates a string expression given and returns the result as a BigFraction
    public BigFraction evaluate(String exp) {
        //Checks to see if an emnpty String was given
        if(exp.equals("")){
            return new BigFraction(0);
        }
        
        //checks if the first value is a char or number
        String[] holderStr = exp.split("\\s+");
        String charChecker = holderStr[0];
        int j = charChecker.charAt(0);
        if((j >= 97) && (j <= 122)){
            BigFraction holder1 = (stored[j - 97]);
            for (int i = 1; i < holderStr.length; i++) {
            charChecker = holderStr[i+1];
            j = charChecker.charAt(0);
            //checks if the (i + 1) value is a char and evalutes accordingly
            if ((j >= 97) && (j <= 122)){
                BigFraction nextHolder = (stored[j - 97]);
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
                BigFraction nextHolder = (stored[j - 97]);
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
        
    }

    //Stores a value as a Fraction to be later recalled.
    public BigFraction[] store(char register) {
        int base = 97;
        int charVal = register;
        charVal -= base;
        this.stored[charVal] = this.last;

        return stored;
    }



}

