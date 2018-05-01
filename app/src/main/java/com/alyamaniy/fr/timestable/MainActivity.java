package com.alyamaniy.fr.timestable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    String[] table = new String[10];
    ArrayAdapter<String> arrayAdapter;
    ListView row;

    public void generateTimesTables(int progressNumber) {
        int number = 1;
        for(int i = 0; i < 10; i++) {
            table[i] = number + " x " + progressNumber + " = " + (number * progressNumber);
            number++;
        }
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, table);
        row.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        row = (ListView) findViewById(R.id.listView);
        SeekBar number = (SeekBar) findViewById(R.id.seekBar);
        number.setMax(20);
        number.setProgress(10);
        generateTimesTables(10);
        number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int progressNumber;

                if(progress < min) {
                    seekBar.setProgress(min);
                    progressNumber = 1;
                } else {
                    progressNumber = progress;
                }
                generateTimesTables(progressNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
