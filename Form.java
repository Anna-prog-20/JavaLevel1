import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    public Form(String title){
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,400,400);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        JTextField enter=new JTextField();
        add(enter);
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(4,4));
        JButton[] jbs=new JButton[16];
        jbs=createButton(jbs,grid,enter);
        Container container = getContentPane();
        container.add(grid);
    }

    private JButton[] createButton(JButton[] jbs,JPanel grid,JTextField enter) {
        int k = 0;
        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 3:
                    jbs[i] = addNameButton("*");
                    k--;
                    break;
                case 7:
                    jbs[i] = addNameButton("-");
                    k--;
                    break;
                case 11:
                    jbs[i] = addNameButton("+");
                    k--;
                    break;
                case 12:
                    jbs[i] = addNameButton("C");
                    k--;
                    break;
                case 14:
                    jbs[i] = addNameButton("/");
                    k--;
                    break;
                case 15:
                    jbs[i] = addNameButton("=");
                    k--;
                    break;
                default:
                    jbs[i] = new JButton(Integer.toString(k));
                    break;
            }
            grid.add(jbs[i]);
            k++;
            jbs[i].addActionListener(new SimpleButtonListener(enter));

        }
        return jbs;
    }

    private JButton addNameButton(String name){
        return new JButton(name);
    }

    private void arrangeItems(){

    }
}
