package ui;

import system.*;

import javax.swing.*;
import java.awt.*;

public class JInterface {

    private final JFrame jFrame = new JFrame();
    private static JLabel resIDText = new JLabel("", SwingConstants.CENTER);

    private static final String version = "v0.0.1";

    private static final Color uiColor = new Color(0x1e2733);
    private static final Color textColor = new Color(0x7ca296);

    public JInterface(){
        createJFrame();
    }

    private void createJFrame(){
        jFrame.getContentPane().setBackground(uiColor);
        jFrame.setTitle("Password Checker " + version);

        jFrame.add(createJPanel(resIDText), BorderLayout.CENTER);

        jFrame.setSize(400,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    private JPanel createJPanel(JLabel resID){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        //Possibly add text, inputfields, ect. here
        createText();
        panel.add(resID, BorderLayout.SOUTH);
        panel.add(createSlider(), BorderLayout.CENTER);
        panel.add(createInputField(), BorderLayout.NORTH);

        return panel;
    }

    private void createText(){
        resIDText.setFont(new Font("Verdana", 1, 50));
        resIDText.setForeground(textColor);
    }

    private JSlider createSlider(){
        KPasswordManager kPasswordManager = new KPasswordManager();
        JSlider slider = new JSlider(0, 3, 0);
        slider.setValue(kPasswordManager.checkPassword("Test3094_W"));

        slider.setEnabled(false);
        slider.setOpaque(false);
        slider.setMajorTickSpacing(10);
        return slider;
    }

    private JTextField createInputField(){
        JTextField textField = new JTextField("", 1);
        textField.setSize(400, 50);
        textField.setForeground(uiColor);
        textField.setBackground(textColor);

        textField.setFont(new Font("Verdana", 1, 15));

        return textField;
    }


    public void setText(Float strength){
        resIDText.setText(strength.toString());
    }



}
