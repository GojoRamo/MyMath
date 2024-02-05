// import java.util.Arrays;

//Use "toString" method if output is (@12345)

public class Test {
    public static void main (String[] args){
        System.out.println("Collatz Conjecture");
        MyMath.CollatzConjecture(27);
        System.out.println();

        System.out.println("Quadratic Formula");
        MyMath.QuadraticFormula(5, 22, 1);
        System.out.println();

        System.out.println("if Num Divisible By Product And Factorials");
        MyMath.if_Num_Divisible_By_Product_And_Factorials(4, 8, -50, 50);
        System.out.println();

        System.out.println("FibonacciSerie");
        MyMath.FibonacciSeries(20);
        System.out.println();

        System.out.println("One Divided By Powers Of Two");
        MyMath.OneDividedByPowersOfTwo(8);
        System.out.println();

        System.out.println("Derivative Power Rule");
        System.out.println(MyMath.DerivativePowerRule(0.5, 4, 2));
        System.out.println();

        System.out.println("Taylor Series"); 
        MyMath.TaylorSeries(8, 9, 20, 0.3333333333);
        System.out.println();
    }
}
 

