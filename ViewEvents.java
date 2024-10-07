package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * this class shows all events
 */
public class ViewEvents extends JFrame implements ActionListener {
    JButton aReturn;
    LinkedList<WorkEvent> workEventList;
    LinkedList<PersonalEvent> personalEventList;
    JFrame frame = new JFrame();
    Font font = new Font(null, Font.BOLD, 20);
    Font font1 = new Font(null, Font.BOLD, 15);
    ViewEvents(LinkedList<WorkEvent> workEventList, LinkedList<PersonalEvent> personalEventList){
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,725);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 400, 575);
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.black);
        JTextArea textArea = new JTextArea(28, 27);
        textArea.setBackground(new Color(0xF0F8FF));
        textArea.append("Work events:\n" + String.valueOf(workEventList) + "\n");
        textArea.append("Personal events:\n" + String.valueOf(personalEventList));
        textArea.setFont(font1);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        frame.add(panel);

        aReturn = new JButton("Return");
        aReturn.setFont(font);
        aReturn.setBounds(300, 650, 150, 50);
        aReturn.setFocusable(false);
        aReturn.addActionListener(this);
        frame.add(aReturn);

        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images1/background.jpg"));
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setSize(500, 725);
        frame.add(jLabel);
        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);

    }
    /**
     * add functionability to frame
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aReturn){
            frame.dispose();
            MainFrame mainFrame = new MainFrame(workEventList, personalEventList);
        }
    }
}
