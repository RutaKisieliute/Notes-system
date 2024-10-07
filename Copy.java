package event;

/**
 * creates copy
 */
public class Copy implements Cloneable{
    public String description2;
    public Copy(String description2){
        this.description2 = description2;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
