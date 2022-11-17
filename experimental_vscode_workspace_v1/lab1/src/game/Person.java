package game;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
     
    public Person(String name, int age) {
       this.name = name;
       this.age = age;
    }
     
    public String getName() {
       return name;
    }
     
    public int getAge() {
       return age;
    }
     
    public String toString() {
       return name + " (" + age + ")";
    }
 
 
 
   public static void main(String[] args) {
       List<Person> persons = new ArrayList<>();
       persons.add(new Person("Nilsson, Sten", 13));
       persons.add(new Person("Jonsson, Camilla", 23));
       persons.add(new Person("Hermansson, Lena", 38));
       persons.add(new Person("Fransson, Anneli", 15));
       persons.add(new Person("Lundström, David", 21));
       persons.add(new Person("Björk, Stefan", 20));
       persons.add(new Person("Andersson, Gun", 55));
       persons.add(new Person("Lundgren, Carina", 12));
       persons.add(new Person("Svensson, Ulf", 47));
         
       // Skriv ut alla personer i listan som har en ålder >= 18.  (*)
      /*  for (Person p : persons) {
           if (p.getAge() >= 18) {
             System.out.println(p);
          }
       }   
       */
     persons.stream().filter(p -> p.getAge() >= 18).forEach(p -> System.out.println(p));
    }
   }
 