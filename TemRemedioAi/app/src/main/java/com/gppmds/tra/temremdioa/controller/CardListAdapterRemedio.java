package com.gppmds.tra.temremdioa.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 04/05/16.
 */
public class CardListAdapterRemedio extends RecyclerView.Adapter<CardListAdapterRemedio.ViewHolder>{
    private List<Remedio> dataRemedio;
    private Context contextOpen;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;

        public ViewHolder(CardView card) {
            super(card);
            this.title = (TextView) card.findViewById(R.id.title);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(contextOpen, UbsMapsActivity.class);
            Remedio selectItem = dataRemedio.get(this.getAdapterPosition());

            contextOpen.startActivity(intent);
        }
    }

    public CardListAdapterRemedio(Context context, List<Remedio> dataRemedio) {
        this.contextOpen = context;
        this.dataRemedio = dataRemedio;
    }

    @Override
    public CardListAdapterRemedio.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Remedio rowData = this.dataRemedio.get(position);
        holder.title.setText(rowData.getMedDes());
    }

    @Override
    public int getItemCount() {
        return 30;
    }

}