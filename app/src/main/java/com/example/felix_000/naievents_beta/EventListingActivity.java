package com.example.felix_000.naievents_beta;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class EventListingActivity extends ActionBarActivity {
    private RecyclerView rv;
    private ArrayList<EventsFormAtt> eventsFormAtts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_listing);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        initializeData();
        initializeAdapter();
    }

    private void initializeAdapter() {
        RVAdapter adapter;
        adapter = new RVAdapter(eventsFormAtts);
        rv.setAdapter(adapter);
    }


    private void initializeData() {
        eventsFormAtts = new ArrayList<>();
        eventsFormAtts.add(new EventsFormAtt("Ruby Conference", "2/3/2015 at 2pm", " venue:Nairobi garage", R.drawable.img1));
        eventsFormAtts.add(new EventsFormAtt("enterprenuors conf", "4/5/2015 from 9 am","venue:ihub", R.drawable.img2));
        eventsFormAtts.add(new EventsFormAtt("groove awards","2/7/2015 from 6 pm","venue: kicc",R.drawable.img4));
        eventsFormAtts.add(new EventsFormAtt("Ruby Conference", "2/3/2015 at 2pm", " venue:Nairobi garage", R.drawable.img3));
        eventsFormAtts.add(new EventsFormAtt("enterprenuors conf", "4/5/2015 from 9 am","venue:ihub", R.drawable.img5));



    }

    private class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{


            List<EventsFormAtt> eventsFormAtts;

            public class PersonViewHolder extends RecyclerView.ViewHolder {
                CardView card;
                TextView title;
                TextView date;
                TextView location;
                ImageView imageView;

                PersonViewHolder(View itemView) {
                    super(itemView);
                    card = (CardView) itemView.findViewById(R.id.card);
                    title = (TextView) itemView.findViewById(R.id.title);
                    date = (TextView) itemView.findViewById(R.id.date);
                    location = (TextView) itemView.findViewById(R.id.location);
                    imageView = (ImageView) itemView.findViewById(R.id.imageView);
                }
            }

            RVAdapter(ArrayList<EventsFormAtt> eventsFormAtts) {
                this.eventsFormAtts = eventsFormAtts;
            }

            @Override
            public void onAttachedToRecyclerView(RecyclerView recyclerView) {
                super.onAttachedToRecyclerView(recyclerView);
            }

            @Override
            public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eventscard, viewGroup, false);
                PersonViewHolder pvh = new PersonViewHolder(v);
                return pvh;   }

            @Override
            public void onBindViewHolder(RVAdapter.PersonViewHolder personViewHolder, int i) {
                Log.v("value of", eventsFormAtts.get(i).title);
                personViewHolder.title.setText(eventsFormAtts.get(i).title);
                personViewHolder.date.setText(eventsFormAtts.get(i).date);
                personViewHolder.location.setText(eventsFormAtts.get(i).location);
                personViewHolder.imageView.setImageResource(eventsFormAtts.get(i).imageid);
            }

            @Override
            public int getItemCount() {
                return 0;
            }
        }

    }






