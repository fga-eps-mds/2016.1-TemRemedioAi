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

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.gppmds.tra.temremdioa.controller.Inform;
import com.gppmds.tra.temremdioa.controller.SelectUBSActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.tra.gppmds.temremdioa.R;
import com.gppmds.tra.temremdioa.model.Notification;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;

public class ViewHolderMedicine extends RecyclerView.ViewHolder {
    private TextView textViewMedicineName;
    private TextView textViewMedicineType;
    private TextView textViewMedicineDosage;
    private TextView textViewMedicineAttentionLevel;
    private RelativeLayout headerLayout;
    private RelativeLayout expandLayout;
    private ValueAnimator mAnimator;
    private Button buttonSelectUbs;
    public Button buttonMedicineInform;
    private ImageView imageViewArrow;
    public String ubsSelectedName;
    private PieChart pieChart;


    public ViewHolderMedicine(CardView card) {
        super(card);
        this.textViewMedicineName = (TextView) card.findViewById(R.id.textViewMedicineName);
        this.textViewMedicineType = (TextView) card.findViewById(R.id.textViewMedicineType);
        this.textViewMedicineDosage = (TextView) card.findViewById(R.id.textViewMedicineDosage);
        this.textViewMedicineAttentionLevel = (TextView) card.findViewById(R.id.textViewMedicineAttetionLevel);
        this.imageViewArrow = (ImageView) card.findViewById(R.id.imageViewArrow);
        this.buttonSelectUbs = (Button) card.findViewById(R.id.buttonSelectUbs);
        this.buttonMedicineInform = (Button) card.findViewById(R.id.buttonInformRemedio);
        this.expandLayout = (RelativeLayout) card.findViewById(R.id.expandable);
        this.headerLayout = (RelativeLayout) card.findViewById(R.id.header);
        this.pieChart = (PieChart) card.findViewById(R.id.pie_chart_medicine);

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
                    Medicine selectItem = CardListAdapterMedicine.dataMedicine.get(ViewHolderMedicine.this.getAdapterPosition());
                    setInformationOfChart(selectItem);
                    expand();
                } else {
                    Log.i("LOG", "Collapse Click");
                    collapse();
                }
            }
        });

        this.buttonSelectUbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SelectUBSActivity.class);

                Medicine selectItem = CardListAdapterMedicine.dataMedicine.get(ViewHolderMedicine.this.getAdapterPosition());
                intent.putExtra("nomeRemedio", selectItem.getMedicineDescription());
                intent.putExtra("nivelAtencao", selectItem.getMedicineAttentionLevel());
                intent.putExtra("medicineDos", selectItem.getMedicineDosage());

                v.getContext().startActivity(intent);
            }
        });

        this.buttonMedicineInform.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Inform.class);
                Medicine selectedItem = CardListAdapterMedicine.dataMedicine.get(ViewHolderMedicine.this.getAdapterPosition());
                intent.putExtra("MedicineName", selectedItem.getMedicineDescription());
                intent.putExtra("MedicineDos", selectedItem.getMedicineDosage());
                intent.putExtra("UBSName",ubsSelectedName);

                view.getContext().startActivity(intent);
            }
        });
    }

    private void setInformationOfChart(Medicine medicine) {
        pieChart.setDescription("");
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleRadius(7);
        pieChart.setTransparentCircleRadius(10);
        pieChart.setDrawSliceText(true);
        pieChart.setRotationAngle(0);
        pieChart.setRotationEnabled(true);
        pieChart.setData(getDataPie(medicine));

    }

    public PieData getDataPie(Medicine medicine) {
        PieData pieData = null;

        Integer countNotificationAvailable = 0;
        Integer countNotificationNotAvailable = 0;

        ParseQuery<Notification> queryNotificationAvailable = Notification.getQuery();
        queryNotificationAvailable.fromLocalDatastore();
        queryNotificationAvailable.whereEqualTo(Notification.getTitleMedicineName(), medicine.getMedicineDescription());
        queryNotificationAvailable.whereEqualTo(Notification.getTitleMedicineDosage(), medicine.getMedicineDosage());
        queryNotificationAvailable.whereEqualTo(Notification.getTitleAvailable(), true);
        try {
            countNotificationAvailable = queryNotificationAvailable.count();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ParseQuery<Notification> queryNotificationNotAvailable = Notification.getQuery();
        queryNotificationNotAvailable.fromLocalDatastore();
        queryNotificationNotAvailable.whereEqualTo(Notification.getTitleMedicineName(), medicine.getMedicineDescription());
        queryNotificationNotAvailable.whereEqualTo(Notification.getTitleMedicineDosage(), medicine.getMedicineDosage());
        queryNotificationNotAvailable.whereEqualTo(Notification.getTitleAvailable(), false);
        try {
            countNotificationNotAvailable = queryNotificationNotAvailable.count();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<Entry> valuesAvailable = new ArrayList<Entry>();
        ArrayList<String> valuesLegend = new ArrayList<String>();

        valuesLegend.add("Sim");
        valuesLegend.add("Não");

        valuesAvailable.add(new Entry((float) countNotificationAvailable, 0));
        valuesAvailable.add(new Entry((float) countNotificationNotAvailable, 1));

        PieDataSet pieDataSet = new PieDataSet(valuesAvailable, "");
        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieDataSet.setSliceSpace(2f);

        pieData = new PieData(valuesLegend, pieDataSet);

        return pieData;
    }

    private void expand() {
        /* set Visible */
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
                /* Method declared empty because the override is mandatory */
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                /* Method declared empty because the override is mandatory */
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                /* Method declared empty because the override is mandatory */
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
                /* Update Height */
                int value = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = expandLayout.getLayoutParams();
                layoutParams.height = value;
                expandLayout.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }

    public TextView getTextViewMedicineName(){
        return textViewMedicineName;
    }

    public TextView getTextViewMedicineType() {
        return textViewMedicineType;
    }

    public TextView getTextViewMedicineDosage() {
        return textViewMedicineDosage;
    }

    public TextView getTextViewMedicineAttentionLevel() {
        return textViewMedicineAttentionLevel;
    }

    public Button getButtonSelectUbs() {
        return buttonSelectUbs;
    }
}