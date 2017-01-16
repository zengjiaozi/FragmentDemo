package cn.a10086.www.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup = null;
    private FrameLayout id_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        eventsViews();
    }

    private void eventsViews() {
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void initViews() {
        radioGroup = (RadioGroup) findViewById(R.id.id_radioGroup);
        id_frame = (FrameLayout) findViewById(R.id.id_frame);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.id_one:
                Intent it = new Intent(this, MainActivity2.class);
                startActivity(it);
                break;
            case R.id.id_two:
                Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();
                MyFragment2 myFragment2 = new MyFragment2();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(R.id.id_frame, myFragment2);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.id_three:
                Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_four:
                Toast.makeText(this, "four", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
