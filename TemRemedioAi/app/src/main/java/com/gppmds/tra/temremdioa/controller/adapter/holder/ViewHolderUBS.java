package com.gppmds.tra.temremdioa.controller.adapter.holder;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.UbsMapsActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

import org.w3c.dom.Text;

/**
 * Created by elmar on 10/05/16.
 */
public class ViewHolderUBS extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView title;

    public ViewHolderUBS(CardView card) {
        super(card);
        this.title = (TextView) card.findViewById(R.id.title);
        card.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(CardListAdapterUBS.contextOpen, UbsMapsActivity.class);
        UBS selectItem = CardListAdapterUBS.dataUBS.get(this.getAdapterPosition());
//            intent.putExtra("UBS", selectItem);
        intent.putExtra("latitude", selectItem.getLatitude());
        intent.putExtra("longitude", selectItem.getLongitude());
        intent.putExtra("nomeUBS", selectItem.getNomEstab());
        intent.putExtra("descEnderecoUBS", selectItem.getDscEndereco());
        intent.putExtra("descBairroUBS", selectItem.getDscBairro());
        intent.putExtra("descCidadeUBS", selectItem.getDscCidade());
        CardListAdapterUBS.contextOpen.startActivity(intent);
    }
}

;