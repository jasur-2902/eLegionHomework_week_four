package uz.shukurov.fourhtweekapp;


import android.support.v4.app.Fragment;

/**
 * Created by tanchuev on 08.11.2017.
 */

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fr_main);
//        tvText = findViewById(R.id.tvText);
//    }
//
//
//
//    private void showMessage(@StringRes int string){
//        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
//    }


