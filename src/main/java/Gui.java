import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui implements ActionListener {

    JFrame frame;
    private ArrayList<JButton> button;

    ArrayList<Cell> grid;

    public Gui(ArrayList<Cell> grid, int size) {
        this.grid = grid;

        createFrame();
        createButtons(size);
        frame.pack();
    }


    private void createFrame() {
        frame = new JFrame("GridBagLayoutDemo");
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.setTitle("Memory Matrix");
        frame.getContentPane().setBackground(new Color(50, 200, 92));

        frame.setVisible(true);


        /* Remove toolbar (close,maximize,minimize,stretch window)
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
         */
    }


    /**
     * initialize
     */
    private void createButtons(int size) {
        this.button = new ArrayList<>();
        JButton tempButton;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempButton = new JButton();
                tempButton.setBackground(this.grid.get(i).getColor());
                tempButton.setEnabled(false);
                tempButton.setSize(50, 50);
                //tempButton.setContentAreaFilled(false);
                button.add(tempButton);
                //tempButton.addActionListener(this);
                c.gridx = j;
                c.gridy = i;
                frame.getContentPane().add(tempButton, c);
            }
        }

        tempButton = new JButton("Start");
        tempButton.setName("Start");
        tempButton.addActionListener(this);
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;       //reset to default
        c.weightx = 1.0;   //request any extra vertical space
        c.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(5, 0, 5, 0);  //top padding
        c.gridx = size / 2;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = size + 1;       //third row
        frame.getContentPane().add(tempButton, c);

        //JLabel label = new JLabel("Number of clicks");
        //frame.getContentPane().add(label);
    }

    private void toggleListener() {
        for (JButton btn : button) {
            if (btn.getAction() != null)
                btn.addActionListener(this);
            else {
                btn.removeActionListener(this);
                System.out.println("removed Listener");
            }
        }
    }

    private void toggleEnable() {
        for (JButton btn : button) {
            if (btn.isEnabled()) {
                btn.setEnabled(false);
            } else {
                btn.setEnabled(true);
            }

        }
    }

    /**
     * pop up with set message
     */
    private void callMessage(String message) {
        //  if(eve.getSource() == jb1)
        JOptionPane.showMessageDialog(frame, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getSource());
        if (e.getSource() instanceof JButton) {
            JButton j = (JButton) e.getSource();
            System.out.println();

            if (j.getName().equals("Start"))
                j.setVisible(false);
            else {
                int i = button.indexOf(e.getSource());
                this.grid.get(i).lightUp();
                button.get(i).setBackground(this.grid.get(i).getColor());
            }
        }


    }

    public void refreshInterface() {
        for (int i = 0; i < button.size(); i++) {

            if (this.grid.get(i).isState()) {
                button.get(i).setBackground(this.grid.get(i).getColor());
            }
        }
    }
}

