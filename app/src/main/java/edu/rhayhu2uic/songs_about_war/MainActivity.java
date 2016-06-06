/**
 * Bob Hayhurst
 *
 * 10 Songs with a theme
 */

package edu.rhayhu2uic.songs_about_war;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    String[] song_titles;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);

        String[] titles = new String[]
        {
            "WWII: When the Tigers Broke Free",
            "Revolutionary War: Battle of New Orleans",
            "WWI: And the Band Played Waltzing Matilda",
            "WWII: The Partisan",
            "Vietnam: Sam Stone",
            "WWII/Vietnam: Johnny Come Lately",
            "Invasion of Iraq: Landlocked Blues",
            "Nigerian Civil War: Roland the (Headless) Thompson Gunner",
            "With God On Our Side",
            "Party in the USA"
        };
        this.song_titles = titles;

        String[] artists = new String[]
        {
            "Pink Floyd",
            "Johnny Horton",
            "The Pogues",
            "Leonard Cohen",
            "John Prine",
            "Steve Earle",
            "Bright Eyes",
            "Warren Zevon",
            "Bob Dylan",
            "Miley Cyrus"
        };

        CustomAdapter adapter = new CustomAdapter(this, song_titles, artists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                Resources res = getResources();
                String[] song = res.getStringArray(R.array.song_URL);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(song[position]));
                startActivity(intent);
            }
        });

        registerForContextMenu(listView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }




    //
    // next, let's create the long click
    //
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

        if (song_titles[info.position].equals("WWII: When the Tigers Broke Free"))
        {
            menu.setHeaderTitle("When the Tigers Broke Free:");
        }
        else if (song_titles[info.position].equals("Revolutionary War: Battle of New Orleans"))
        {
            menu.setHeaderTitle("Battle of New Orleans:");
        }
        else if (song_titles[info.position].equals("WWI: And the Band Played Waltzing Matilda"))
        {
            menu.setHeaderTitle("And the Band Played Waltzing Matilda:");
        }
        else if (song_titles[info.position].equals("WWII: The Partisan"))
        {
            menu.setHeaderTitle("The Partisan:");
        }
        else if (song_titles[info.position].equals("Vietnam: Sam Stone"))
        {
            menu.setHeaderTitle("Sam Stone:");
        }
        else if (song_titles[info.position].equals("WWII/Vietnam: Johnny Come Lately"))
        {
            menu.setHeaderTitle("Johnny Come Lately:");
        }
        else if (song_titles[info.position].equals("Invasion of Iraq: Landlocked Blues"))
        {
            menu.setHeaderTitle("Landlocked Blues:");
        }
        else if (song_titles[info.position].equals("Nigerian Civil War: Roland the (Headless) Thompson Gunner"))
        {
            menu.setHeaderTitle("Roland the (Headless) Thompson Gunner;");
        }
        else if (song_titles[info.position].equals("With God On Our Side"))
        {
            menu.setHeaderTitle("With God on Our Side");
        }
        else if (song_titles[info.position].equals("Party in the USA"))
        {
            menu.setHeaderTitle("PARTY TIME!");
        }

       // menu.setHeaderTitle("Your Choices for '" + song_titles[info.position] + "' Are:");
        menu.add(0, v.getId(), 0, "song");
        menu.add(0, v.getId(), 0, "lyrics");
        menu.add(0, v.getId(), 0, "song wiki");
        menu.add(0, v.getId(), 0, "artist wiki");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if      (item.getTitle().equals("song"))   goToSongURL(info);
        else if (item.getTitle().equals("lyrics")) goToLyricsURL(info);
        else if (item.getTitle().equals("song wiki"))   goToSongWikiURL(info);
        else if (item.getTitle().equals("artist wiki"))   goToArtistWiki(info);
        return true;
    }

    private void goToArtistWiki(AdapterView.AdapterContextMenuInfo info)
    {
        Resources res = getResources();
        String[] song = res.getStringArray(R.array.artist_wiki);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(song[info.position]));
        startActivity(intent);
    }

    private void goToSongWikiURL(AdapterView.AdapterContextMenuInfo info)
    {
        Resources res = getResources();
        String[] song = res.getStringArray(R.array.song_wiki);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(song[info.position]));
        startActivity(intent);
    }

    private void goToLyricsURL(AdapterView.AdapterContextMenuInfo info)
    {
        Resources res = getResources();
        String[] song = res.getStringArray(R.array.lyric_URL);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(song[info.position]));
        startActivity(intent);
    }

    private void goToSongURL(AdapterView.AdapterContextMenuInfo info)
    {
        Resources res = getResources();
        String[] song = res.getStringArray(R.array.song_URL);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(song[info.position]));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
