package com.example.abhishek.viewanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    String styles[]={"Flash","Pulse","RubberBand","Shake","Swing","Wobble","Bounce","Tada","StandUp","Wave"};
    Techniques tq[]={Techniques.Flash, Techniques.Pulse, Techniques.RubberBand, Techniques.Shake, Techniques.Swing,
            Techniques.Wobble, Techniques.Bounce, Techniques.Tada, Techniques.StandUp, Techniques.Wave};
    ArrayAdapter<String> arrayAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        ListView lv=(ListView)findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,styles);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                YoYo.with(tq[position]).duration(700)
                        .repeat(5)
                        .playOn(findViewById(R.id.text));
            }
        });
    }
}
