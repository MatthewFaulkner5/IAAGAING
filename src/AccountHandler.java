
import java.util.Scanner;

public class AccountHandler {
    FileHandler myHandler = new FileHandler("C:\\Users\\Matthew\\Documents\\File04.txt",30);
    public void Intro(){
        String[] myArray = {"1.Enter Username","2.New Account","3.Exit"};
        Display(myArray);
        Scanner myInput = new Scanner(System.in); // Create Scanner object
        String userName = myInput.nextLine();  // Read user input
        switch(userName) {
            case "1":
                Login();
                break;
            case "2":
                NewAccount();
            case "3":
                System.out.println("Exitting");
                System.exit(0);
            default:
                System.out.println("Wrong. Exit and try again");
        }
    }

    public void Display(String text[]){
        //code puts a box around code, only temporary and just for my own benefit, as this will be done by swing
        String spaces;
        int spacesnum;
        System.out.println("+============================+");
        //Changes where the sides are depending on the longest length of the menu options
        for (int i = 0;i< text.length;i++) {
            spaces = " ";
            spacesnum = 28 - text[i].length();
            for (int j = 1;j<spacesnum;j++) {
                spaces = spaces + " ";
            }
            System.out.println("|" + text[i] + spaces + "|");
        }
        System.out.println("+============================+");

    }

    public void NewAccount(){
        String[] text = new String[1];
        Scanner myInput = new Scanner(System.in); // Create Scanner object
        text[0] = "Enter Username";Display(text);
        String userName = myInput.nextLine();  // Read user input
        FileHandler myHandler = new FileHandler("C:\\Users\\Matthew\\Documents\\File04.txt",30);
        text[0] = "Enter Password";Display(text);String Password = myInput.nextLine();  // Read user input
        text[0] = "Student or Teacher?";Display(text);String StudentTeacher = myInput.nextLine();
        switch(StudentTeacher) {
            case "1":
                FileHandler.appendLine("C:\\Users\\Matthew\\Documents\\File04.txt", userName + "," + Password + "," + "Student");
                System.out.println("Done");
                Intro();
            case "2":
                FileHandler.appendLine("C:\\Users\\Matthew\\Documents\\File04.txt", userName + "," + Password + "," + "Teacher");
                System.out.println("Done");
                Intro();
            default:
                System.out.println("No can dooo");
                Intro();
        }



    }
    public void Login(){
        String[] text = new String[1];text[0] = "Enter Username";Display(text);
        Scanner myInput = new Scanner(System.in);
        // Create Scanner object
        String userName = myInput.nextLine();  // Read user input
        text[0] = "Enter Password";Display(text);String Password = myInput.nextLine();  // Read user input
        if (myHandler.findRecord(userName + "," + Password + "," + "Teacher") == true){
            System.out.println(" teacher account found");
        }
        if (myHandler.findRecord(userName + "," + Password + "," + "Student") == true){
            System.out.println(" student account found");
        }
    }
}
