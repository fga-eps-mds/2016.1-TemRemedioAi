package com.gppmds.tra.temremdioa;

import android.widget.Filter;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.controller.adapter.FilterSearchMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseObject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuário on 12/06/2016.
 */
public class FilterSearchMedicineTest extends Filter {

    private FilterSearchMedicine filterSearchMedicine;
    private CardListAdapterMedicine adapter;
    private List<Medicine> filterList;
    private CharSequence charSequence;
    private Medicine medicineTest1;
    private Medicine medicineTest2;
    private Medicine medicineTest3;
    private FilterResults resultsSuccess;
    private FilterResults resultsFail;

    @Before
    public void setUp() {
        adapter = Mockito.mock(CardListAdapterMedicine.class);
        filterList = new ArrayList<>();
        ParseObject.registerSubclass(Medicine.class);
        medicineTest1 = new Medicine();
        medicineTest2 = new Medicine();
        medicineTest3 = new Medicine();
        resultsSuccess = new FilterResults();
        resultsFail = new FilterResults();
    }

    @Test
    public void FilterSearchUBSTest() {
        filterSearchMedicine = new FilterSearchMedicine(filterList, adapter);

        Assert.assertEquals(filterSearchMedicine.getClass(), FilterSearchMedicine.class);
    }

    @Test
    public void performFilteringTest() {
        charSequence = "Success";
        medicineTest1.setMedicineDescription("Fail");
        medicineTest2.setMedicineDescription("Success");
        medicineTest3.setMedicineDescription("Fail");

        filterList.add(medicineTest1);
        filterList.add(medicineTest2);
        filterList.add(medicineTest3);

        filterSearchMedicine = new FilterSearchMedicine(filterList, adapter);

        resultsSuccess = filterSearchMedicine.performFiltering(charSequence);
        resultsFail = filterSearchMedicine.performFiltering("");

        Assert.assertNotSame(resultsSuccess, resultsFail);
    }

    @Test
    public void publishResultsTest(){

        charSequence = "Success";
        medicineTest1.setMedicineDescription("Fail");
        medicineTest2.setMedicineDescription("Success");
        medicineTest3.setMedicineDescription("Fail");

        filterList.add(medicineTest1);
        filterList.add(medicineTest2);
        filterList.add(medicineTest3);

        filterSearchMedicine = new FilterSearchMedicine(filterList, adapter);

        resultsSuccess = filterSearchMedicine.performFiltering(charSequence);

        filterSearchMedicine.publishResults(Mockito.mock(CharSequence.class), Mockito.mock(FilterResults.class));
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
