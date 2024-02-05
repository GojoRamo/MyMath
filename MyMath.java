import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class MyMath {

/* 
* Collatz Conjecture: Given any positive intiger, the end result will be 1 (No mathematical Proof)
* Input:
*    - num: Any positive intiger
* Output:
*    - List of numbers calculated to reach the end reasult (Size same as above)
*    - Amount of calculations done to reach the end reasult 
*/
    static void CollatzConjecture(double num){  
        int count = 1;
        Queue<Double> CollatzConjectureOut = new LinkedList<Double>();
        CollatzConjectureOut.offer(num);
        if (num < 1){
            System.out.println("Number must be greater then 0");
        }
        else{
            while (num != 1){   
                if (num % 2 == 1){      //If number is odd do: 3(num)+1
                    num = num * 3 + 1;
                }
                else if(num % 2 == 0){  //IF number is even do: num/2
                    num = num / 2;
                }
            CollatzConjectureOut.offer(num);
            count++;
            }
            System.out.println(CollatzConjectureOut);
            System.out.println("Count: " + count);
        }

    }

/* 
 * Quadratic Formula: Used to solve for the x-values of a quadratic equation 
 * Input: 
 *    - a: Quadratic coefficient
 *    - b: Linear coefficient
 *    - c: Constant coefficient
 * Output: 
 *    The x-value/s of the quadratic equation if there are any, otherwise print "No Real Solution"
 */

    public static void QuadraticFormula(double a, double b, double c){
        double TestComplexNum =  ((Math.pow(b, 2))-(4 * a * c));
        if (a == 0){
            System.out.println("The equation is linear");
        }
        else if (TestComplexNum < 0){
            System.out.println("No Real Solution");
        }
        else if (TestComplexNum == 0){
            double QuadraticFormulaAns = ((-b) + (Math.sqrt(TestComplexNum))) / (2 * a) ;
            System.out.println(QuadraticFormulaAns);
        }
        else {
            double QuadraticFormulaAns1 = (((-b) - (Math.sqrt(TestComplexNum))) / (2 * a)) ;
            double QuadraticFormulaAns2 = (((-b) + (Math.sqrt(TestComplexNum))) / (2 * a)) ;
            System.out.println(QuadraticFormulaAns1);
            System.out.println(QuadraticFormulaAns2);
        }
    }
/* 
 * Tell us what numbers in the range given are divisible by two factors and their product
 *      I made this to see if a multiple of a number is also divisible by its factors 
 * Input:
 *    factor1: Factor 1
 *    factor2: Factor 2
 *    RangeMin: The lowest number in range to test for divisibility 
 *    RangeMax: The greatest number in range to test for divisibility 
 * Output:
 *    The list of numbers in range and their divisibility by factor 1, factor 2 and their product 
 *    Amount of numbers divisible by factor 1, factor 2 and their product in range given.  
 */

    public static void if_Num_Divisible_By_Product_And_Factorials (double factor1, double factor2, int RangeMin, int RangeMax){
        double product = factor1 * factor2;
        int count = 0;
        for(int i = RangeMin ; i <= RangeMax ; i++){
            if (i % factor1 == 0 && i % factor2 == 0 && i % product == 0){
                System.out.println();
                System.out.println(i + " is divisible by " + factor1 + " " + factor2 + " " + product);
                System.out.println();
                count++;
            } 
            else{
                System.out.println(i + " is NOT divisible by " + factor1 + " " + factor2 + " " + product);
            }
        }
        System.out.println(count);
    }

/*
 * Gives the list of fibonacci number untuil the n'th number
 * Input: 
 *    n: The n'th number
 * Output: 
 *    A list of fibonacci number
 */

    public static void FibonacciSeries (int n){
        double num1 = 1;
        double num2 = 0;
        double num3 = 0;
        for(int i = 0 ; i < n ; i++){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            System.out.println(num3);
        }
        
    }

/*
 * I used this to see how BigDecimal works, and ended up finding a patern when dividing 1 by powers of 2
 */

    public static void OneDividedByPowersOfTwo(int num){
        //BigDecimal sum = new BigDecimal(0);
        for (int i = 0 ; num > i ; i++){
            BigDecimal sum = BigDecimal.valueOf(1/(Math.pow(2, i))) ; //If you want to add the numbers rename sum to "fun" and remove "//" from comments 
            //sum = sum.add(fun);
            System.out.println(sum);
        }
    }

/*
 * Gives the n'th derivative of a function in the form of x^n 
 * Input: 
 *      Exponent: The n in the equation above
 *      Base: The x in the equation abobe 
 *      Derivative: The number of times to take the derivative of the function 
 * Output: The n'th derivative of a function 
 */

    public static double DerivativePowerRule(double Exponent, int Derivativ, double Base){
        double nSub1 = 0;    
        if (Derivativ == 0){
            return Math.pow(Base, Exponent);
        }    
        else{
            double NewExponent = Exponent;
            for (int i = 0 ; i < Derivativ ; i++){
                nSub1 = NewExponent - 1;
                NewExponent = nSub1;
                
            }
            if (Derivativ == 1){
                return Exponent*(Math.pow(Base, nSub1));
            }
            else{
                double BaseExponent = Exponent;
                for (int l = 1 ; l < Derivativ ; l++){
                    BaseExponent = BaseExponent - 1;
                    Exponent = Exponent * BaseExponent;
                }
            }
            return Exponent*(Math.pow(Base, nSub1));
        }
    }

/*
 * Uses the Taylor Series to find an estamate of a function in the form of x^n
 * Input:
 *      Refer to MyMath.md
 * Output:
 *      Derived Value: Value calculated using Taylor Series 
 *      Actual Value: The real value derived using Math class
 *      % Error: The error between the derived value and actual value 
 */
    public static void TaylorSeries (double Base, double x, int accuracy ,double Exponent){
        int count = 1;
        int count2 = 1;
        double fPRIMEa = 0;
        for (int i = 0 ; i <= accuracy ; i++){
            fPRIMEa = fPRIMEa + ((MyMath.DerivativePowerRule(Exponent, i, Base))/count)*Math.pow(x - Base, i);
            count2 = count2 + 1;
            count = count * count2;
        }
        System.out.println("Derived Value: " + fPRIMEa);
        System.out.println("Actual Value: " + Math.pow(x, Exponent));
        BigDecimal Error = BigDecimal.valueOf((Math.abs(fPRIMEa-(Math.pow(x, Exponent)))/Math.pow(x, Exponent))*100);
        System.out.println("% Erroe: " + Error);
    }
}


