package com.gppmds.tra.temremdioa;

import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;

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





