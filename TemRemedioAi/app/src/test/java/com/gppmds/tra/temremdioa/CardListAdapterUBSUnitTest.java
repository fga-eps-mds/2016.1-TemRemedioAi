package com.gppmds.tra.temremdioa;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.controller.adapter.FilterSearchUBS;
import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseObject;
import com.tra.gppmds.temremdioa.R;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.asm.Type;
import org.mockito.internal.stubbing.answers.Returns;
import org.mockito.internal.stubbing.defaultanswers.ReturnsSmartNulls;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niets on 11/06/16.
 */
public class CardListAdapterUBSUnitTest {

    private CardListAdapterUBS cardListAdapterUBS;
    private List<UBS> dataUBS;
    private FilterSearchUBS filter;
    private UBS ubsTest1;
    private UBS ubsTest2;
    private ViewHolderUBS viewHolderUBS;
    private Context context;
    private ViewGroup viewGroup;
    private CardView view;
    private TextView textView;

    @Before
    public void CardListAdapterTest() {
        ParseObject.registerSubclass(UBS.class);
        context = Mockito.mock(Context.class, Mockito.RETURNS_SMART_NULLS);
        viewHolderUBS = Mockito.mock(ViewHolderUBS.class, Mockito.RETURNS_SMART_NULLS);
        viewGroup = Mockito.mock(ViewGroup.class, Mockito.RETURNS_SMART_NULLS);
        context = Mockito.mock(Context.class, Mockito.RETURNS_SMART_NULLS);
        view = Mockito.mock(CardView.class, Mockito.RETURNS_SMART_NULLS);
        textView  = Mockito.mock(TextView.class, Mockito.RETURNS_SMART_NULLS);

        dataUBS = new ArrayList<>();
        ubsTest1 = new UBS();
        ubsTest1.setUbsName("Test");
        ubsTest1.setUbsNeighborhood("Test");
        ubsTest1.setUbsCity("Test");
        ubsTest1.setUbsAttentionLevel("Test");

        ubsTest2 = new UBS();
        dataUBS.add(ubsTest1);
        dataUBS.add(ubsTest2);
        cardListAdapterUBS = new CardListAdapterUBS(context, dataUBS);
    }

    @Test
    public void getFilter() {
        filter = cardListAdapterUBS.getFilter();

        Assert.assertNotNull(filter);

        cardListAdapterUBS.createFilter();
        filter = cardListAdapterUBS.getFilter();

        Assert.assertNotNull(filter);
    }

    @Test
    public void getItemCountTest() {
        Assert.assertEquals(2, cardListAdapterUBS.getItemCount());
    }

    @Test
    public void onBindViewHolderTest() {

        Mockito.when(viewHolderUBS.getTextViewUbsName()).thenReturn(textView);
        Mockito.when(viewHolderUBS.getTextViewUbsNeighborhood()).thenReturn(textView);
        Mockito.when(viewHolderUBS.getTextViewUbsCity()).thenReturn(textView);
        Mockito.when(viewHolderUBS.getTextViewUbsAttentionLevel()).thenReturn(textView);
        Mockito.when(viewHolderUBS.getButtonSelectMedicine()).thenReturn(Mockito.mock(Button.class));

        cardListAdapterUBS.onBindViewHolder(viewHolderUBS, 0);

        cardListAdapterUBS.setShowButtonMedicines(false);

        cardListAdapterUBS.onBindViewHolder(viewHolderUBS, 0);

        Assert.assertNotNull(cardListAdapterUBS);
    }
}