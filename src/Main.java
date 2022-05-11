import java.util.*;

public class Main {
    public static void main (String[] args){
        MainPage Start = new MainPage();

        Database Database =new Database();
        Boolean keepRunning = true;
        while (keepRunning){
            Scanner Sc = new Scanner(System.in);
            String str = Sc.nextLine();

            if (str.equals("create")){
                Database.CreateDatabase();
            }
            else if(str.equals("read")){
                Database.ReadDatabase();
            }
            else if(str.equals("delete")){
                Database.DeleteDatabase();
            }
            else if(str.equals("quit")){
                keepRunning = false;
            }
        }
    }


    public void display(){
        System.out.println("@@@");
    }
}
