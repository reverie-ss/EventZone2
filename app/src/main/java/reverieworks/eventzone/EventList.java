package reverieworks.eventzone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

public class EventList extends AppCompatActivity {

    String message, superdata;
    private List<EventListData> myEvents = new ArrayList<EventListData>();
    private List<EventListData> userInfoList;
    String eventdescription[]={"dolor amet pancetta prosciutto ball tip tri-tip tail salami. Tenderloin tongue ham leberkas. Filet mignon boudin doner kielbasa turducken flank ground round ham porchetta brisket t-bone alcatra venison jowl pastrami. Jerky prosciutto drumstick, ham hock beef hamburger brisket fatba","ains most of the observed physical phenomenon like motion of particles, rigid bodies, fluid dynamics etc under the influence of appropriate forces and leads to conclusion that there is no more development at conceptual level.\n" +
            "\uF0D8\tBut some new phenomenon observed during the last decade of 19th century which are not explained by classical physics. Thus to explain their phenomena a new revolutionary concept was born which is known as Quantum physics developed by many outstanding physicists such as Planck, Einstein, Bohr, De Broglie, Heisenberg, Schrodinger, Born, Dirac and others.\n" +
            "\uF0D8\tThe quantum idea was 1st introduced by Max Planck in 1900 to explain the observed energy distribut","Photoelectric Effect.\n" +
            "\uF0D8\tNeils Bohr used a similar quantum concept to formulate a model for H- atom and explain the observed spectra successfully. \n" +
            "\uF0D8\tThe concept of dual nature of radiation was extended to Louis De Broglie who suggested that particles should have wave nature under certain circumstances. Thus the wave particle duality is regarded as basic ingredient \n","\uF0D8\tThe relativistic quantum mechanics was formulated by P.A.M. Dirac to incorporate the effect of special theory of relativity in quantum mechanics.","quantum field theory which successfully describes the interaction of radiation with matter and describes most of the phenomena in Atomic physics, nuclear physics, Particle physics, Solid state physics and Astrophysics.","","",""};

    Firebase firebase_event,firebase, firebase_latitude, firebase_longitude, firebase_description, firebase_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        Firebase.setAndroidContext(this);


        populateEventList();
        displayEventList();
        registerClickCallBack();


    }

    private void displayEventList() {


        ArrayAdapter<EventListData> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.upcomingEvents_ID);
        list.setAdapter(adapter);

    }


    private void populateEventList() {

      myEvents.add(new EventListData("15", eventdescription[0], superdata, 21.4976078, 83.9040135, R.drawable.chess_imagesmall));
        myEvents.add(new EventListData("17", eventdescription[1], "Death Race",21.5976078,83.9040135, R.drawable.death_race_imagesmall));
        myEvents.add(new EventListData("18", eventdescription[2], "V-Roadies", 21.4974078,83.8040135, R.drawable.v_roadies_imagesmall));
        myEvents.add(new EventListData("19", eventdescription[3], "Line In", 21.4976078,83.9050135, R.drawable.line_in_imagesmall));
        myEvents.add(new EventListData("20", eventdescription[4], "Treasure Hunt", 21.4977078, 83.9040135, R.drawable.treasure_hunt_imagesmall));
    }

    private void populateFriendsListView() {
        // Build the adapter
        ArrayAdapter<EventListData> adapter = new MyListAdapter();

        // Configure the list view
        ListView listView = (ListView) findViewById(R.id.upcomingEvents_ID);
        listView.setAdapter(adapter);

        registerClickCallBack();

    }
    private void registerClickCallBack() {


        ListView list = (ListView) findViewById(R.id.upcomingEvents_ID);
        if (list != null) {
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    EventListData clickedEvent = myEvents.get(position);
                    String message = "The location is: latitude- " + clickedEvent.getGetLocation_latitude() + " and longitude-  " + clickedEvent.getGetLocation_longitude();

                    Intent intent = new Intent(EventList.this,EventLocation.class);
                    intent.putExtra("eventDescription",clickedEvent.getEventDescription());
                    intent.putExtra("latitude_key", clickedEvent.getGetLocation_latitude());
                    intent.putExtra("longitude_key", clickedEvent.getGetLocation_longitude());

                    startActivity(intent);

                    Toast.makeText(EventList.this, message, Toast.LENGTH_LONG).show();


                }
            });
        }
    }
    private class MyListAdapter extends ArrayAdapter<EventListData> {


        public MyListAdapter() {
            super(EventList.this,R.layout.list_items_prototype,myEvents);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TO-DO hey it's working
            View view = convertView;

            if(view == null)
                view = getLayoutInflater().inflate(R.layout.list_items_prototype,parent,false);

            EventListData currentEvent = myEvents.get(position);

            ImageView imageview = (ImageView) view.findViewById(R.id.eventIcon_ID);
            imageview.setImageResource(currentEvent.getIconID());

            TextView textview = (TextView) view.findViewById(R.id.eventName_ID);
            textview.setText(currentEvent.getEventName());

            TextView textview_date = (TextView) view.findViewById(R.id.eventDate_ID);
            textview_date.setText(currentEvent.getDate());


            ImageView imageview_location = (ImageView) view.findViewById(R.id.mapImage_ID);
            imageview_location.setImageResource(R.drawable.location_image_icon);


            return view;
            // return super.getView(position, convertView, parent);
        }


    }


}
