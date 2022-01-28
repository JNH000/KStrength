package ui;

import system.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JInterface {

    private final JFrame jFrame = new JFrame();
    private final JSlider jSlider = createSlider();
    private static JLabel resIDText = new JLabel("", SwingConstants.CENTER);

    private static final String version = "v0.0.1";

    private static final Color uiColor = new Color(0x1e2733);
    private static final Color textColor = new Color(0x7ca296);

    private KPasswordManager kPasswordManager = new KPasswordManager();

    private static String savedInput = "";

    public JInterface(){
        createJFrame();
    }

    private void createJFrame(){
        final URL iconURL = getClass().getResource("/img/Icon2.png");
        ImageIcon icon = new ImageIcon(iconURL);

        jFrame.getContentPane().setBackground(uiColor);
        jFrame.setTitle("Password Checker " + version);
        jFrame.setIconImage(icon.getImage());

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
        panel.add(jSlider, BorderLayout.CENTER);
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
        slider.setValue(kPasswordManager.checkPassword(savedInput));

        slider.setEnabled(false);
        slider.setOpaque(false);
        slider.setMajorTickSpacing(10);
        return slider;
    }

    public JTextField createInputField(){
        JTextField textField = new JTextField("", 1);
        textField.setSize(400, 50);
        textField.setForeground(uiColor);
        textField.setBackground(textColor);
        textField.setBorder(null);

        textField.setFont(new Font("Verdana", 1, 15));
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savedInput = textField.getText();
                jSlider.setValue(kPasswordManager.checkPassword(savedInput));

                String strength = kPasswordManager.getpStrength();
                resIDText.setText(strength);
            }
        });

        return textField;
    }





}
