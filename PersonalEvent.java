package event;

import java.util.Date;

/**
 * creates personalEvent
 */

public class PersonalEvent extends Event{

    public PersonalEvent(String title, String description, Date eventTime){
        super(title, description, eventTime);
    }
    public PersonalEvent(){
        super();
    }


    public String toString(){
        return "\n Title: " + title + "\n Description: " + description + "\n Event time: " + eventTime + "\n Participants: "+ participants + "\n";
    }

    public Object clone() throws CloneNotSupportedException {
        /*try{
            Event event = (Event) super.clone();
            return event;
        }
        catch (CloneNotSupportedException exc) {
            // Should never happen
            throw new Error ("Error" +exc.getMessage());
        }*/
        return super.clone();
    }
}
