package uz.shukurov.fourhtweekapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by androiddeveloper on 2/16/18.
 */

public class SettingsFragment extends Fragment {


    SharedPreferences sharedPreferences;
    public static final String searchEnginePref ="searchEnginePref";
    public static final String searchEnginePrefString ="searchEnginePrefString";

    private   RadioGroup searchEngine;
    public static SettingsFragment newInstance(){

        SettingsFragment fragment =new SettingsFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_settings,container,false);

        sharedPreferences = getActivity().getSharedPreferences(searchEnginePref, Context.MODE_PRIVATE);

        searchEngine = v.findViewById(R.id.search_engine);
        searchEngine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton rb = radioGroup.findViewById(id);
                String radioText = rb.getText().toString();
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(searchEnginePrefString,radioText);
                editor.putString(searchEnginePref,String.valueOf(id));
                editor.commit();
            }



        });




        String aString = sharedPreferences.getString(searchEnginePref,null);
        if(aString != null){
            searchEngine.check(Integer.parseInt(aString));

        }

        return v;
    }


    private void showMessage(String string){
        Toast.makeText(getActivity(),string,Toast.LENGTH_SHORT).show();
    }
}
