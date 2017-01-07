package arey.es.tema3_hoja3;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Iterator;
import java.util.List;

public class Principal extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent anIntent;
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.ejercicio1: anIntent = new Intent(this, Ejercicio1.class); startActivity(anIntent); break;
            case R.id.ejercicio2: anIntent = new Intent(this, Ejercicio2.class); startActivity(anIntent); break;
            case R.id.ejercicio3: anIntent = new Intent(this, Ejercicio3.class); startActivity(anIntent); break;
            case R.id.ejercicio4: anIntent = new Intent(this, Ejercicio4.class); startActivity(anIntent); break;
        }

        return super.onOptionsItemSelected(item);
    }


}
