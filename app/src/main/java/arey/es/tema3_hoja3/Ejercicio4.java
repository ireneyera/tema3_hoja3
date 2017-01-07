package arey.es.tema3_hoja3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class Ejercicio4 extends AppCompatActivity implements SensorEventListener{

    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final String TAG = "Ejercicio4";

    private TextView exercise4Number;
    private SensorManager aManager;
    private Sensor aSensor;

    private float oldX=0, oldY=0, oldZ=0;
    private long timeStamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        exercise4Number = (TextView)findViewById(R.id.exercise4Number);

        aManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        aSensor = aManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (aSensor != null) {
            aManager.unregisterListener(this);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (aSensor != null) {
            aManager.registerListener(this, aSensor, SensorManager.SENSOR_DELAY_NORMAL);
            oldX = 0;
            oldY = 0;
            oldZ = 0;
            timeStamp = System.currentTimeMillis();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        long currentTimeStamp = System.currentTimeMillis();
        if (currentTimeStamp - timeStamp > 100) {
            float currentX, currentY, currentZ;

            currentX = sensorEvent.values[X];
            currentY = sensorEvent.values[Y];
            currentZ = sensorEvent.values[Z];

            float speed = (oldX+oldY+oldZ - currentX - currentY - currentZ) / (currentTimeStamp-timeStamp) * 10000;

            if (speed > 500) {
                Log.i(TAG, "SHAKE IT!!!!");
                Random aRandomNumber = new Random();
                int number = aRandomNumber.nextInt(100);

                exercise4Number.setText(Integer.toString(number));

                oldX = currentX;
                oldY = currentY;
                oldZ = currentZ;
            }
            timeStamp = currentTimeStamp;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
