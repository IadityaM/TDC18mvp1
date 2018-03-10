package fgc.tdc18mvp1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.UserProfileActivity;

public class EntryPassFrag extends Fragment {

    ImageView dash_entry_iv_dp;/*, dash_entry_iv_loc;*/
    TextView dash_entry_tv_usrname;
    /*Button sbmake;*/
    Intent intentToUserProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_entry_pass, container, false);

        intentToUserProfile = new Intent(getActivity(), UserProfileActivity.class);

        dash_entry_iv_dp = rootView.findViewById(R.id.dash_epass_iv_dp);
        /*dash_entry_iv_loc = rootView.findViewById(R.id.dash_epass_iv_location);*/
        dash_entry_tv_usrname = rootView.findViewById(R.id.dash_epass_tv_uname);

        dash_entry_iv_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToUserProfile);
            }
        });



        dash_entry_tv_usrname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToUserProfile);
            }
        });

        return rootView;
    }

    public void ePassOnClick(View myView) {
        switch (myView.getId()) {
            case R.id.dash_epass_tv_designation:
                Snackbar.make(myView, "You're currently a " + null, Snackbar.LENGTH_SHORT).show();
                break;
/*            case R.id.dash_epass_iv_refresh:
                Snackbar.make(myView, "Refreshing Data. Please wait...", Snackbar.LENGTH_SHORT).show();
                break;*/
            case R.id.dash_epass_iv_next:
                Snackbar.make(myView, "Refreshing Data. Please wait...", Snackbar.LENGTH_SHORT).show();
                break;
/*            case R.id.dash_epass_btn_snackb:
                Snackbar.make(myView, "Onclick tester", Snackbar.LENGTH_SHORT).show();
                break;*/
            default:
                Snackbar.make(myView, "Button has no linked functions or actions", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

}
