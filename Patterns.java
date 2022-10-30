import java.util.Scanner;

/**
 * Patterns
 */
public class Patterns {
    public static void pattern1(int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }

    public static void pattern2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public static void pattern4(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    public static void pattern5(int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public static void pattern7(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    

    public static void pattern9(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }    
        for (int i = n - 1; i < 0; i--) {
            for (int j = 0; j < n - i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i ; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern10(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }

    public static void pattern11(int n){
        int x = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(x);
                if(x == 0) x = 1;
                else if(x == 1) x = 0;
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        //pattern6(5, 5);
        pattern11(5);
    }
}