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
import fgc.tdc18mvp1.adapters.LearnCardAdapter;
import fgc.tdc18mvp1.dataModels.LearningData;

public class LearnFragment extends Fragment {
    private RecyclerView dash_learn_rv;
    private LearnCardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<LearningData> learnDataset;

    public static List<LearningData> getLearningData() {  //This class assigns data to the RV for News item
        //S0: Create a list object to hold the data but instantiate it using the superclass ArrayList
        List<LearningData> learning_rv_inputdata = new ArrayList<>();

       /* //S1: Hardcoding the input data
        String[] my_eventsheadline = {"Cloth Donation Drive", "Utensils Donation Drive", "Stationery Donation Drive", "Book Donation Drive", "Blood Donation Drive"};
        String[] my_eventspublished = {"on 31-12-2016", "on 02-01-2017", "on 09-03-2017", "on 01-05-2017", "on 03-04-2017"};
        int[] my_eventsheader = {R.drawable.news_placeholder, R.drawable.news_placeholder_b, R.drawable.news_placeholder, R.drawable.news_placeholder_b, R.drawable.news_placeholder};
*/

        //S2: Create a for loop to add new items
        for (int i = 0; i < 30; i++) {
            learning_rv_inputdata.add(i, new LearningData(R.drawable.pika, R.drawable.ic_bookmark_border_black_24dp,
                    "Introduction to Lean Startups",
                    "Going in with the new, learning the ropes around lean startup methodologies.",
                    "4 Hours",
                    "Attend"));

            learning_rv_inputdata.add(i + 1, new LearningData(R.drawable.pika, R.drawable.ic_bookmark_border_black_24dp,
                    "Guide to Lean Startup Canvas",
                    "Going in with the new, learning the ropes around lean startup methodologies.",
                    "2 Hours",
                    "Read"));

            learning_rv_inputdata.add(i + 2, new LearningData(R.drawable.pika, R.drawable.ic_bookmark_border_black_24dp,
                    "Hands on wiht Modern Business Plans",
                    "Going in with the new, learning the ropes around lean startup methodologies.",
                    "10 Minutes",
                    "Watch"));
            i = i + 2;
            /*//RVDataNews[] mycurrentItem = new RVDataNews[my_newsheadline.length];
            //S2.a: Creating a new item of the RVDataNews class
            LearningData mycurrentItem = new LearningData();

            //S2.b: Referencing the items of the class and putting values from the above arrays in them
            mycurrentItem.rv_events_headline = my_eventsheadline[i % my_eventsheadline.length];
            mycurrentItem.rv_events_publishdate = my_eventspublished[i % my_eventspublished.length];
            mycurrentItem.rv_events_header_image = my_eventsheader[i % my_eventsheader.length];

            //S2.c: Adding the currentItem to the ArrayList object
            mydata_rv_events.add(mycurrentItem);*/
        }
        //S3: Return the List Object
        return learning_rv_inputdata;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_learn, container, false);

        dash_learn_rv = rootView.findViewById(R.id.dash_learn_rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        dash_learn_rv.setHasFixedSize(true);

        learnDataset = new ArrayList<>();
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        dash_learn_rv.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new LearnCardAdapter(getActivity(), getLearningData());
        dash_learn_rv.setAdapter(mAdapter);


        return rootView;
    }
}
