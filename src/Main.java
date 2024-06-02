public class Main {
    private final String adminUserName = "ashwin@dmin";
    private final String password = "SpideY@16";

    public String getAdminUserName() {
        return adminUserName;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        Validation validation = new Validation();
        MenuPage menuPage = new MenuPage();
        Main main = new Main();

        while (true){
            System.out.println("\n1. ADMIN\n2. USER\n3. EXIT");
            switch (validation.validInt("Option")){
                case 1 : if(validation.isValidAdmin(main.getAdminUserName(),main.getPassword()))
                    menuPage.adminMenu();
                    break;
                case 2 : menuPage.userPage();
                    break;
                case 3 :
                    System.out.println("Thank You");
                    return;
                default:System.out.println("ENTER VALID OPTION");
            }
        }
    }
}
