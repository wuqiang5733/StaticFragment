package xuxiaoxiao.com.fragmentsecond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
            }
        });
    }

    private void replaceFragment() {
        FragmentManager fm = getSupportFragmentManager();
//        FragmentManager就是通过父容器来找Fragment的
        Fragment fragmentFind = fm.findFragmentById(R.id.bottom_layout);
        FragmentTransaction transaction = fm.beginTransaction();
        if (fragmentFind == null) {
            transaction.add(R.id.bottom_layout, new BottomFragment());
        }
        if (fragmentFind instanceof BottomFragment) {
            transaction.replace(R.id.bottom_layout, new AnotherBottomFragment());
        } else {
            transaction.replace(R.id.bottom_layout, new BottomFragment());
        }
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
