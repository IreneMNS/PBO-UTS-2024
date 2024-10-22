package com.mycompany.jktseaworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    private int totalTiketTerjual = 0;
    private int tiketDibeliVisitor = 0; // Variabel untuk melacak tiket yang dibeli visitor

    @Override
    public void start(Stage primaryStage) {
        // Komponen untuk form login
        Label welcomeLabel = new Label("Welcome to Seaworld Jakarta!");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");

        // Aksi ketika tombol login diklik
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            handleLogin(username, password, primaryStage);
        });

        // Tata letak GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(welcomeLabel, 0, 0, 2, 1);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(loginButton, 1, 3);

        // Scene untuk login
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Seaworld Login");
        primaryStage.show();
    }

    // Metode untuk menangani logika login
    private void handleLogin(String username, String password, Stage stage) {
        if (username.equals("admin") && password.equals("123")) {
            // Login admin berhasil
            showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome Admin!");
            openAdminPage(stage);
        } else if (username.equals("irene") && password.equals("090913")) {
            // Login visitor berhasil
            showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome Visitor!");
            openVisitorPage(stage);
        } else {
            // Login gagal
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid Username or Password!");
        }
    }

    // Metode untuk menampilkan alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Metode untuk menampilkan halaman admin setelah login
    private void openAdminPage(Stage stage) {
        // Komponen halaman admin
        Label adminLabel = new Label("Welcome, Admin! Manage Seaworld Jakarta:");
        Button tiketButton = new Button("Jumlah Pembelian Tiket");
        Button jadwalButton = new Button("Jadwal Pertunjukan");
        Button hewanButton = new Button("Daftar Hewan");

        // Aksi ketika tombol di halaman admin diklik
        tiketButton.setOnAction(e -> showJumlahPembelianTiket());
        jadwalButton.setOnAction(e -> showJadwalPertunjukan());
        hewanButton.setOnAction(e -> showDaftarHewan());

        // Tata letak GridPane untuk halaman admin
        GridPane adminGridPane = new GridPane();
        adminGridPane.setPadding(new Insets(10));
        adminGridPane.setVgap(10);
        adminGridPane.setHgap(10);

        adminGridPane.add(adminLabel, 0, 0, 2, 1);
        adminGridPane.add(tiketButton, 0, 1);
        adminGridPane.add(jadwalButton, 0, 2);
        adminGridPane.add(hewanButton, 0, 3);

        // Scene untuk halaman admin
        Scene adminScene = new Scene(adminGridPane, 400, 300);
        stage.setScene(adminScene);
        stage.setTitle("Admin Dashboard");
    }

    // Metode untuk menampilkan jumlah pembelian tiket
    private void showJumlahPembelianTiket() {
        showAlert(Alert.AlertType.INFORMATION, "Jumlah Pembelian Tiket", "Total tiket yang terjual: " + totalTiketTerjual);
    }

    // Metode untuk menampilkan jadwal pertunjukan (dummy data untuk contoh)
    private void showJadwalPertunjukan() {
        String jadwal = "Jadwal Pertunjukan:\n- Lumba-lumba Show: 10:00 AM\n- Orca Show: 1:00 PM";
        showAlert(Alert.AlertType.INFORMATION, "Jadwal Pertunjukan", jadwal);
    }

    // Metode untuk menampilkan halaman visitor setelah login
    private void openVisitorPage(Stage stage) {
    // Label dan tombol untuk halaman visitor
    Label visitorLabel = new Label("Welcome, Visitor! Choose your tickets:");
    CheckBox dolphinShow = new CheckBox("Lumba-lumba Show");
    CheckBox orcaShow = new CheckBox("Orca Whale Show");

    // Input jumlah tiket
    Label jumlahTiketLabel = new Label("Jumlah Tiket:");
    TextField jumlahTiketField = new TextField();
    jumlahTiketField.setPromptText("Masukkan jumlah tiket");

    Button orderButton = new Button("Pesan Tiket");
    Button viewTiketButton = new Button("Lihat Jumlah Tiket yang Dibeli");

    // Aksi ketika tombol pesan tiket diklik
    orderButton.setOnAction(e -> {
        try {
            int jumlahTiket = Integer.parseInt(jumlahTiketField.getText());
            handleTicketOrder(dolphinShow.isSelected(), orcaShow.isSelected(), jumlahTiket, stage);
        } catch (NumberFormatException ex) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Jumlah tiket harus berupa angka.");
        }
    });

         // Aksi ketika tombol melihat tiket diklik
    viewTiketButton.setOnAction(e -> showTiketDibeli());

    // Tata letak GridPane untuk halaman pemesanan tiket
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setVgap(10);
    gridPane.setHgap(10);

    gridPane.add(visitorLabel, 0, 0, 2, 1);
    gridPane.add(dolphinShow, 0, 1);
    gridPane.add(orcaShow, 0, 2);
    gridPane.add(jumlahTiketLabel, 0, 3);
    gridPane.add(jumlahTiketField, 1, 3);
    gridPane.add(orderButton, 0, 4);
    gridPane.add(viewTiketButton, 1, 4);

    // Scene untuk pemesanan tiket
    Scene visitorScene = new Scene(gridPane, 400, 300);
    stage.setScene(visitorScene);
    stage.setTitle("Visitor Ticket Booking");
}

    // Metode untuk menangani pemesanan tiket
