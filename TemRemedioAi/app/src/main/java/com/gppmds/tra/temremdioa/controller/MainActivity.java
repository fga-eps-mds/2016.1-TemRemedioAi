package com.gppmds.tra.temremdioa.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.gppmds.tra.temremdioa.controller.adapter.TabsAdapter;
import com.gppmds.tra.temremdioa.controller.fragment.MedicineFragment;
import com.gppmds.tra.temremdioa.controller.fragment.UBSFragment;
import com.parse.ParseUser;
import com.tra.gppmds.temremdioa.R;

import static com.facebook.AccessToken.getCurrentAccessToken;

public class MainActivity extends AppCompatActivity{

    public SearchView searchView;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.activity_sun_enter, R.anim.activity_dad_exit);

        TabsAdapter tabAdapter = new TabsAdapter(getSupportFragmentManager());
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(tabAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        client = createClient();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present */
        getMenuInflater().inflate(R.menu.menu_main, menu);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                UBSFragment.getUbsAdapter().getFilter().filter( query );
                MedicineFragment.getMedicineAdapter().getFilter().filter(query);
                return false;
            }
        });

        return true;
    }



    public DialogInterface.OnClickListener logout() {
        return new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                ParseUser.logOut();
                Toast.makeText(getApplicationContext(), "Deslogado com sucesso!", Toast.LENGTH_SHORT).show();


            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                 ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    // do stuff with the user
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Aviso");
                    builder.setIcon(R.drawable.ic_warning_black_48dp);
                    builder.setMessage("Usuario logado como " + currentUser.getUsername() + ", deseja sair dessa conta?");
                    builder.setCancelable(true);
                    builder.setNegativeButton("Cancelar",null);
                    builder.setPositiveButton("Sair", logout());
                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else if (getCurrentAccessToken() != null){
                    LoginManager.getInstance().logOut();
                } else {
                    // show the signup or login screen
                    Intent loginActivity = new Intent(MainActivity.this,LogInActivity.class);
                    startActivity(loginActivity);
                }

                break;
            case R.id.action_about:
                Intent aboutActivity = new Intent(this, AboutActivity.class);
                startActivity(aboutActivity);
                break;
            default:
                /* Nothing to do */
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public GoogleApiClient createClient(){
        return new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
}
