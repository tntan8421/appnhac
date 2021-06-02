package vn.udn.vku.tntan.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import vn.udn.vku.tntan.appnhac.R;

public class ManhinhchoActivity extends AppCompatActivity {

    // ProgressBar progressBar;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhcho);
        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(5000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent intent =new Intent(ManhinhchoActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        bamgio.start();

    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
