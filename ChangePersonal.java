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
 * this class modifies PersonalEvent
 */
public class ChangePersonal extends JFrame implements ActionListener {
    LinkedList<WorkEvent> workEventList;
    LinkedList<PersonalEvent> personalEventList;
    String type;
    String title;
    String description;
    String eventTimeString;
    Date eventTime;
    String participants;

    JTextField enterTitle;
    JTextField enterDescription;
    JTextField enterTime;
    JTextField enterParticipants;

    JButton submit;
    JButton aReturn;
    PersonalEvent personalEvent;
    int numberP;
    JFrame frame = new JFrame();
    Font font = new Font(null, Font.BOLD, 20);

    /**
     * creates frame
     * @param workEventList stores workEvents
     * @param personalEventList stores personalEvents
     * @param numberP stores number of PersonalEvents
     */
    ChangePersonal(LinkedList<WorkEvent> workEventList, LinkedList<PersonalEvent> personalEventList, int numberP){
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;
        this.numberP = numberP;

        personalEvent = personalEventList.get(numberP);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,725);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);


        JLabel titleLabel = new JLabel("Enter event title");
        titleLabel.setFont(font);
        titleLabel.setBounds(50, 50, 400, 25);
        titleLabel.setBackground(Color.white);
        titleLabel.setOpaque(true);
        frame.add(titleLabel);

        enterTitle = new JTextField();
        enterTitle.setPreferredSize(new Dimension(400, 50));
        enterTitle.setBounds(50, 75, 400, 50);
        enterTitle.setFont(font);
        frame.add(enterTitle);


        JLabel descriptionLabel = new JLabel("Enter event description");
        descriptionLabel.setFont(font);
        descriptionLabel.setBounds(50, 150, 400, 25);
        descriptionLabel.setBackground(Color.white);
        descriptionLabel.setOpaque(true);
        frame.add(descriptionLabel);

        enterDescription = new JTextField();
        enterDescription.setPreferredSize(new Dimension(400, 50));
        enterDescription.setBounds(50, 175, 400, 50);
        enterDescription.setFont(font);
        frame.add(enterDescription);

        JLabel timeLabel = new JLabel("Enter event date   (format: yyyy-mm-dd)");
        timeLabel.setFont(font);
        timeLabel.setBounds(50, 250, 400, 25);
        timeLabel.setBackground(Color.white);
        timeLabel.setOpaque(true);
        frame.add(timeLabel);

        enterTime = new JTextField();
        enterTime.setPreferredSize(new Dimension(400, 50));
        enterTime.setBounds(50, 275, 400, 50);
        enterTime.setFont(font);
        frame.add(enterTime);

        JLabel participantsLabel = new JLabel("Enter participants");
        participantsLabel.setFont(font);
        participantsLabel.setBounds(50, 350, 400, 25);
        participantsLabel.setBackground(Color.white);
        participantsLabel.setOpaque(true);
        frame.add(participantsLabel);

        enterParticipants = new JTextField();
        enterParticipants.setPreferredSize(new Dimension(400, 50));
        enterParticipants.setBounds(50, 375, 400, 50);
        enterParticipants.setFont(font);
        frame.add(enterParticipants);



        submit = new JButton("Submit");
        submit.setFont(font);
        submit.setBounds(150, 550, 200, 75);
        submit.setFocusable(false);
        submit.addActionListener(this);
        frame.add(submit);

        aReturn = new JButton("Return");
        aReturn.setFont(font);
        aReturn.setBounds(300, 675, 150, 50);
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
    /**
     * add functionality to frame
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            if (enterTitle.getText() != null && !enterTitle.getText().trim().isEmpty()) {
                title = enterTitle.getText();
                personalEvent.setTitle(title);
            }
            if (enterDescription.getText() != null && !enterDescription.getText().trim().isEmpty()) {
                description = enterDescription.getText();
                personalEvent.setDescription(description);
            }
            if (enterTime.getText()!= null && !enterTime.getText().trim().isEmpty()) {
                try {
                    eventTimeString = enterTime.getText();
                    eventTime = formatter.parse(eventTimeString);
                    personalEvent.setEventTime(eventTime);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong date input, try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (enterParticipants.getText() != null && !enterParticipants.getText().trim().isEmpty()) {
                participants = enterParticipants.getText();
                personalEvent.setParticipants(participants);
            }
            personalEventList.remove(numberP);
            personalEventList.add(numberP, personalEvent);
        }
        else if(e.getSource() == aReturn){
            frame.dispose();
            ChangeEvent changeEvent = new ChangeEvent(workEventList, personalEventList);
        }
    }
}

