package com.example.chua.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher {

    private SeekBar mSeekBar;
    private TextView Percentage, Tip, Total;
    private EditText Bill, NOP;
    int tip;
    private float bill = 0, people = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        mSeekBar = (SeekBar)findViewById(R.id.mseekBar);
        Percentage = (TextView)findViewById(R.id.mtxtPercent);
        Tip = (TextView)findViewById(R.id.mtxtTip);
        Total = (TextView)findViewById(R.id.mtxtTotal);
        Bill = (EditText)findViewById(R.id.mtxtBill);
        NOP = (EditText)findViewById(R.id.mtxtNOP);
        mSeekBar.setOnSeekBarChangeListener(this);
        Bill.addTextChangedListener(this);
        NOP.addTextChangedListener(this);
        }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Percentage.setText(mSeekBar.getProgress() + "%");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tip = mSeekBar.getProgress();
        displayCalculation();
    }

    private void displayCalculation() {
        float tipPerson;
        tipPerson = (float)tip/100;
        Total.setText("Php " + String.valueOf((bill / people) + ((bill / people) * tipPerson)));
        Tip.setText("Php" +String.valueOf((bill / people) * tipPerson));
        }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        try {
            bill = Float.parseFloat(String.valueOf(Bill.getText()));
            people = Float.parseFloat(String.valueOf(NOP.getText()));
            displayCalculation();
        }
        catch (Exception e){
            Total.setText("Php 0.00");
            Tip.setText("Php 0.00");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
