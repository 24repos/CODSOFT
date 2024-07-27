import java.util.*;
class RandomGame {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int score=0, max=5;
        boolean play=true;
        int gamecount = 0;
        int wrongInput=0;

        while(play) {
            int attempts=0;
            boolean guessed=false;
            int number=(int)(Math.random() * 100)+1;
            System.out.println("A number has been chosen b/w 100. Guess it in 5 attempts!.");
            
            while(attempts<max && !guessed) {
                System.out.print("Enter your guess: "); 
                try {
                    int user = sc.nextInt();

                    if((user>100 || user<1)) {
                        System.out.println("Please enter a number between 1-100");
                        wrongInput++;
                        if(wrongInput == 3){
                            System.out.println("Too many wrong inputs");
                            break;
                        }
                    }
                    else {
                        attempts++;
                        if (user > number) {
                            System.out.println("Too high.");
                        } else if (user < number) {
                            System.out.println("Too low.");
                        } else {
                            System.out.println("Guessed the right number!\n");
                            score++;
                            guessed = true;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input must be an integer. Please try again.");
                    sc.next();
                }
                
            }
            if(!guessed) {
                System.out.println("\nOut of attempts. The number was "+ number);
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String response= sc.next();
            play=response.equalsIgnoreCase("yes");
            gamecount+=1;
        }
        sc.close();
        System.out.println("\nTotal Score = "+score+"/"+gamecount+"\nThankyou for playing!");
    }
}