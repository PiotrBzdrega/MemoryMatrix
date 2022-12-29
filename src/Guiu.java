import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guiu implements ActionListener  {

    int count=0;
    JLabel label;

    JFrame frame;
    JPanel panel;
    JButton button;

    public Guiu(){
        button = new JButton("adamek");
        button.addActionListener(this); //when button to be pressed, actionPerformed() will be called
        label=new JLabel("Number of clicks");

    frame=new JFrame();
    panel=new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
    panel.setLayout(new  GridLayout(5,5));
    panel.add(button);
    panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Title");
    frame.pack();
    frame.setVisible(true);
}
    public static void main(String[] args) {
        new Guiu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks "+ count);
    }
}

