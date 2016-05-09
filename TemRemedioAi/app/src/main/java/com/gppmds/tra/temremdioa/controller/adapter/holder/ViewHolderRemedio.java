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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.SelectUBSActivity;
import com.tra.gppmds.temremdioa.R;

/**
 * Created by elmar on 09/05/16.
 */
public class ViewHolderRemedio extends RecyclerView.ViewHolder {
    public TextView textViewNomeMedicamento;
    public TextView textViewTipoMedicamento;
    public TextView textViewQuantidadePorcao;
    public TextView textViewNivelAtMedicamento;
    public CardView cardViewRemedio;
    public RelativeLayout headerLayout;
    public RelativeLayout expandLayout;
    public ValueAnimator mAnimator;
    public Button buttonSelecionaUbs;

    public ViewHolderRemedio(CardView card) {
        super(card);
        this.textViewNomeMedicamento = (TextView) card.findViewById(R.id.textViewNomeMedicamento);
        this.textViewTipoMedicamento = (TextView) card.findViewById(R.id.textViewTipoMedicamento);
        this.textViewQuantidadePorcao = (TextView) card.findViewById(R.id.textViewQuantidadeMedicamento);
        this.textViewNivelAtMedicamento = (TextView) card.findViewById(R.id.textViewNivelAtMedicamento);
        this.cardViewRemedio = card;
        this.expandLayout = (RelativeLayout) card.findViewById(R.id.expandable);
        this.expandLayout.setVisibility(View.GONE);
        this.headerLayout = (RelativeLayout) card.findViewById(R.id.header);
        this.buttonSelecionaUbs = (Button) card.findViewById(R.id.buttonSelecionarUbs);

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
                if (expandLayout.getVisibility() == View.GONE) {
                    Log.i("log", "expand click");
                    expand();
                } else {
                    Log.i("log", "collapse click");
                    collapse();
                }
            }
        });

        this.buttonSelecionaUbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SelectUBSActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    private void expand() {
        //set Visible
        expandLayout.setVisibility(View.VISIBLE);
        mAnimator.start();
    }

    private void collapse() {
        int finalHeight = expandLayout.getHeight();

        mAnimator = slideAnimator(finalHeight, 0);
        mAnimator.addListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animator) {
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
        mAnimator.start();
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