package uz.shukurov.fourhtweekapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by androiddeveloper on 2/16/18.
 */

public class MainFragment extends Fragment {


    private TextView tvText;


    public static MainFragment newInstance() {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_main,container,false);
        tvText = v.findViewById(R.id.tvText);
        return v;
    }


    private void showMessage(@StringRes int string){
        Toast.makeText(getActivity(),string,Toast.LENGTH_SHORT).show();
    }


}
