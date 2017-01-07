package arey.es.tema3_hoja3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity implements SensorEventListener{

    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final String TAG = "Ejercicio 1";

    private SensorManager aSensorManager;
    private Sensor aSensor;
    private SensorEventListener aListener;
    private TextView resultX, resultY, resultZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        aSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        aSensor = aSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (aSensor != null) {
            aSensorManager.registerListener(aListener, aSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        resultX = (TextView)findViewById(R.id.resultX);
        resultY = (TextView)findViewById(R.id.resultY);
        resultZ = (TextView)findViewById(R.id.resultZ);
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
        resultX.setText(Float.toString(sensorEvent.values[X]));
        resultY.setText(Float.toString(sensorEvent.values[Y]));
        resultZ.setText(Float.toString(sensorEvent.values[Z]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
