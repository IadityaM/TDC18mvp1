package fgc.tdc18mvp1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.SettingsActivity;
import fgc.tdc18mvp1.UserProfileActivity;

public class EntryPassFrag extends Fragment {

    /*ImageView dp;
    Button sbmake;*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_entry_pass, container, false);

        /*dp = rootView.findViewById(R.id.dash_epass_iv_dp);

        sbmake = rootView.findViewById(R.id.dash_epass_btn_snackb);

        sbmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserProfileActivity.class));
            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserProfileActivity.class));
            }
        });*/

        return rootView;
    }

    public void ePassOnClick(View myView) {
        switch (myView.getId()) {
            case R.id.dash_epass_iv_settings:
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            case R.id.dash_epass_iv_dp:
                startActivity(new Intent(getActivity(), UserProfileActivity.class));
            case R.id.dash_epass_tv_uname:
                startActivity(new Intent(getActivity(), UserProfileActivity.class));
            case R.id.dash_epass_tv_designation:
                Snackbar.make(myView, "You're currently a " + null, Snackbar.LENGTH_SHORT).show();
            case R.id.dash_epass_btn_snackb:
                Snackbar.make(myView, "Onclick tester", Snackbar.LENGTH_SHORT).show();
            default:
                Snackbar.make(myView, "Button has no linked functions or actions", Snackbar.LENGTH_SHORT).show();
        }
    }

}
