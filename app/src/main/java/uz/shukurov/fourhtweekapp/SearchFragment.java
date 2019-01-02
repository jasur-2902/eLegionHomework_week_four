package uz.shukurov.fourhtweekapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by androiddeveloper on 2/16/18.
 */

public class SearchFragment extends Fragment {


    private Button btnSearch;
    private EditText etSearch;

    private String result, searchText;

    public static SearchFragment newInstance() {

        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    SharedPreferences sharedPreferences;

    private View.OnClickListener mOnSearchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            searchText = etSearch.getText().toString();

            if (searchText.contains("&")) {
                searchText = searchText.replace("&", "%26");
            }

            if (result != getString(R.string.yandex)) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://" + result + ".com/search?q=" + searchText));
                startActivity(intent);
            } else {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://" + result + ".com/search/?text=" + searchText));
                startActivity(intent);

            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_search, container, false);

        btnSearch = v.findViewById(R.id.btn_search);
        etSearch = v.findViewById(R.id.et_search);

        sharedPreferences = getActivity().getSharedPreferences(SettingsFragment.searchEnginePref, Context.MODE_PRIVATE);

        result = sharedPreferences.getString(SettingsFragment.searchEnginePrefString, null);

        btnSearch.setOnClickListener(mOnSearchClickListener);


        return v;
    }

    private void shoWMessage(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
}
