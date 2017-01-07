package arey.es.tema3_hoja3;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class Ejercicio3 extends AppCompatActivity implements SensorEventListener {

    private SensorManager aSensorManager;
    private Sensor aSensor;

    private RelativeLayout aLayout;

    private static final float THRESHOLD = 0.8f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        aSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        aSensor = aSensorManager.getDefaultSensor(SensorManager.SENSOR_LIGHT);

        aLayout = (RelativeLayout)findViewById(R.id.activity_ejercicio3);
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
        if (sensorEvent.values[0] > THRESHOLD) {
            aLayout.setBackgroundColor(Color.WHITE);
        } else {
            aLayout.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
