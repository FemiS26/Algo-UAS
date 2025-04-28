import java.util.ArrayList;

interface VirtualOperations {
    void deposit(double amount);
    void transfer(String receiverAccount, double amount, ArrayList<VirtualAccount> accounts);
}
