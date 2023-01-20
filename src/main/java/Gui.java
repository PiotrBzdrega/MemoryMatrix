import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui implements ActionListener  {

    JLabel label;

    JFrame frame;
    JPanel panel;
    private ArrayList<JButton> button;

    public Gui(ArrayList<Cell> grid,int size){
        frame=new JFrame();
        panel=new JPanel();
        panel.setBounds(50,50,700,500);
        panel.setLayout(new GridLayout(size,size));
        createButtons(grid, size);
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Title");
        frame.pack();
        frame.setVisible(true);

/*        button = new JButton("adamek");
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
    frame.setVisible(true);*/
}

    private void createButtons(ArrayList<Cell> grid, int size){
        JButton tempbutton;
        for (int i=0;i<(size*size);i++){
            tempbutton=new JButton();
            tempbutton.setBackground(grid.get(i).getColor());
            tempbutton.addActionListener(this);
            tempbutton.setSize(50,50);
            panel.add(tempbutton);
        }


    }
    // TODO
    //  button.size fault
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i< button.size();i++)
        if (e.getSource()==button.get(i)){
            button.get(i).setBackground(Color.red);
        }
/*        count++;
        label.setText("Number of clicks "+ count);*/
    }
}

