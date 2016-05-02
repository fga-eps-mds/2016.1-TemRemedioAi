package com.tra.gppmds.temremdioa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.gppmds.tra.temremdioa.model.UBS;

import java.util.List;

/**
 * Created by carolina on 01/05/16.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder>{
    private List<String> dataUBS;
    private Context contextOpen;
//    private List<Remedio>;

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
            String selectItem = dataUBS.get(this.getAdapterPosition());

            Bundle args = new Bundle();
//            args.putSerializable("", selectItem);
            intent.putExtra("", 1);
            contextOpen.startActivity(intent);
        }
    }

    public CardListAdapter(Context context, List<String> dataUBS) {
        this.contextOpen = context;
        this.dataUBS = dataUBS;
    }

    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String rowData = this.dataUBS.get(position);
        holder.title.setText(rowData);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
