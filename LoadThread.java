package event;

import java.io.*;
import java.util.List;

/**
 * load thread
 */
public class LoadThread extends Thread{
    public List<WorkEvent> workEventList;
    public List<PersonalEvent> personalEventList;
    public LoadThread(List<WorkEvent> workEventList, List<PersonalEvent> personalEventList) {
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;
    }

    public void run()
    {
        try
        {
            FileInputStream inFile = new FileInputStream("out.dat");
            ObjectInputStream objIn = new ObjectInputStream(inFile);
            workEventList.clear();
            workEventList.addAll((List<WorkEvent>) objIn.readObject());
            personalEventList.clear();
            personalEventList.addAll((List<PersonalEvent>) objIn.readObject());
        }
        catch (RuntimeException exception) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
