package reverieworks.eventzone;

/**
 * Created by user on 3/20/2016.
 */
public class EventListData {

    private String eventName;
    private String date;
    private int iconID;
    private String eventDescription;
    private double getLocation_longitude;
    private double getLocation_latitude;
    private int getLocationImageIcon;

    public EventListData(String date, String eventDescription,  String eventName, double getLocation_latitude,double getLocation_longitude, int iconID)
    {
        super();
        this.eventDescription = eventDescription;
        this.date = date;
        this.eventName = eventName;
        this.getLocation_latitude = getLocation_latitude;
        this.getLocation_longitude = getLocation_longitude;
        this.iconID = iconID;
    }

    public String getEventDescription()
    {
        return eventDescription;
    }

    public double getGetLocation_latitude() {
        return getLocation_latitude;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public double getGetLocation_longitude() {
        return getLocation_longitude;
    }

    public int getIconID() {
        return iconID;
    }


    public int getGetLocationImageIcon() {
        return getLocationImageIcon;
    }
}
