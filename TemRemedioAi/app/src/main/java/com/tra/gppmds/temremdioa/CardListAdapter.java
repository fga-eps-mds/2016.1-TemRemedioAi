package com.tra.gppmds.temremdioa;

import android.support.v4.util.CircularArray;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.gppmds.tra.temremdioa.model.UBS;

import java.util.List;

/**
 * Created by carolina on 01/05/16.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder>{
    private List<UBS>;
    private List<Remedio>;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;

        public ViewHolder(CardView card) {
            super(card);
            this.title = (TextView) card.findViewById(R.id.title);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            
        }
    }
}
