import java.util.*;

public class VirtualManager {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<VirtualAccount> accounts;
    
    private ArrayList<String> transactions;

    public VirtualManager() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addAccount(VirtualAccount account) {
        if (findAccount(account.getphoneNumber()) == null) {
            accounts.add(account);
            System.out.println("Akun berhasil ditambahkan.");
        } else {
            System.out.println("Maksimum akun telah tercapai (2 akun)");
        }
    }

    public void registerAccount() {
        System.out.println("Masukkan Nama Pemilik Akun: ");
        String ownerName = scanner.nextLine();
    
        System.out.println("Masukkan Nomor HP: ");
        String phoneNumber = scanner.nextLine();
    
        System.out.println("Masukkan Password Anda: ");
        String password = scanner.nextLine();
    
        System.out.println("Masukkan Saldo Awal Anda (Minimal: Rp. 50.000): ");
        double balance = scanner.nextDouble();
    
        if (balance < 50000 || balance > 500000) {
            System.out.println("Saldo Awal anda tidak valid! (Rp. 50.000 - Rp. 500.000)");
            return;
        }
    
        System.out.println("\n=== Pilih Jenis Akun ===");
        System.out.println("1. Reguler");
        int type = scanner.nextInt();
    
        VirtualAccount newAccount;
    
        if (type == 1) {
            newAccount = new RegularUser(phoneNumber, password, balance, ownerName);
        } else {
            System.out.println("Pilihan tidak valid!");
            return;
        }
    
        if (newAccount != null) {
            addAccount(newAccount);
            System.out.println("Akun Anda Berhasil Dibuat!");
        }
    }
    

    public VirtualAccount login(String phoneNumber, String password) {
        for (VirtualAccount account : accounts){
        if (account != null && account.authenticate(password)) {
            return account;
            }
        }
        return null;
    }

    public void displayAccounts() {
        for (VirtualAccount account : accounts) {
            account.showAccountInfo();
        }
    }

    public void checkBalance(String phoneNumber) {
        VirtualAccount account = findAccount(phoneNumber);
        if (account != null) {
            System.out.println("Saldo: " + account.getBalance());
        } else {
            System.out.println("Akun tidak ditemukan!");
        }
    }

    public void transfer(String senderAcc, String receiverAcc, double amount) {
    VirtualAccount sender = findAccount(senderAcc);
    VirtualAccount receiver = findAccount(receiverAcc);

    if (sender == null) {
        System.out.println("Nomor Rekening pengirim tidak ditemukan.");
        return;
    } else if (receiver == null) {
        System.out.println("Nomor Rekening penerima tidak ditemukan.");
        return;
    } else if (amount <= 0) {
        System.out.println("Jumlah transfer harus lebih dari 0.");
        return;
    } else if (sender.getBalance() < amount) {
        System.out.println("Saldo tidak mencukupi untuk transfer.");
        return;
    }

    receiver.deposit(amount);

    transactions.add("Transfer dari " + senderAcc + " ke " + receiverAcc + " sejumlah " + amount);
    System.out.println("Transfer berhasil dari " + senderAcc + " ke " + receiverAcc + ".");
}

    private VirtualAccount findAccount(String phoneNumber) {
        for (VirtualAccount account : accounts) {
            if (account.getphoneNumber().equals(phoneNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}