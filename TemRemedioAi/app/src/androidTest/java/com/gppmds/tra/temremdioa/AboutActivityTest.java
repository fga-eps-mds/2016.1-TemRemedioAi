package com.gppmds.tra.temremdioa;

import org.junit.Before;
import android.media.audiofx.Virtualizer;
import android.content.Context;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.content.res.Resources;

import com.gppmds.tra.temremdioa.controller.AboutActivity;
import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.tra.gppmds.temremdioa.R;

import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

public class AboutActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public AboutActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
    }

    public void testIfInfoIsDisplayed() {
        openActionBarOverflowOrOptionsMenu(getActivity());
        onView(withText("Informações")).perform(click());
        onData(hasToString(containsString("O aplicativo Tem Remédio Aí? tem como objetivo " +
                                        " facilitar o acesso à informação da disponibilidade " +
                                        " de medicamentos gratuitamente distribuídos em Unidades " +
                                        " Básicas de Saúde, Hospitais e Farmácias de Alto Custo " +
                                        " da Secretaria de Saúde do Distrito Federal.")));
    }

}





