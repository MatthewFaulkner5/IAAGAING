import java.util.Scanner;

public class Teacher extends Student{
    public Teacher(){

    }
    public void TeacherIntro(){
        String[] myArray = {"1.Enter question","2.Delete Q","3.Exit to menu"};
        Scanner myInput = new Scanner(System.in); // Create Scanner object
        String userName = myInput.nextLine();  // Read user input
        switch(userName) {
            case "1":
                AddQuestion();
                break;
            case "2":
                NewAccount();
            case "3":
                AccountHandler.Intro();
                System.exit(0);
            default:
                System.out.println("Wrong. Exit and try again");
        }
    }


    public void AddQuestion(String EssayName,String Date,String Topic){
        Scanner myInput = new Scanner(System.in); // Create Scanner object
        //uses filehandler to add question to database
        System.out.println("Insert Question");
        FileHandler.appendLine("C:\\Users\\Matthew\\Documents\\QuestionFile.txt",EssayName + " " + Date + " " + Topic);

        String Question = myInput.nextLine();
        FileHandler.appendLine("C:\\Users\\Matthew\\Documents\\QuestionFile.txt",Question);
    }
    public void DeleteQuestion(){
        //Deletes question from database using keywords
    }
    public void EditQuestion(){
        //Replaces question
    }

}
