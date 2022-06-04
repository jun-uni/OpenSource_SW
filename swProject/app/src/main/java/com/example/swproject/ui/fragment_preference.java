package com.example.swproject.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.example.swproject.R;

public class fragment_preference extends PreferenceFragment {
//패키지 옮기면 에러 발생 *패키지 옮기지 말것*
    SharedPreferences prefs;

    ListPreference soccer_team_;
    ListPreference baseball_team_;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.setting);


        soccer_team_ = (ListPreference)findPreference("soccer_team");
        baseball_team_ = (ListPreference)findPreference("baseball_team");

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(prefListener);
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            if (s.equals("soccer_team")) {
                prefs.getString("soccer_team", "축구 팀");
            }

            if(s.equals("baseball_team")){
                prefs.getString("baseball_team", "야구 팀");
            }
        }
    };

}
