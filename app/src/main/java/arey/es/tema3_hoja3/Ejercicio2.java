package arey.es.tema3_hoja3;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.Random;

public class Ejercicio2 extends AppCompatActivity implements SensorEventListener{


    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;

    private SensorManager aSensorManager;
    private Sensor aSensor;

    private RelativeLayout myLayout;
    private int colors[] = {Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED};
    // Atributo que indica si el color ya ha sido cambiado para esa llamada.
    private boolean colorAlreadyChanged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        aSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        aSensor = aSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        myLayout = (RelativeLayout)findViewById(R.id.activity_ejercicio2);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (aSensor != null) {
            aSensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (aSensor != null) {
            aSensorManager.registerListener(this, aSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Si el teléfono está tumbado, su eje Y será 0.
        if (sensorEvent.values[Y] == 0) {
            if (!colorAlreadyChanged) {
                Random aRandom = new Random();
                int number = aRandom.nextInt(3);
                myLayout.setBackgroundColor(colors[number]);
                colorAlreadyChanged = true;
            }
        } else {
            colorAlreadyChanged = false;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
