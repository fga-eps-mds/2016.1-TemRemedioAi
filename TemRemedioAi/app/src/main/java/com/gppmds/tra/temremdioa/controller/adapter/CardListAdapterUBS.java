package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.UbsMapsActivity;
import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 01/05/16.
 */
public class CardListAdapterUBS extends RecyclerView.Adapter<CardListAdapterUBS.ViewHolder> implements Filterable{
    private List<UBS> dataUBS;
    private List<UBS> filterDataUBS;
    private Context contextOpen;
    // FilterSearchs filter;

    @Override
    public Filter getFilter() {
//        if(filter == null) {
//            filter = new CustomFilter( filterDataRemedio,this );
//        }
//
//        return filter;
        return null;
    }

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
            UBS selectItem = dataUBS.get(this.getAdapterPosition());
//            intent.putExtra("UBS", selectItem);
            intent.putExtra("latitude", selectItem.getLatitude());
            intent.putExtra("longitude", selectItem.getLongitude());
            intent.putExtra("nomeUBS", selectItem.getNomEstab());
            intent.putExtra("descEnderecoUBS", selectItem.getDscEndereco());
            intent.putExtra("descBairroUBS", selectItem.getDscBairro());
            contextOpen.startActivity(intent);
        }
    }

    public CardListAdapterUBS(Context context, List<UBS> dataUBS) {
        this.contextOpen = context;
        this.dataUBS = dataUBS;
    }

    @Override
    public CardListAdapterUBS.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UBS rowData = this.dataUBS.get(position);
        holder.title.setText(rowData.getNomEstab());
    }

    @Override
    public int getItemCount() {
        return 100;
    }

}
