import javax.swing.*;

public class UserInterface {
    private JButton start;

    //private statistics


    public UserInterface() {}

    public void addElement(JButton start){
        this.start=start;
    }

    public void changeText(String text){
        start.setText(text);
    }
}
