import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    private static final Pattern authorTitle_pattern = Pattern.compile("^[a-zA-Z1-9 ]+$");
    private static final Pattern yearValidation = Pattern.compile("^\\d{4}$");
    private static final Pattern passwordValidation = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    Scanner input = new Scanner(System.in);
    public String authorTitle(String string){
        String output;
        while(true){
            System.out.print(string +" : ");
            output = input.nextLine();
            while(output.isEmpty()){
                output = input.nextLine();
            }
            if(!authorTitle_pattern.matcher(output).matches())
                System.out.println("Invalid Title");
            else
                break;
        }
        return output;
    }

    public String validYear(){
        String year;
        while(true){
            System.out.print("Year : ");
            year = input.next();
            if(!yearValidation.matcher(year).matches())
                System.out.println("Invalid Year");
            else
                break;
        }
        return year;
    }

    public int validId(Map<Integer,Book> books){
        int id = 0,option;
        while (true){
            id = validInt("Id");
            if(!books.containsKey(id)) {
                System.out.println("ENTER INVALID ID");
                System.out.println("Do you Want to Continue");
                System.out.print("1. Yes\n2. No\n");
                option = validInt("choice");
                switch (option){
                    case 1 : continue;
                    case 2 : return id;
                    default:
                        System.out.println("Enter Valid Option");
                }
            }
            else
                break;
        }
        return id;
    }
    public int validInt(String string){
        int number = 0;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter "+string+" : ");
                number = sc.nextInt();
                sc.close();
            } catch (Exception e) {
                System.out.println(string+" contains numbers only");
            }

        return number;
    }

    public boolean isValidAdmin(String adminUserName,String adminPassword){
        System.out.print("Enter User Name : ");
        String userName = input.next();
        if(!adminUserName.equals(userName)){
            System.out.println("Invalid UserName");
            return false;
        }
        System.out.print("Enter Password : ");
        String password = input.next();
        if(!adminPassword.equals(password)){
            System.out.println("Invalid Password");
            return false;
        }
        return true;
    }

    public String validPassword(){
        String password;
        while (true){
            System.out.print("Enter Password : ");
            password = input.next();
            if(!passwordValidation.matcher(password).matches()){
            }
            else
                break;
        }
        return password;
    }
}

