package casino_game;

public class guessGame {
    // Instance variables
    private String userName;
    private double userDeposit;

    public guessGame(String userName, double userDeposit){
        this.userName = userName; // calling method setUserName
        setUserDeposit(userDeposit); // calling method setUserDeposit
        // so userDeposit is already validated
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        // check if userName provided is not ull
        if (userName != null) {
            this.userName = userName;
        }
    }

    public double getUserDeposit() {
        return userDeposit;
    }

    public void setUserDeposit(double userDeposit) {
        // minimum user initial deposit should be $ 5 or more
        if (userDeposit > 5) {
            this.userDeposit = userDeposit;
        }
    }

    public void displayInfo(){
        System.out.println("User Account Details :");
        System.out.printf("%s %-5s %s %n", "Account Name","", "Amount");
        System.out.printf("%s %-10s %.2f %n", getUserName(),"", getUserDeposit());
    }


}
