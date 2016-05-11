package com.gppmds.tra.temremdioa.controller.adapter.holder;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.SelectUBSActivity;
import com.gppmds.tra.temremdioa.controller.UbsMapsActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

/**
 * Created by elmar on 10/05/16.
 */
public class ViewHolderUBS extends RecyclerView.ViewHolder{
    public TextView textViewNomeUBS;
    public TextView textViewBairroUBS;
    public TextView textViewCidadeUBS;
    public TextView textViewNivelAtencaoUBS;
    public RelativeLayout headerLayout;
    public RelativeLayout expandLayout;
    public ValueAnimator mAnimator;
    public Button buttonSelecionaRemedio;
    public Button buttonVisualizarDescricaoUBS;
    public ImageView imageViewArrow;

    public ViewHolderUBS(CardView card) {
        super(card);
        this.textViewNomeUBS = (TextView) card.findViewById(R.id.textViewNomeUBS);
        this.textViewBairroUBS = (TextView) card.findViewById(R.id.textViewBairroUBS);
        this.textViewCidadeUBS = (TextView) card.findViewById(R.id.textViewCidadeUBS);
        this.textViewNivelAtencaoUBS = (TextView) card.findViewById(R.id.textViewNivelAtencaoUBS);
        this.imageViewArrow = (ImageView) card.findViewById(R.id.imageViewArrow);
        this.buttonSelecionaRemedio = (Button) card.findViewById(R.id.buttonSelecionarRemedio);
        this.buttonVisualizarDescricaoUBS = (Button) card.findViewById(R.id.buttonVisualizarDescricaoUBS);
        this.expandLayout = (RelativeLayout) card.findViewById(R.id.expandable);
        this.headerLayout = (RelativeLayout) card.findViewById(R.id.header);

        this.expandLayout.setVisibility(View.GONE);

        this.expandLayout.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {

                    @Override
                    public boolean onPreDraw() {
                        expandLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                        expandLayout.setVisibility(View.GONE);

                        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        expandLayout.measure(widthSpec, heightSpec);

                        mAnimator = slideAnimator(0, expandLayout.getMeasuredHeight());
                        return true;
                    }
                });

        this.headerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOG", "onClickListener of headerLayout clicked");
                if (expandLayout.getVisibility() == View.GONE) {
                    Log.i("LOG", "Expand Click");
                    expand();
                } else {
                    Log.i("LOG", "Collapse Click");
                    collapse();
                }
            }
        });

        this.buttonSelecionaRemedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SelectUBSActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        this.buttonVisualizarDescricaoUBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UbsMapsActivity.class);
                UBS selectItem = CardListAdapterUBS.dataUBS.get(ViewHolderUBS.this.getAdapterPosition());
                intent.putExtra("latitude", selectItem.getLatitude());
                intent.putExtra("longitude", selectItem.getLongitude());
                intent.putExtra("nomeUBS", selectItem.getNomEstab());
                intent.putExtra("descEnderecoUBS", selectItem.getDscEndereco());
                intent.putExtra("descBairroUBS", selectItem.getDscBairro());
                v.getContext().startActivity(intent);
            }
        });
    }

    private void expand() {
        //set Visible
        Log.i("LOG", "Expand enter, View.VISIBLE");
        expandLayout.setVisibility(View.VISIBLE);
        mAnimator.start();
        imageViewArrow.setBackgroundResource(R.drawable.ic_keyboard_arrow_up);
    }

    private void collapse() {
        int finalHeight = expandLayout.getHeight();

        ValueAnimator mAnimator2 = slideAnimator(finalHeight, 0);
        mAnimator2.addListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animator) {
                Log.i("LOG", "collapse onAnimationEnd enter, View.GONE");
                expandLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        mAnimator2.start();
        imageViewArrow.setBackgroundResource(R.drawable.ic_keyboard_arrow_down);
    }

    private ValueAnimator slideAnimator(int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = expandLayout.getLayoutParams();
                layoutParams.height = value;
                expandLayout.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }
}
