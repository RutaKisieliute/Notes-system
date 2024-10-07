package event;


import java.util.Date;

/**
 * creates workEvent
 */
public class WorkEvent extends Event{
    public Copy copy;
    private String address = "No address added";

    public WorkEvent(String title, String description, Date eventTime, Copy copy){
        super(title, description, eventTime);
        this.copy = copy;
    }

    public WorkEvent(String title, String description, Date eventTime){
        super(title, description, eventTime);
    }
    public WorkEvent(){
        super();
    }
    public void delay()
    {
        eventTime.setDate(eventTime.getDate()+1);
    }
    public void delay(int days)
    {
            eventTime.setDate(eventTime.getDate() + days);
    }
    public void addAddress(String address){
        this.address = address;
    }
    public void deleteAddress (){
        address = "No address added";
    }


    public String toString(){
        return "\n Title: " + title + "\n Description: " + description + "\n Event time: " + eventTime +"\n Address: " + address + "\n Participants: "+ participants + "\n";
    }

    public Object clone() throws CloneNotSupportedException {
        try{
            WorkEvent workEvent = (WorkEvent) super.clone();
           // workEvent.copy = (Copy) copy.clone();
            return workEvent;
            //return super.clone();
        }
        catch (CloneNotSupportedException exc) {
            // Should never happen
            throw new Error ("Error" +exc.getMessage());
        }
    }

    public String getAddress(){ return address;}
    public void setAddress(String address) {
        this.address = address;
    }
}
