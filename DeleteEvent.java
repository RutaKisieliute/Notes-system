package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * this class deletes event
 */
public class DeleteEvent extends JFrame implements ActionListener {
    JRadioButton workButton;
    JRadioButton personalButton;
    JButton delete;
    JButton aReturn;
    LinkedList<WorkEvent> workEventList;
    LinkedList<PersonalEvent> personalEventList;
    JComboBox<Integer> workBox;
    JComboBox<Integer> personalBox;
    JFrame frame = new JFrame();
    Font font = new Font(null, Font.BOLD, 20);
    Font font1 = new Font(null, Font.BOLD, 15);

    String type;
    int numberW = -1;
    int numberP = -1;
    //String numberType;
    int numbWork;
    int numbPersonal;
    DeleteEvent( LinkedList<WorkEvent> workEventList, LinkedList<PersonalEvent> personalEventList){
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,725);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        ButtonGroup group = new ButtonGroup();

        workButton = new JRadioButton("Work Event");
        personalButton = new JRadioButton("Personal Event");

        workButton.setFont(font);
        workButton.setBounds(50,50, 150, 50);
        personalButton.setFont(font);
        personalButton.setBounds(250, 50, 150, 50);
        workButton.addActionListener(this);
        personalButton.addActionListener(this);
        group.add(workButton);
        group.add(personalButton);
        frame.add(workButton);
        frame.add(personalButton);

        numbWork = workEventList.size();
        numbPersonal = personalEventList.size();
        Integer[] numbersWork = new Integer[numbWork];
        Integer[] numbersPersonal = new Integer[numbPersonal];
        for(int i = 0; i < numbWork; ++i)
        {
            numbersWork[i] = i+1;
        }
        for(int i = 0; i < numbPersonal; ++i)
        {
            numbersPersonal[i] = i+1;
        }

        workBox = new JComboBox<>(numbersWork);
        personalBox = new JComboBox<>(numbersPersonal);

        workBox.setBounds(200, 50, 50, 50);
        personalBox.setBounds(400, 50, 50, 50);

        workBox.setFont(font);
        personalBox.setFont(font);

        workBox.addActionListener(this);
        personalBox.addActionListener(this);

        frame.add(workBox);
        frame.add(personalBox);

        JPanel panel = new JPanel();
        panel.setBounds(50, 125, 400, 400);
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.black);
        JTextArea textArea = new JTextArea(19, 27);
        textArea.setBackground(new Color(0xF0F8FF));
        textArea.append("Work events:\n" + String.valueOf(workEventList) + "\n");
        textArea.append("Personal events:\n" + String.valueOf(personalEventList));
        textArea.setFont(font1);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        frame.add(panel);

        delete = new JButton("Delete");
        delete.setFont(font);
        delete.setBounds(150, 550, 200, 75);
        delete.setFocusable(false);
        delete.addActionListener(this);
        frame.add(delete);

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
        if (e.getSource() == workButton) {
            type = "WorkEvent";
        }
        else if(e.getSource() == personalButton){
            type = "PersonalEvent";
        }
        else if(e.getSource() == workBox){
            numberW = workBox.getSelectedIndex();
        }
        else if(e.getSource() == personalBox){
            numberP = personalBox.getSelectedIndex();
        }
        else if(e.getSource() == delete){
            if(type == "WorkEvent" && numberW != -1){
                workEventList.remove(numberW);
                frame.dispose();
                DeleteEvent deleteEvent1 = new DeleteEvent(workEventList, personalEventList);
            }
            else if(type == "PersonalEvent" && numberP != -1 ){
                personalEventList.remove(numberP);
                frame.dispose();
                DeleteEvent deleteEvent2 = new DeleteEvent(workEventList, personalEventList);
            }
            else{
                JOptionPane.showMessageDialog(null, "Event type and number must be chosen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == aReturn){
            frame.dispose();
            MainFrame mainFrame = new MainFrame(workEventList, personalEventList);
        }
    }
}
