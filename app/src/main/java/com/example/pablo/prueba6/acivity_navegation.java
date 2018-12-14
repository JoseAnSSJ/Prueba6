package com.example.pablo.prueba6;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pablo.prueba6.User.Login;
import com.example.pablo.prueba6.User.UserController;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class acivity_navegation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_navegation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pieChart =(PieChart)findViewById(R.id.pastel);


        try {

            if (UserController.b != true) {
                Toast.makeText(getApplicationContext(), "No estas logeado", Toast.LENGTH_LONG).show();
                Intent intento3 = new Intent(acivity_navegation.this, Login.class);
                startActivity(intento3);
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "No estas logeado", Toast.LENGTH_LONG).show();
            Intent intento3 = new Intent(acivity_navegation.this, Login.class);
            startActivity(intento3);
        }

        /*
        * Grafica de Pastel
        * */

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(1f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(android.R.color.white);
        pieChart.setTransparentCircleRadius(1f);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(40f,"OrdenesPendientes"));
        yValues.add(new PieEntry(10f,"OrdenesRealizadas"));
        yValues.add(new PieEntry(40f,"ReportesPendientes"));
        yValues.add(new PieEntry(10f,"ReportesRealizados"));





        PieDataSet dataSet = new PieDataSet(yValues, "SofTV");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setHighlightEnabled(true);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);
        pieChart.setData(data);

/*
* menu
* */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);






    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acivity_navegation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Ordenes) {
            Intent intent1 = new Intent(acivity_navegation.this, Orden.class);
            startActivity(intent1);
        } else if (id == R.id.Reportes) {
            Intent intent2 = new Intent(acivity_navegation.this, Reportes.class);
            startActivity(intent2);

        } else if (id == R.id.Confi) {
            Intent intent3 = new Intent(acivity_navegation.this, UserConfig.class);
            startActivity(intent3);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            //Acción
        }
        return false;
    }

}
