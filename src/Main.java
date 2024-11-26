import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String startMessage = "What do you want to do? \n 1. Start Simulation\n 2. End Simulation\n 3. Status display\n 4. Quit";
        System.out.println(startMessage);

        int number;  //this stores the input value that user enters as the option

        //Loop until user enters a correct format
        while (true){
            if (input.hasNextInt()){
                number = input.nextInt();

                //check if the input is 1, 2 or 3
                if (number == 1 || number ==2 || number == 3 || number == 4){
                    break;
                }else {
                    System.out.println("Invalid input. Enter 1 or 2 or 3 or 4\n \n" + startMessage);
                }
            }else{
                System.out.println("Invalid format. Enter an integer\n \n" + startMessage);
                input.next();
            }
        }

        //call the function according to the user input
        if (number == 1){

        } else if (number == 2) {

        } else if (number == 3) {

        }else {

        }
    }
}