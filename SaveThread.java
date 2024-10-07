package event;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * saves thread
 */

public class SaveThread extends Thread{
    public List<WorkEvent> workEventList;
    public List<PersonalEvent> personalEventList;
    public SaveThread(List<WorkEvent> workEventList, List<PersonalEvent> personalEventList ) {
        this.workEventList = workEventList;
        this.personalEventList = personalEventList;
    }

    public void run()
    {
        try
        {
            FileOutputStream outFile = new FileOutputStream("out.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            objOut.writeObject(workEventList);
            objOut.writeObject(personalEventList);
        }
        catch (RuntimeException exception)
        {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
