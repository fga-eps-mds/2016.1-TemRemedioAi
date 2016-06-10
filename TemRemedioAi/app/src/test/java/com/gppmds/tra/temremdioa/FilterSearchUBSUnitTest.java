package com.gppmds.tra.temremdioa;

import android.widget.Filter;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.controller.adapter.FilterSearchUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseObject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niets on 10/06/16.
 */
public class FilterSearchUBSUnitTest extends Filter {

    private FilterSearchUBS filterSearchUBS;
    private CardListAdapterUBS adapter;
    private List<UBS> filterList;
    private CharSequence charSequence;
    private UBS ubsTest1;
    private UBS ubsTest2;
    private UBS ubsTest3;
    private FilterResults resultsSuccess;
    private FilterResults resultsFail;

    @Before
    public void setUp() {
        adapter = Mockito.mock(CardListAdapterUBS.class);
        filterList = new ArrayList<>();
        ParseObject.registerSubclass(UBS.class);
        ubsTest1 = new UBS();
        ubsTest2 = new UBS();
        ubsTest3 = new UBS();
        resultsSuccess = new FilterResults();
        resultsFail = new FilterResults();
    }

    @Test
    public void FilterSearchUBSTest() {
        filterSearchUBS = new FilterSearchUBS(filterList, adapter);

        Assert.assertEquals(filterSearchUBS.getClass(), FilterSearchUBS.class);
    }

    @Test
    public void performFilteringTest() {
        charSequence = "Success";
        ubsTest1.setUbsName("Fail");
        ubsTest2.setUbsName("Success");
        ubsTest3.setUbsName("Fail");

        filterList.add(ubsTest1);
        filterList.add(ubsTest2);
        filterList.add(ubsTest3);

        filterSearchUBS = new FilterSearchUBS(filterList, adapter);

        resultsSuccess = filterSearchUBS.performFiltering(charSequence);
        resultsFail = filterSearchUBS.performFiltering("");

        Assert.assertNotSame(resultsSuccess, resultsFail);
    }

    @Test
    public void publishResultsTest(){

        charSequence = "Success";
        ubsTest1.setUbsName("Fail");
        ubsTest2.setUbsName("Success");
        ubsTest3.setUbsName("Fail");

        filterList.add(ubsTest1);
        filterList.add(ubsTest2);
        filterList.add(ubsTest3);

        filterSearchUBS = new FilterSearchUBS(filterList, adapter);

        resultsSuccess = filterSearchUBS.performFiltering(charSequence);

        filterSearchUBS.publishResults(Mockito.mock(CharSequence.class), Mockito.mock(FilterResults.class));
    }



    /*
    -------- Ignore everything bellow this line --------
     */

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        return null;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

    }
}