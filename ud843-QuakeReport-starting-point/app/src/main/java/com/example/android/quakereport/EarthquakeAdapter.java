package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    String offsetPart,parts[],mainPart;
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);


        double magnitudeValue = currentEarthquake.getmMagnitude();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String magToDisplay = decimalFormat.format(magnitudeValue);

        TextView firstText = (TextView) listItemView.findViewById(R.id.magnitudeText);
        firstText.setText(magToDisplay);


        String text = currentEarthquake.getmPlace();
        if(text.contains("of")) {
             parts = text.split("of");
             offsetPart = parts[0] + "of";
             mainPart = parts[1];
        } else
        {
            offsetPart = getContext().getString(R.string.near_the);
            mainPart = parts[1];
        }
        TextView offsetText = (TextView) listItemView.findViewById(R.id.offsetText);
        offsetText.setText(offsetPart);
        TextView mainText = (TextView) listItemView.findViewById(R.id.mainText);
        mainText.setText(mainPart);

        long timeInMilliSeconds = currentEarthquake.getmDate();
        Date dateToDisplay = new Date(timeInMilliSeconds);

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy");
        String displayDate = dateFormat.format(dateToDisplay);
        TextView dateText = (TextView) listItemView.findViewById(R.id.dateText);
        dateText.setText(displayDate);


        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String displayTime = timeFormat.format(dateToDisplay);
        TextView timeText = (TextView) listItemView.findViewById(R.id.timeText);
        timeText.setText(displayTime);

        return listItemView;


    }
}
