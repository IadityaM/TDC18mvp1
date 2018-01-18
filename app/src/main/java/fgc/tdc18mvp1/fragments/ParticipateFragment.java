package fgc.tdc18mvp1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.adapters.ParticipateCardAdapter;
import fgc.tdc18mvp1.dataModels.ParticipateData;

public class ParticipateFragment extends Fragment {

    private RecyclerView dash_participate_rv;
    private ParticipateCardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<ParticipateData> participateDataset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        getParticipateData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_participate, container, false);*/
        View rootView = inflater.inflate(R.layout.fragment_participate, container, false);

        dash_participate_rv = rootView.findViewById(R.id.dash_part_rv);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        dash_participate_rv.setLayoutManager(mLayoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        dash_participate_rv.setHasFixedSize(true);

        // specify an adapter (see also next example)
        mAdapter = new ParticipateCardAdapter(getActivity(), participateDataset);
        dash_participate_rv.setAdapter(mAdapter);

        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        //savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void getParticipateData() {
        participateDataset = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            participateDataset.add(i, new ParticipateData(R.drawable.ic_tdc_plane,
                    R.drawable.ic_done_all_black_24dp,
                    R.color.colorAccent,
                    1,
                    1,
                    "Contact Info",
                    "Help us reach you"));

            participateDataset.add(i + 1, new ParticipateData(R.drawable.ic_tdc_plane,
                    R.drawable.ic_cloud_done_black_24dp,
                    R.color.colorAccent2Dark,
                    1,
                    1,
                    "Social Connect",
                    "Social is IN"));

            participateDataset.add(i + 2, new ParticipateData(R.drawable.ic_tdc_plane,
                    R.drawable.ic_done_black_24dp,
                    R.color.colorAccent2,
                    1,
                    1,
                    "User Info",
                    "Help us know you better"));
            i = i + 2;
        }

    }
   /* public static List<ParticipateData> getParticipateData() {  //This class assigns data to the RV for News item
        //S0: Create a list object to hold the data but instantiate it using the superclass ArrayList
        List<ParticipateData> participate_rv_inputdata = new ArrayList<>();
        participateDataset = new ArrayList<>();

        //S2: Create a for loop to add new items
        for (int i = 0; i < 30; i++) {
            participate_rv_inputdata.add(new ParticipateData(R.drawable.ic_tdc_plane,
                    R.drawable.ic_done_black_24dp,
                    R.color.colorAccent3,
                    1,
                    1,
                    "User Info",
                    "Help us know you better"));

            *//*learning_rv_inputdata.add(i + 1, new LearningData(R.drawable.pika, R.drawable.ic_bookmark_border_black_24dp,
                    "Guide to Lean Startup Canvas",
                    "Going in with the new, learning the ropes around lean startup methodologies.",
                    "2 Hours",
                    "Read"));

            learning_rv_inputdata.add(i + 2, new LearningData(R.drawable.pika, R.drawable.ic_bookmark_border_black_24dp,
                    "Hands on wiht Modern Business Plans",
                    "Going in with the new, learning the ropes around lean startup methodologies.",
                    "10 Minutes",
                    "Watch"));
            i = i + 2;*//*
        }
        //S3: Return the List Object
        return participate_rv_inputdata;
    }*/
}
