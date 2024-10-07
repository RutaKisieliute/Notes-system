package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * this class adds new events
 */
public class NewEvent extends JFrame implements ActionListener {
    String type;
    String title;
    String description;
    String eventTimeString;
    Date eventTime;
    JTextField enterTitle;
    JTextField enterDescription;
    JTextField enterTime;
    JRadioButton workButton;
    JRadioButton personalButton;
    JButton submit;
    JButton aReturn;
    LinkedList<WorkEvent> workEventList;
    LinkedList<PersonalEvent> personalEventList;
    JFrame frame = new JFrame();
    Font font = new Font(null, Font.BOLD, 20);
    NewEvent( LinkedList<WorkEvent> workEventList, LinkedList<PersonalEvent> personalEventList){
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
        workButton.setBounds(50,75, 200, 50);
        personalButton.setFont(font);
        personalButton.setBounds(250, 75, 200, 50);
        workButton.addActionListener(this);
        personalButton.addActionListener(this);
        group.add(workButton);
        group.add(personalButton);
        frame.add(workButton);
        frame.add(personalButton);

        JLabel titleLabel = new JLabel("Enter event title");
        titleLabel.setFont(font);
        titleLabel.setBounds(50, 150, 400, 25);
        titleLabel.setBackground(Color.white);
        titleLabel.setOpaque(true);
        frame.add(titleLabel);

        enterTitle = new JTextField();
        enterTitle.setPreferredSize(new Dimension(400, 50));
        enterTitle.setBounds(50, 175, 400, 50);
        enterTitle.setFont(font);
        frame.add(enterTitle);

        JLabel descriptionLabel = new JLabel("Enter event description");
        descriptionLabel.setFont(font);
        descriptionLabel.setBounds(50, 250, 400, 25);
        descriptionLabel.setBackground(Color.white);
        descriptionLabel.setOpaque(true);
        frame.add(descriptionLabel);

        enterDescription = new JTextField();
        enterDescription.setPreferredSize(new Dimension(400, 50));
        enterDescription.setBounds(50, 275, 400, 50);
        enterDescription.setFont(font);
        frame.add(enterDescription);

        JLabel timeLabel = new JLabel("Enter event date   (format: yyyy-mm-dd)");
        timeLabel.setFont(font);
        timeLabel.setBounds(50, 350, 400, 25);
        timeLabel.setBackground(Color.white);
        timeLabel.setOpaque(true);
        frame.add(timeLabel);

        enterTime = new JTextField();
        enterTime.setPreferredSize(new Dimension(400, 50));
        enterTime.setBounds(50, 375, 400, 50);
        enterTime.setFont(font);
        frame.add(enterTime);


        submit = new JButton("Submit");
        submit.setFont(font);
        submit.setBounds(150, 525, 200, 75);
        submit.setFocusable(false);
        submit.addActionListener(this);
        frame.add(submit);

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

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    EventFactory eventFactory = new EventFactory();

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
        else if(e.getSource() == submit) {
            title = enterTitle.getText();
            description = enterDescription.getText();

                try {
                    eventTimeString = enterTime.getText();
                    eventTime = formatter.parse(eventTimeString);
                    if(type == null){
                        JOptionPane.showMessageDialog(null, "Event type is not chosen", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(type == "WorkEvent"){
                        workEventList.add((WorkEvent) eventFactory.getEvent(type, title, description, eventTime));
                    }
                    else if(type == "PersonalEvent"){
                        personalEventList.add((PersonalEvent) eventFactory.getEvent(type, title, description, eventTime));
                    }

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong date input, try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if(e.getSource() == aReturn){
            frame.dispose();
            MainFrame mainFrame = new MainFrame(workEventList, personalEventList);
        }
    }
}
