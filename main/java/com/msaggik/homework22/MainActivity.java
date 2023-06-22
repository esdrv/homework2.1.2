package com.msaggik.homework22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float telescopePrice = 14_000;
    int account = 1_000;
    float wage = 2_500;
    float percentBank = 5;


    private float telescopePriceWithContribution() {
        return telescopePrice - account;
    }
    public float mortgageCosts(float wage, int account) {
        return (wage*account)/1000;
    }
    public int countMonth(float total, float mortgageCosts, float percentBankYear) {

        float percentBankMonth = percentBankYear / 12;
        int count = 0;
        while (total>0) {
            count++;
            total = (total + (total*percentBankMonth)/100) - mortgageCosts;
        }
        return count;
    }
    private TextView countOut;
    private TextView manyMonthOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countOut = findViewById(R.id.countOut);
        manyMonthOut = findViewById(R.id.manyMonthOut);



        countOut.setText("За какое количество месяцев можно накопить на телескоп " + countMonth(telescopePriceWithContribution(), mortgageCosts(wage, account),percentBank) + " месяцев");
        String monthlyPaymentsList = "";
        float[] monthlyPayments = new float[0];
        for(float list : monthlyPayments) {
            if (list > 0) {
                monthlyPaymentsList = monthlyPaymentsList + Float.toString(list) + " монет ";
            } else {
                break;
            }
        }
        
        manyMonthOut.setText("Первоначальный взнос " + account + " монет, ежемесячные выплаты: " + monthlyPaymentsList);
    }
}