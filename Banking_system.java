import java.util.*;
@SuppressWarnings("serial")
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

@SuppressWarnings("serial")
class PinException extends Exception {
    public PinException(String pinmsg) {
        super(pinmsg);
    }
}

@SuppressWarnings("serial")
class StringException extends Exception {
    public StringException(String strmssg) {
        super(strmssg);
    }
}

@SuppressWarnings("serial")
class IntException extends Exception {
    public IntException(String intmssg) {
        super(intmssg);
    }
}

@SuppressWarnings("serial")
class DepositException extends Exception {
    public DepositException(String depmssg) {
        super(depmssg);
    }
}

public class Banking_system {

    public static void main(String[] args) {
        int balance = 0;
        String name = null;
        long bal = 0; // Move 'bal' outside the loop

        try (Scanner sc = new Scanner(System.in)) {
            try {
                System.out.println("Enter Name: ");
                name = sc.next();
                if (name.matches("^[+-]?\\d+$")) {
                    throw new StringException("Invalid input!!");
                }
            } catch (StringException e) {
                System.out.println("Invalid input! Please enter a valid name.");
            }
            
            System.out.println("PRESS 1 to Deposit Amount");
            System.out.println("PRESS 2 to Withdraw");
            System.out.println("PRESS 3 to balance");
            System.out.println("PRESS 4 to EXIT App");
            
            while (true) {
                int opt;
                try {
                    opt = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException ex) {
                    //System.out.println("Invalid input! Please enter a valid option.");
                    continue;
                }

                try {
                    System.out.println("Enter pin: ");
                    int pin = sc.nextInt();
                    if (pin < 1000 || pin > 9999) {
                        throw new PinException("Invalid Pin!!");
                    }
                } catch (InputMismatchException | PinException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine(); // Clear the input buffer
                    continue;
                }


                if (opt == 1) {
                    long deposit = 0;
                    try {
                        System.out.println("---------Deposit Amount--------");
                        System.out.println("Enter Amount: ");
                        deposit = sc.nextLong();
                        if (deposit <= 0) {
                            throw new DepositException("Invalid Amount!!");
                        } else {
                            System.out.println("Processing!!");
                            System.out.println("Amount deposited!!");
                            balance += deposit; // Update the balance after deposit
                            bal = balance; // Update the 'bal' variable
                        }
                    } catch (InputMismatchException | DepositException e) {
                        System.out.println(e.getMessage());
                        sc.nextLine();
                        continue;
                    }

                } else if (opt == 2) {
                	long withdraw;
                    try {
                        System.out.println("---------Withdraw Amount--------");
                        System.out.println("Enter amount: ");
                        withdraw = sc.nextLong();
                        if (withdraw <= 0 || balance < withdraw) {
                            throw new TransactionException("Invalid or insufficient balance");
                        }
                    } catch (InputMismatchException | TransactionException e) {
                        System.out.println(e.getMessage());
                        sc.nextLine(); 
                        continue;
                    }

                    System.out.println("Processing!!!");
                    System.out.println("Amount Debited!!");
                    balance -= withdraw; // Update the balance after withdrawal
                    bal = balance; // Update the 'bal' variable
                } else if (opt == 3) {
                    System.out.println("Balance: " + bal);
                    continue;
                } else if (opt == 4) {
                    System.out.println("Thank You, " + name + "!");
                    break;
                } else {
                     System.out.println("Invalid option! Please enter a valid option.");
                }
            }
        }
    }
}
