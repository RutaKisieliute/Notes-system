package event;

import java.util.Date;

/**
 * creates events according to factory
 */
public class EventFactory {
    public Event getEvent(String type, String title, String description, Date eventTime)
    {
        if(type.equalsIgnoreCase("WorkEvent"))
        {
            return new WorkEvent(title, description, eventTime);
        } else if (type.equalsIgnoreCase("PersonalEvent"))
        {
            return new PersonalEvent(title, description, eventTime);
        }
        else
        {
            return null;
        }
    }
}
