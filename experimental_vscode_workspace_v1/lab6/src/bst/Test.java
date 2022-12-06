package bst;

public class Test {

    public static void mystery(int n) {
       if (n > 0){
          mystery(n-1);
          System.out.print(n * 4);
          mystery(n-1);
       } 
    }
 
    public static void main(String[] args) {
       Test.mystery(3);
    } 
 }