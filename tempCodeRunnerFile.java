// DigitalWatch.java
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalWatch extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;

    public DigitalWatch() {
        setTitle("Digital Watch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the frame on the screen

        // Time label
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        updateTime();
        add(timeLabel, BorderLayout.CENTER);

        // Date label
        dateLabel = new JLabel();
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        updateDate();
        add(dateLabel, BorderLayout.SOUTH);

        // Update time every second
        Timer timer = new Timer(1000, e -> {
            updateTime();
            updateDate();
        });
        timer.start();

        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(new Date());
        timeLabel.setText(time);
    }

    private void updateDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        String date = dateFormat.format(new Date());
        dateLabel.setText(date);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalWatch::new);
    }
}
