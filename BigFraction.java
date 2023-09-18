
import java.math.BigInteger;
import java.lang.Math;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;


  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
    this.simplify();
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.

   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
    this.simplify();
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   */
  public BigFraction(String str) {
    if(str.indexOf("/") == -1){
      int numerator = Integer.parseInt(str);
      this.num = BigInteger.valueOf(numerator);
      this.denom = BigInteger.valueOf(1);
      
    }
    else{
    String[] numbers = str.split("/");
    int numerator = Integer.parseInt(numbers[0]);
    int denominator = Integer.parseInt(numbers[1]);
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);
    this.simplify();
    }
  } // Fraction

  //Build a Fraction through a double val
  public BigFraction(double val) {
    int holder = (int) Math.floor(val);
    double decHolder = val % 1;
    int tempDenom = 1;
    while ((decHolder % 1) != 0) {
      decHolder *= 10;
      tempDenom *= 10;
    }
    holder *= tempDenom;
    this.denom = BigInteger.valueOf(tempDenom);
    this.num = BigInteger.valueOf(holder + (int) decHolder);


    this.simplify();
  }

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+


  


  public void simplify(){
    //BigIntgers used in simplify to make comparisons easier
    BigInteger zero = BigInteger.valueOf(0);
    BigInteger two = BigInteger.valueOf(2);
    BigInteger three = BigInteger.valueOf(3);
    BigInteger five = BigInteger.valueOf(5);
    BigInteger seven = BigInteger.valueOf(7);

    //checks to see if the given Fraction can still be simplified using the minimal number of simplify rules required.
    while (true){
      if (((this.num.mod(two)).equals(zero)) && (this.denom.mod(two).equals(zero))) {
        this.num = this.num.divide(two);
        this.denom = this.denom.divide(two);
    }
    else if (((this.num.mod(three)).equals(zero)) && (this.denom.mod(three).equals(zero))){
        this.num = this.num.divide(three);
        this.denom = this.denom.divide(three);
    }
    else if (((this.num.mod(five)).equals(zero)) && (this.denom.mod(five).equals(zero))){
        this.num = this.num.divide(five);
        this.denom = this.denom.divide(five);
    }
    else if (((this.num.mod(seven)).equals(zero)) && (this.denom.mod(seven).equals(zero))){
        this.num = this.num.divide(seven);
        this.denom = this.denom.divide(seven);
    }
    else {
      break;
    }


  }
}


  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(Fraction)



  public BigFraction subtract(BigFraction subtractMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and subtractMe's denominator
    resultDenominator = this.denom.multiply(subtractMe.denom);
    // Computates the numerator
    resultNumerator = (this.num.multiply(subtractMe.denom)).subtract(subtractMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// subtract(Fraction)



  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero



    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()


  //multiplies two fractions together
  public BigFraction multiplyFrac (BigFraction f1){
    BigInteger ResultNumerator;
    BigInteger ResultDenominator;
    ResultNumerator = this.num.multiply(f1.num);
    ResultDenominator = this.denom.multiply(f1.denom);
    return new BigFraction (ResultNumerator, ResultDenominator);
  }

  //divides the object by the second fraction provided 
  public BigFraction divideFrac (BigFraction f1){
    BigInteger ResultNumerator;
    BigInteger ResultDenominator;
    ResultNumerator = this.num.multiply(f1.denom);
    ResultDenominator = this.denom.multiply(f1.num);
    return new BigFraction (ResultNumerator, ResultDenominator);
  }

  //returns the fractional of an BigFraction object
  public BigFraction fractional()
  {
    BigInteger newNum = this.num.mod(this.denom);
    return new BigFraction(newNum, this.denom);
  }
} // class Fraction
