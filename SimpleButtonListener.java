import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleButtonListener implements ActionListener {
    private JTextField enter;
    public SimpleButtonListener(JTextField enter){
        this.enter=enter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="C"){
            enter.setText("");
        }else
            enter.setText(enter.getText()+e.getActionCommand());
    }
}
