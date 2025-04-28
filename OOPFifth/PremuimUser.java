import java.util.ArrayList;

class PremuimUser extends VirtualAccount {
    private double cashbackRate = 0.02;
    
    public PremuimUser(String phoneNumber, String ownerName, double balance, String password) {
        super(phoneNumber, ownerName, balance, password);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit berhasil. Saldo baru: " + " Rp. " + balance);
        }
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

        transactionHistory.add("[TRANSFER] -Rp. " + amount + " ke " + receiverAccount + " | Saldo: Rp. " + balance);

        receiver.transactionHistory.add("[TRANSFER MASUK] +Rp. " + amount + " dari " + phoneNumber + " | Saldo: Rp. " + receiver.getBalance());

        System.out.println("Transfer berhasil ke " + receiverAccount + " sejumlah Rp. " + amount);
    } else {
        System.out.println("Saldo tidak mencukupi.");
        }
    }

    @Override
    public void topUp(double amount, VirtualManager manager) {
        if (amount <= 0) {
            System.out.println("Jumlah tidak valid.");
            return;
        }
        balance += amount;
        transactionHistory.add("[TOP UP] +Rp. " + amount + " | Saldo: Rp. " + balance);
        System.out.println("Top up berhasil. Saldo baru: Rp. " + balance);
    }

    @Override
    public void showAccountInfo() {
        System.out.println("[Premium] Rekening: " + phoneNumber + " | Pemilik: " + ownerName + " | Saldo: "+ " Rp. " + balance + " | Cashback: " + (cashbackRate * 100) + "%");
    }

    public void scanQRIS(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Pembayaran via QRIS berhasil sejumlah " + amount);
        } else {
            System.out.println("Saldo tidak mencukupi untuk pembayaran QRIS.");
        }
    }
}
