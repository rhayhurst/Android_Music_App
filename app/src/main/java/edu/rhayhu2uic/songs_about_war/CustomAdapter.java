package edu.rhayhu2uic.songs_about_war;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>
{
    private final Context context;
    private final String[] song_titles;
    private final String[] artists;

    public CustomAdapter(Context context, String[] v1, String[] v2)
    {
        super(context, -1,v1);
        this.context = context;
        this.song_titles = v1;
        this.artists = v2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listView = inflater.inflate(R.layout.list_main, parent, false);

        TextView song_textview = (TextView) listView.findViewById(R.id.song_title);
        song_textview.setText(song_titles[position]);

        if (0 == position%2) listView.setBackgroundResource(R.color.black);
        else listView.setBackgroundResource(R.color.black);

        TextView artistView = (TextView) listView.findViewById(R.id.artist_name);
        artistView.setText(artists[position]);

        ImageView pic = (ImageView) listView.findViewById(R.id.icon);

        switch (position)
        {
            case(0):
                pic.setImageResource(R.drawable.floyd);
                break;

            case(1):
                pic.setImageResource(R.drawable.battle);
                break;

            case(2):
                pic.setImageResource(R.drawable.pogues);
                break;

            case(3):
                pic.setImageResource(R.drawable.partisan);
                break;

            case(4):
                pic.setImageResource(R.drawable.prine);
                break;

            case(5):
                pic.setImageResource(R.drawable.copperhead);
                break;

            case(6):
                pic.setImageResource(R.drawable.brighteyes);
                break;

            case(7):
                pic.setImageResource(R.drawable.roland);
                break;

            case(8):
                pic.setImageResource(R.drawable.god);
                break;

            case(9):
                pic.setImageResource(R.drawable.pop);
                break;
        }

        return listView;
    }
}
