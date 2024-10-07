package event;

import java.io.Serializable;
import java.util.Date;

/**
 * creates event
 */
public abstract class Event implements Cloneable, Serializable {
    protected static int numberOfEvents = 0;
    protected String title;
    protected String description;
    protected Date eventTime;
    protected String participants = "No participants included";
    private static Date today = new Date();
    protected Copy copy;


    public Event(String title, String description, Date eventTime){
        this.title = title;
        this.description = description;
        this.eventTime = eventTime;
        numberOfEvents++;
    }
    public Event(){
        this("Rest", "No activity", today);
    }


    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getEventTime(){
        return eventTime;
    }
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String  getParticipants(){
        return participants;
    }
    public void setParticipants (String participants) { this.participants = participants; }
    public static void setNumberOfEvents(int numberOfEvents){numberOfEvents = numberOfEvents;}
    public static int getNumberOfEvents(){return numberOfEvents;}


    public void changeParticipants (String participants){
        this.participants = participants;
    }
    public void deleteParticipants (){
        participants = "No participants included";
    }

    public void changeDescription(String description){
        this.description = description;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}