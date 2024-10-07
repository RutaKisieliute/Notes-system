package event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * this clas works with buttons
 */
public class Buttons extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    public List<WorkEvent> workEventList;
    public List<PersonalEvent> personalEventList;

    Buttons(List<PersonalEvent> personalEventList, List<WorkEvent> workEventList) {
        this.personalEventList = personalEventList;
        this.workEventList = workEventList;
        button1 = new JButton();
        button2 = new JButton();

        button1.setBounds(75, 50, 100, 50);
        button2.setBounds(75, 150, 100, 50);
        button1.setText("Save");
        button2.setText("Load");
        button1.setFocusable(false);
        button2.setFocusable(false);
        button1.addActionListener(this);
        button2.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(250, 300);
        this.setVisible(true);
        this.add(button1);
        this.add(button2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            SaveThread thread01 = new SaveThread(workEventList, personalEventList);
            thread01.start();
        } else if (e.getSource() == button2) {
            LoadThread thread02 = new LoadThread(workEventList, personalEventList);
            thread02.start();
        }
    }

}