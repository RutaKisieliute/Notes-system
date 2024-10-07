package event;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Test {

    /**
     * this is a personal note system
     * @param args arguments
     * @throws ParseException shown then parse exception
     * @throws CloneNotSupportedException shown then clone is not supported exception
     * @throws IOException shown then input output exception
     * @throws ClassNotFoundException shown then class not found
     */

    /**
     *main starts the program
     */
    public static void main(String[] args) throws ParseException, CloneNotSupportedException, IOException, ClassNotFoundException {

        LinkedList<WorkEvent> workEventList = new LinkedList<WorkEvent>();
        LinkedList<PersonalEvent> personalEventList = new LinkedList<PersonalEvent>();
        LoadThread thread02 = new LoadThread(workEventList, personalEventList);
        thread02.start();
        MainFrame mainFrame = new MainFrame(workEventList, personalEventList);

    }
}
