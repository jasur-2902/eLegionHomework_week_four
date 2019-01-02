package uz.shukurov.fourhtweekapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_single_fragment);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, getFragment())
                    .commit();
        }
    }

    protected abstract Fragment getFragment();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()) {
            case R.id.action_settings:


                fragmentManager
                        .beginTransaction()
                        .addToBackStack(SettingsFragment.class.getName())
                        .replace(R.id.fragmentContainer, SettingsFragment.newInstance())
                        .commit();
                showMessage(R.string.settings);
//                tvText.setText(R.string.settings);
                break;
            case R.id.action_search:
                showMessage(R.string.search);

                fragmentManager
                        .beginTransaction()
                        .addToBackStack(SearchFragment.class.getName())
                        .replace(R.id.fragmentContainer,SearchFragment.newInstance())
                        .commit();
//                tvText.setText(R.string.search);

                break;
            case R.id.action_logout:
                showMessage(R.string.logout);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }




    private void showMessage(@StringRes int string) {
        Toast.makeText(SingleFragmentActivity.this, string, Toast.LENGTH_SHORT).show();
    }

}
