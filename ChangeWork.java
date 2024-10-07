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
 * this class modifies workEvent
 */
public class ChangeWork extends JFrame implements ActionListener {
    LinkedList<WorkEvent> workEventList;
    LinkedList<PersonalEvent> personalEventList;
    String type;
    String title;
    String description;
    String eventTimeString;
    Date eventTime;
    String participants;
    String address;
    int delayD;
    JTextField enterTitle;
    JTextField enterDescription;
    JTextField enterTime;
    JTextField enterParticipants;
    JTextField enterAddress;
    JButton submit;
    JButton aReturn;
    WorkEvent workEvent;
    int numberW;
    JFrame frame = new JFrame();
    Font font = new Font(null, Font.BOLD, 20);
    JComboBox<Integer> workBox;
    Integer numbWork = 30;
    ChangeWork(LinkedList<WorkEvent> workEventList, LinkedList<PersonalEvent> personalEventList, int numberW){
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;
        this.numberW = numberW;

        workEvent = workEventList.get(numberW);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,725);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Enter event title");
        titleLabel.setFont(font);
        titleLabel.setBounds(50, 20, 400, 25);
        titleLabel.setBackground(Color.white);
        titleLabel.setOpaque(true);
        frame.add(titleLabel);

        enterTitle = new JTextField();
        enterTitle.setPreferredSize(new Dimension(400, 50));
        enterTitle.setBounds(50, 45, 400, 50);
        enterTitle.setFont(font);
        frame.add(enterTitle);

        JLabel descriptionLabel = new JLabel("Enter event description");
        descriptionLabel.setFont(font);
        descriptionLabel.setBounds(50, 115, 400, 25);
        descriptionLabel.setBackground(Color.white);
        descriptionLabel.setOpaque(true);
        frame.add(descriptionLabel);

        enterDescription = new JTextField();
        enterDescription.setPreferredSize(new Dimension(400, 50));
        enterDescription.setBounds(50, 140, 400, 50);
        enterDescription.setFont(font);
        frame.add(enterDescription);

        JLabel timeLabel = new JLabel("Enter event date   (format: yyyy-mm-dd)");
        timeLabel.setFont(font);
        timeLabel.setBounds(50, 210, 400, 25);
        timeLabel.setBackground(Color.white);
        timeLabel.setOpaque(true);
        frame.add(timeLabel);

        enterTime = new JTextField();
        enterTime.setPreferredSize(new Dimension(400, 50));
        enterTime.setBounds(50, 235, 400, 50);
        enterTime.setFont(font);
        frame.add(enterTime);

        JLabel participantsLabel = new JLabel("Enter participants");
        participantsLabel.setFont(font);
        participantsLabel.setBounds(50, 305, 400, 25);
        participantsLabel.setBackground(Color.white);
        participantsLabel.setOpaque(true);
        frame.add(participantsLabel);

        enterParticipants = new JTextField();
        enterParticipants.setPreferredSize(new Dimension(400, 50));
        enterParticipants.setBounds(50, 330, 400, 50);
        enterParticipants.setFont(font);
        frame.add(enterParticipants);

        JLabel addressLabel = new JLabel("Enter address");
        addressLabel.setFont(font);
        addressLabel.setBounds(50, 400, 400, 25);
        addressLabel.setBackground(Color.white);
        addressLabel.setOpaque(true);
        frame.add(addressLabel);

        enterAddress = new JTextField();
        enterAddress.setPreferredSize(new Dimension(400, 50));
        enterAddress.setBounds(50, 425, 400, 50);
        enterAddress.setFont(font);
        frame.add(enterAddress);

        JLabel delayLabel = new JLabel("Choose delay time (days)");
        delayLabel.setFont(font);
        delayLabel.setBounds(50, 495, 350, 50);
        delayLabel.setBackground(Color.white);
        delayLabel.setOpaque(true);
        frame.add(delayLabel);

        Integer[] numbersWork = new Integer[numbWork];
        for(int i = 0; i < numbWork; ++i)
        {
            numbersWork[i] = i+1;
        }
        workBox = new JComboBox<>(numbersWork);
        workBox.setBounds(400, 495, 50, 50);
        workBox.setFont(font);
        workBox.addActionListener(this);
        frame.add(workBox);


        submit = new JButton("Submit");
        submit.setFont(font);
        submit.setBounds(150, 575, 200, 75);
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

    /**
     * add functionability to frame
     * @param e the event to be processed
     */
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == workBox){
            delayD = workBox.getSelectedIndex();
                workEvent.delay(delayD);
        }
        else if(e.getSource() == submit) {
            if (enterTitle.getText() != null && !enterTitle.getText().trim().isEmpty()) {
                title = enterTitle.getText();
                workEvent.setTitle(title);
            }
            if (enterDescription.getText() != null && !enterDescription.getText().trim().isEmpty()) {
                description = enterDescription.getText();
                workEvent.setDescription(description);
            }
            if (enterTime.getText()!= null && !enterTime.getText().trim().isEmpty()) {
                try {
                    eventTimeString = enterTime.getText();
                    eventTime = formatter.parse(eventTimeString);
                    workEvent.setEventTime(eventTime);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Wrong date input, try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (enterParticipants.getText() != null && !enterParticipants.getText().trim().isEmpty()) {
                participants = enterParticipants.getText();
                workEvent.setParticipants(participants);
            }
            if (enterAddress.getText() != null && !enterAddress.getText().trim().isEmpty()) {
                address = enterAddress.getText();
                workEvent.setAddress(address);
            }
            workEventList.remove(numberW);
            workEventList.add(numberW, workEvent);
        }
        else if(e.getSource() == aReturn){
            frame.dispose();
            ChangeEvent changeEvent = new ChangeEvent(workEventList, personalEventList);
        }
    }
}
