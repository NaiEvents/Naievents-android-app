package com.example.felix_000.naievents_beta;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by festus on 5/19/15.
 */
class   RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

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

