import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

public class BiodataTeman extends JFrame implements ActionListener {
    private JTextField namaField, teleponField;
    private JRadioButton lakiLakiRadio, perempuanRadio;
    private JCheckBox wargaAsingCheckbox;
    private JTextArea biodataArea;
    private JButton simpanButton;
    private ButtonGroup jenisKelaminGroup;

    public BiodataTeman() {
        super("Aplikasi Biodata Teman");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2)); // Atur layout grid

        // Buat komponen
        JLabel namaLabel = new JLabel("Nama:");
        namaField = new JTextField(20);
        JLabel teleponLabel = new JLabel("Nomor HP:");
        teleponField = new JTextField(20);
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        lakiLakiRadio = new JRadioButton("Laki-Laki");
        perempuanRadio = new JRadioButton("Perempuan");
        wargaAsingCheckbox = new JCheckBox("Warga Negara Asing");
        simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(this);
        biodataArea = new JTextArea(10, 20);
        biodataArea.setEditable(false);
        biodataArea.setLineWrap(true); // Wrap teks agar tidak keluar dari textarea

        // Group radio button jenis kelamin
        jenisKelaminGroup = new ButtonGroup();
        jenisKelaminGroup.add(lakiLakiRadio);
        jenisKelaminGroup.add(perempuanRadio);

        // Tambahkan komponen ke frame
        add(namaLabel);
        add(namaField);
        add(teleponLabel);
        add(teleponField);
        add(jenisKelaminLabel);
        add(lakiLakiRadio);
        add(perempuanRadio);
        add(wargaAsingCheckbox);
        add(new JLabel("")); // Tambah spasi kosong untuk mengatur layout
        add(simpanButton);
        add(new JScrollPane(biodataArea)); // Gunakan JScrollPane untuk textarea

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == simpanButton) {
            String nama = namaField.getText();
            String telepon = teleponField.getText();
            String jenisKelamin = "";
            String wargaAsing = "";

            if (lakiLakiRadio.isSelected()) {
                jenisKelamin = "Laki-Laki";
            } else if (perempuanRadio.isSelected()) {
                jenisKelamin = "Perempuan";
            }

            if (wargaAsingCheckbox.isSelected()) {
                wargaAsing = "Warga Negara Asing";
            }

            if (!nama.isEmpty() && !telepon.isEmpty()) {
                // Tambah data ke textarea dengan pemisah "-"
                biodataArea.append(nama + " - " + telepon + " - " + jenisKelamin + " - " + wargaAsing + "\n");
                namaField.setText("");
                teleponField.setText("");
                lakiLakiRadio.setSelected(false);
                perempuanRadio.setSelected(false);
                wargaAsingCheckbox.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(this, "Silahkan masukkan nama dan nomor telepon.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BiodataTeman());
    }
}
