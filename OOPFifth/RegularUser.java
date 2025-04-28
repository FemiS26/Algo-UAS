import java.util.ArrayList;

class RegularUser extends VirtualAccount{
    public RegularUser(String phoneNumber, String ownerName, double balance, String password) {
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
    public void topUp(double amount, VirtualManager manager) {
        if (amount < 10000) {
            System.out.println("Minimal Top Up adalah Rp. 10.000");
            return;
            
        } else if (amount > 1000000) {
            System.out.println("Maksimal Top Up adalah Rp. 1.000.000");
            return;
            
        }
        balance += amount;
        transactionHistory.add("[TOP UP] +Rp. " + amount + " | Saldo: Rp. " + balance);
        System.out.println("Top up berhasil. Saldo baru: Rp. " + balance);
    }


    @Override
    public void showAccountInfo() {
        System.out.println("[Regular] Rekening: " + phoneNumber + " | Pemilik: " + ownerName + " | Saldo: " + " Rp. " + balance);
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

        System.out.println("Transfer berhasil ke " + receiverAccount + " sejumlah " + " Rp. " + amount);
    } else {
        System.out.println("Saldo tidak mencukupi.");
        }
    }



    public void scanQRIS(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Pembayaran via QRIS berhasil sejumlah " + " Rp. " + amount);
        } else {
            System.out.println("Saldo tidak mencukupi untuk pembayaran QRIS.");
        }
    }
}
