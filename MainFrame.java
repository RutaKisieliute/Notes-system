package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * this class creates main frame
 */

public class MainFrame extends JFrame implements ActionListener {
    /**
     * jButton1 used for create event button
     * jButton2 used for delete button
     * jButton3 used for change button
     * jButton4 used for view button
     * jButton5 used for exit button
     * frame shows frame
     * workEventList stores workEvents
     * personalEventList stores personalEvents
     */
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JFrame frame = new JFrame();
    LinkedList<WorkEvent> workEventList;
    LinkedList<PersonalEvent> personalEventList;

    /**
     * creates main frame
     * @param workEventList manage list of workEvents
     * @param personalEventList manage list of personalEvents
     */
    MainFrame(LinkedList<WorkEvent> workEventList, LinkedList<PersonalEvent> personalEventList) {
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 725);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        jButton1 = new JButton("Create new event");
        jButton2 = new JButton("Delete event");
        jButton3 = new JButton("Change event");
        jButton4 = new JButton("View events");
        jButton5 = new JButton("Exit");

        jButton1.setBounds(50, 50, 400, 60);
        jButton2.setBounds(50, 175, 400, 60);
        jButton3.setBounds(50, 300, 400, 60);
        jButton4.setBounds(50, 425, 400, 60);
        jButton5.setBounds(50, 550, 400, 60);

        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
        jButton3.setFocusable(false);
        jButton4.setFocusable(false);
        jButton5.setFocusable(false);

        jButton1.setFont(new Font(null, Font.BOLD, 20));
        jButton2.setFont(new Font(null, Font.BOLD, 20));
        jButton3.setFont(new Font(null, Font.BOLD, 20));
        jButton4.setFont(new Font(null, Font.BOLD, 20));
        jButton5.setFont(new Font(null, Font.BOLD, 20));

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);

        frame.add(jButton1);
        frame.add(jButton2);
        frame.add(jButton3);
        frame.add(jButton4);
        frame.add(jButton5);

        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images1/background.jpg"));
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setSize(500, 725);
        frame.add(jLabel);
        frame.setVisible(true);
    }

    /**
     * give actions for buttons
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            frame.dispose();
            NewEvent newEvent = new NewEvent(workEventList, personalEventList);
        } else if (e.getSource() == jButton2) {
            frame.dispose();
            DeleteEvent deleteEvent = new DeleteEvent(workEventList, personalEventList);
        } else if (e.getSource() == jButton3) {
            frame.dispose();
            ChangeEvent changeEvent = new ChangeEvent(workEventList, personalEventList);
        } else if (e.getSource() == jButton4) {
            frame.dispose();
            ViewEvents viewEvents = new ViewEvents(workEventList, personalEventList);
        } else if (e.getSource() == jButton5) {
            SaveThread thread1 = new SaveThread(workEventList, personalEventList);
            thread1.start();
            frame.dispose();
        }
    }
}
