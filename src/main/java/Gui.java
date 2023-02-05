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

    ArrayList<Cell> grid;

    public Gui(ArrayList<Cell> grid, int size){
        this.grid=grid;
        createPanel(size);
        createButtons(size);
        createFrame();

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

    private void createPanel(int dimension){
        panel=new JPanel();
        panel.setBounds(0,0,500,500);
        panel.setLayout(new GridLayout(dimension,dimension));
    }
    private void createFrame(){
        frame=new JFrame();
        frame.setSize(800,800);
        //frame.getContentPane().add(panel);
        frame.add(panel,null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Memory Matrix");
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * initialize
     */
    private void createButtons(int size){
        this.button=new ArrayList<>();
        JButton tempButton;
        for (int i=0;i<(size*size);i++){
            tempButton=new JButton();
            tempButton.setBackground(this.grid.get(i).getColor());
            tempButton.addActionListener(this);
            tempButton.setSize(50,50);
            //tempButton.setContentAreaFilled(false);
            button.add(tempButton);
            panel.add(tempButton);
        }
    }
    public void toggleListener(){
        for (JButton btn: button) {
            if (btn.getAction()!=null)
                btn.addActionListener(this);
            else{
                btn.removeActionListener(this);
                System.out.println("removed Listener");
            }

        }
    }

    /**
     * pop up with set message
     */
    private void callMessage(String message){
      //  if(eve.getSource() == jb1)
            JOptionPane.showMessageDialog(panel, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i=button.indexOf(e.getSource());
        this.grid.get(i).lightUp();
        button.get(i).setBackground(this.grid.get(i).getColor());
    }
    public void refreshInterface(){
        for (int i=0;i< button.size();i++) {

            if (this.grid.get(i).isState()) {
                System.out.println("hei");
                button.get(i).setBackground(this.grid.get(i).getColor());
                System.out.println(i);
            }
        }
            }
    }

