package wordcounterapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JTextArea textArea = new JTextArea();
        JButton countButton = new JButton("Count Words");
        JLabel resultLabel = new JLabel("Word Count: 0");

        // Style
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Action
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText().trim();
                if (text.isEmpty()) {
                    resultLabel.setText("Word Count: 0");
                } else {
                    String[] words = text.split("\\s+");
                    resultLabel.setText("Word Count: " + words.length);
                }
            }
        });

        // Layout
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(countButton, BorderLayout.SOUTH);
        frame.add(resultLabel, BorderLayout.NORTH);

        // Show frame
        frame.setVisible(true);
    }
}

