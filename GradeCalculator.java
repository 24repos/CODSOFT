import  java.util.*;
class GradeCalculator {
    public static void main(String[] args) {
    System.out.println("Enter marks of the following subjects, out of 100.");  
    Scanner sc =new Scanner(System.in);
       
        System.out.print("1.Mathematics: ");
        int m1 = sc.nextInt();
        System.out.print("2.English: ");
        int m2=sc.nextInt();
        System.out.print("3.Chemistry: ");
        int m3=sc.nextInt();
        System.out.print("4.Biology: ");
        int m4=sc.nextInt();
        System.out.print("5.Physics: ");
        int m5=sc.nextInt();

    int sum=m1+m2+m3+m4+m5;
    double avg=(sum/5.0);
 
     char grade;
        if (avg>= 90) {
            grade = 'A';
        } else if (90>avg && avg>= 70) {
            grade = 'B';
        }
        else if (70 >avg && avg>= 40) {
            grade = 'C';
        } else {
            grade = 'F';
        }
         System.out.println("\nResults:");
        System.out.println("Total Marks: " + sum);
        System.out.println("Average Percentage: " + avg+ "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }  
}