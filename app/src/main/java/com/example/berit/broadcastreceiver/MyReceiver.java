package com.example.berit.broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public static String TAG = "MyReceiver";

    private CalcEngine calcEngine = new CalcEngine();

    @Override
    //Kutsutakse valja arvutamisteenus
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Received system broadcast");
        String calc = "";
        if (isOrderedBroadcast()) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                double nr1 = extras.getDouble("n1");
                double nr2 = extras.getDouble("n2");
                String operation = extras.getString("op");
                calc = calcEngine.calculate(nr1, nr2, operation);
            }
            setResultCode(Activity.RESULT_OK);
            setResultData(calc);
        }
    }
}