private void handleTicketOrder(boolean dolphinSelected, boolean orcaSelected, int jumlahTiket, Stage stage) {
    StringBuilder ticketMessage = new StringBuilder("Tiket yang Anda pesan: \n");

    if (dolphinSelected || orcaSelected) {
        if (dolphinSelected) {
            ticketMessage.append("- Pertunjukan Lumba-lumba: ").append(jumlahTiket).append(" tiket\n");
            totalTiketTerjual += jumlahTiket;
            tiketDibeliVisitor += jumlahTiket;
        }
        if (orcaSelected) {
            ticketMessage.append("- Pertunjukan Paus Orca: ").append(jumlahTiket).append(" tiket\n");
            totalTiketTerjual += jumlahTiket;
            tiketDibeliVisitor += jumlahTiket;
        }

        ticketMessage.append("\nSelamat, pembelian tiket Anda berhasil!\nHarap mencetak tiket Anda agar bisa memasuki Seaworld Jakarta.");
        openPaymentOptions(stage); // Buka opsi pembayaran setelah pembelian tiket
    } else {
        ticketMessage = new StringBuilder("Anda belum memilih pertunjukan apapun.");
    }

    showAlert(Alert.AlertType.INFORMATION, "Pembelian Tiket Berhasil", ticketMessage.toString());
}

    // Metode untuk menampilkan jumlah tiket yang dibeli oleh visitor
    private void showTiketDibeli() {
        showAlert(Alert.AlertType.INFORMATION, "Jumlah Tiket Dibeli", "Anda telah membeli " + tiketDibeliVisitor + " tiket.");
    }

    // Metode untuk membuka halaman opsi pembayaran
    private void openPaymentOptions(Stage stage) {
        Label paymentLabel = new Label("Pilih metode pembayaran:");
        Button cashButton = new Button("Bayar dengan Cash di Tempat");
        Button mBankingButton = new Button("Bayar dengan M-Banking");
        Button eWalletButton = new Button("Bayar dengan E-Wallet");

        // Aksi untuk setiap metode pembayaran
        cashButton.setOnAction(e -> showAlert(Alert.AlertType.INFORMATION, "Pembayaran", "Anda memilih untuk membayar dengan cash di tempat."));
        mBankingButton.setOnAction(e -> showAlert(Alert.AlertType.INFORMATION, "Pembayaran", "Anda memilih untuk membayar dengan M-Banking."));
        eWalletButton.setOnAction(e -> showAlert(Alert.AlertType.INFORMATION, "Pembayaran", "Anda memilih untuk membayar dengan E-Wallet."));

        // Tata letak GridPane untuk opsi pembayaran
        GridPane paymentGridPane = new GridPane();
        paymentGridPane.setPadding(new Insets(10));
        paymentGridPane.setVgap(10);
        paymentGridPane.setHgap(10);

        paymentGridPane.add(paymentLabel, 0, 0, 2, 1);
        paymentGridPane.add(cashButton, 0, 1);
        paymentGridPane.add(mBankingButton, 0, 2);
        paymentGridPane.add(eWalletButton, 0, 3);

        // Scene untuk opsi pembayaran
        Scene paymentScene = new Scene(paymentGridPane, 400, 200);
        stage.setScene(paymentScene);
        stage.setTitle("Payment Options");
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showDaftarHewan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
