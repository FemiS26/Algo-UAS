import java.util.*;

public class VirtualWallet {    
public static void main(String[] args) {
    VirtualManager manager = new VirtualManager();
    Scanner scanner = new Scanner(System.in);

    manager.addAccount(new PremuimUser("0123-4567-0231", "Andi", 5000000.0, "pass123"));
    manager.addAccount(new RegularUser("0987-1192-9563", "Budi", 1000000.0, "pass456"));
    manager.addAccount(new RegularUser("0239-5102-5514", "Citra", 1000000.0, "pass789"));
    manager.addAccount(new PremuimUser("0891-2101-0393", "Kai cenat", 3000000.0, "pass669"));
        
    while (true) {
        System.out.println("\n=== Virtual E-Wallet ===");
        System.out.println("1. Create Account");
        System.out.println("2. Login Account");
        System.out.println("3. Keluar");
        System.out.print("Pilih Menu: ");
            
        try {
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice) {
                case 1:
                    addAccount(manager, scanner);
                    break;
                case 2:
                VirtualAccount user = null;

                while (user == null) {
                    System.out.print("Masukkan Nomor HP: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String password = scanner.nextLine();
            
                    user = manager.login(accNumber, password);
            
                    if (user != null) {
                        System.out.println("Login berhasil! Selamat datang, " + user.getOwnerName());
                        userMenu(manager, user, scanner);
                    } else {
                        System.out.println("Login gagal! Periksa nomor HP atau password.");
                        System.out.println("Coba lagi...");
                    }
                }
                break;
                case 3:
                    System.out.println("Keluar dari Virtual E-Wallet...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!!");
                    break;
            } 
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); 
            }
        }
    }

    public static void userMenu(VirtualManager manager, VirtualAccount user, Scanner scanner) {
        
        while (true) {
            System.out.println("\n=== Menu Akun ===");
            System.out.println("1. Lihat Saldo");
            System.out.println("2. Transfer Dana");
            System.out.println("3. Lihat Data Akun");
            System.out.println("4. QRIS");
            System.out.println("5. Pengaturan Akun");
            System.out.println("6. Lihat Riwayat Transaksi");
            System.out.println("7. Top Up Saldo");
            System.out.println("8. Log out");
            System.out.print("Pilih Menu: ");
            
            try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 8) break;
            int countQRIS = 0;
            
            switch (choice) {
                case 1:
                    System.out.println("Saldo Anda: " + " Rp. " + user.getBalance());
                    break;
                case 2:
               
                    System.out.print("Masukkan Nomor HP Penerima: ");
                    String receiver = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Transfer: Rp. ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    ArrayList<VirtualAccount> accounts = manager.accounts;
                    user.transfer(receiver, amount, accounts);
            
                break;
                case 3:
                    System.out.println("\n=== Data Akun Anda ===");
                    System.out.println("Nomor HP: " + user.getphoneNumber());
                    System.out.println("Nama Pemilik: " + user.getOwnerName());
                    System.out.println("Saldo: " + " Rp. " + user.getBalance());
                    break;
                case 4:
                    if (countQRIS > 3) {
                        System.out.println("QRIS gangguan.");
                    } else {
                    System.out.println("█████████████████████████");
                    System.out.println("█ ░█ █░█ ░█ █░█ ░█ █░█ █");
                    System.out.println("█ ███ ██ ███ ██ ███ ██ █");
                    System.out.println("█ ░█░█░█ ░█░█░█ ░█░█░█ █");
                    System.out.println("█ █████████████████████ █");
                    System.out.println("█ ░░░░░░░░░░░░░░░░░░░░ █");
                    System.out.println("█ █████████████████████ █");
                    System.out.println("█ ░█ █░█ ░█ █░█ ░█ █░█ █");
                    System.out.println("█ ███ ██ ███ ██ ███ ██ █");
                    System.out.println("█ ░█░█░█ ░█░█░█ ░█░█░█ █");
                    System.out.println("█ █████████████████████ █");
                    System.out.println("█ ░░░░░░░░░░░░░░░░░░░░ █");
                    System.out.println("█ █████████████████████ █");
                    System.out.println("█████████████████████████");
                    countQRIS++;
                    }
                    break;
                    
                case 5:
                    updateAccountInfo(user, scanner);
                    break;
                case 6:
                    user.showTransactionHistory();
                    break;
                    
                case 7: 
                    System.out.print("Masukkan jumlah top up: Rp. ");
                    double topUpAmount = scanner.nextDouble();
                    scanner.nextLine();
                    user.topUp(topUpAmount, manager);
                    break;

                    
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
                } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); 
            }
        }
    }

    public static void addAccount(VirtualManager manager, Scanner scanner) {
    System.out.println("\n=== Buat Akun Baru ===");
    System.out.println("Masukkan Nama Anda: ");
    String ownerName = scanner.nextLine();
    System.out.println("Masukkan Nomor HP Anda: ");
    String phoneNumber = scanner.nextLine();
    System.out.println("Masukkan Password Anda: ");
    String password = scanner.nextLine();
    System.out.print("Masukkan Saldo Awal Anda (Minimal: Rp. 50.000): " + "Rp. " );
    double balance = scanner.nextDouble();

    do {
        if (balance < 50000 || balance > 1000000) {
            System.out.print("Saldo tidak valid! Harus antara Rp. 50.000 - Rp. 1.000.000: " + "Rp. ");
            balance = scanner.nextDouble();
        }
    } while (balance < 50000 || balance > 1000000);
    

    scanner.nextLine();

    System.out.println("\n=== Plih Jenis Akun ===");
    System.out.println("1. Reguler User");
    System.out.print("Pilihan: ");
    int type = scanner.nextInt();
    scanner.nextLine();

    VirtualAccount newAccount;
    if (type ==1) {
    newAccount = new RegularUser(phoneNumber, ownerName, balance, password);
    } else {
        System.out.println("Pilihan tidak valid");
        return;
        }
   
        manager.addAccount(newAccount);
        System.out.println("=== Akun Anda Berhasil Dibuat ===");
    
    }

    public static void updateAccountInfo(VirtualAccount user, Scanner scanner) {
        while (true) {
            System.out.println("\n=== Pengaturan Akun ===");
            System.out.println("1. Ganti Nama");
            System.out.println("2. Ganti Nomor Rekening");
            System.out.println("3. Ganti Password");
            System.out.println("4. Kembali");
            System.out.print("Pilih Menu: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
    
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Baru: ");
                    String newName = scanner.nextLine();
                    user.ownerName = newName;
                    System.out.println("Nama berhasil diubah.");
                    break;
                case 2:
                    System.out.print("Masukkan Nomor Rekening Baru: ");
                    String newNumber = scanner.nextLine();
                    user.phoneNumber = newNumber;
                    System.out.println("Nomor rekening berhasil diubah.");
                    break;
                case 3:
                    System.out.print("Masukkan Password Lama: ");
                    String oldPass = scanner.nextLine();
                    if (user.authenticate(oldPass)) {
                        System.out.print("Masukkan Password Baru: ");
                        String newPass = scanner.nextLine();
                        user.password = newPass;
                        System.out.println("Password berhasil diubah.");
                    } else {
                        System.out.println("Password lama salah.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
    
}
