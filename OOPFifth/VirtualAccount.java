import java.util.ArrayList;

public abstract class VirtualAccount implements VirtualOperations {
    protected String phoneNumber;
    protected String ownerName;
    protected double balance;
    protected String password;
    protected String accountType;
    ArrayList<String> transactionHistory = new ArrayList<>();
    private double cashbackRate = 0.02;


    public VirtualAccount(String phoneNumber, String ownerName, double balance, String password) {
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.password = password;
        this.accountType = accountType;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public String accountType() {
        return accountType;
    }

    public void topUp(double amount, VirtualManager manager) {
    System.out.println("Top up tidak tersedia untuk jenis akun ini.");
    }

    @Override
    public void transfer(String receiverAccount, double amount, ArrayList<VirtualAccount> accounts) {
    if (amount <= 0) {
        System.out.println("Jumlah transfer tidak valid.");
        return;
    }

    VirtualAccount receiver = null;
    for (VirtualAccount acc : accounts) {
        if (acc.getphoneNumber().equals(receiverAccount)) {
            receiver = acc;
            break;
        }
    }

    if (receiver == null) {
        System.out.println("Rekening penerima tidak ditemukan.");
        return;
    }

    if (balance >= amount) {
        balance -= amount;
        receiver.deposit(amount);

        transactionHistory.add("[TRANSFER] -Rp. " + amount + " ke " + receiverAccount + " | Saldo: Rp. " + balance + " dan anda mendapatkan cashback sebesar: " + cashbackRate * 100 );

        receiver.transactionHistory.add("[TRANSFER MASUK] +Rp. " + amount + " dari " + phoneNumber + " | Saldo: Rp. " + receiver.getBalance());

        System.out.println("Transfer berhasil ke " + receiverAccount + " sejumlah " + amount);
    } else {
        System.out.println("Saldo tidak mencukupi.");
        }
    }

    
    public void showTransactionHistory() {
    if (transactionHistory.isEmpty()) {
        System.out.println("Belum ada riwayat transaksi.");
    } else {
        System.out.println("\n=== Riwayat Transaksi ===");
        for (String history : transactionHistory) {
            System.out.println(history);
            }   
        }
    }

    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public abstract void showAccountInfo();
}