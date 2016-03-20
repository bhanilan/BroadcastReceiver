package com.example.berit.broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public static String TAG = "MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Received system broadcast");
        double value4 = 0;
        if (isOrderedBroadcast()) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                double value1 = extras.getDouble("n1");
                double value2 = extras.getDouble("n2");
                String value3 = extras.getString("op");
                value4 = calculate(value1, value2, value3);
            }
            setResultCode(Activity.RESULT_OK);
            setResultData(String.valueOf(value4));
        }
    }

    public double calculate(double n1, double n2, String op) {
        Log.d(TAG, "calculate");

        double calc = 0;

        if (op.equals("+")) {
            calc = n1 + n2;
        } else if (op.equals("-")) {
            calc = n1 - n2;
        } else if (op.equals("÷")) {
            calc = n1 / n2;
        } else if (op.equals("×")) {
            calc = n1 * n2;
        }
        return calc;
    }
}
