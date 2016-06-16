package com.gppmds.tra.temremdioa;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.controller.adapter.FilterSearchMedicine;
import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseObject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuário on 15/06/2016.
 */
public class CardListAdapterMedicineUnitTest {

    private CardListAdapterMedicine cardListAdapterMedicine;
    private List<Medicine> dataMedicine;
    private FilterSearchMedicine filter;
    private Medicine medicineTest1;
    private Medicine medicineTest2;
    private ViewHolderMedicine viewHolderMedicine;
    private Context context;
    private ViewGroup viewGroup;
    private CardView view;
    private TextView textView;

    @Before
    public void setup() {
        ParseObject.registerSubclass(Medicine.class);
        context = Mockito.mock(Context.class, Mockito.RETURNS_SMART_NULLS);
        viewHolderMedicine = Mockito.mock(ViewHolderMedicine.class, Mockito.RETURNS_SMART_NULLS);
        viewGroup = Mockito.mock(ViewGroup.class, Mockito.RETURNS_SMART_NULLS);
        context = Mockito.mock(Context.class, Mockito.RETURNS_SMART_NULLS);
        view = Mockito.mock(CardView.class, Mockito.RETURNS_SMART_NULLS);
        textView  = Mockito.mock(TextView.class, Mockito.RETURNS_SMART_NULLS);

        dataMedicine = new ArrayList<>();
        medicineTest1 = new Medicine();
        medicineTest1.setMedicineDescription("Test");
        medicineTest1.setMedicineAttentionLevel("Test");
        medicineTest1.setMedicineDosage("Test");
        medicineTest1.setMedicineSESCode("Test");
        medicineTest1.setMedicineUnit("Test");

        medicineTest2 = new Medicine();
        dataMedicine.add(medicineTest1);
        dataMedicine.add(medicineTest2);
        cardListAdapterMedicine = new CardListAdapterMedicine(context, dataMedicine);
    }

    @Test
    public void getFilter() {
        filter = cardListAdapterMedicine.getFilter();

        Assert.assertNotNull(filter);

        cardListAdapterMedicine.createFilter();
        filter = cardListAdapterMedicine.getFilter();

        Assert.assertNotNull(filter);
    }

    @Test
    public void getItemCountTest() {
        Assert.assertEquals(2, cardListAdapterMedicine.getItemCount());
    }

    @Test
    public void onBindViewHolderTest() {

        Mockito.when(viewHolderMedicine.getTextViewMedicineName()).thenReturn(textView);
        Mockito.when(viewHolderMedicine.getTextViewMedicineType()).thenReturn(textView);
        Mockito.when(viewHolderMedicine.getTextViewMedicineDosage()).thenReturn(textView);
        Mockito.when(viewHolderMedicine.getTextViewMedicineAttentionLevel()).thenReturn(textView);
        Mockito.when(viewHolderMedicine.getButtonSelectUbs()).thenReturn(Mockito.mock(Button.class));

        cardListAdapterMedicine.onBindViewHolder(viewHolderMedicine, 0);

        cardListAdapterMedicine.setShowButtonUBSs(false);

        cardListAdapterMedicine.onBindViewHolder(viewHolderMedicine, 0);

        Assert.assertNotNull(cardListAdapterMedicine);
    }
}
