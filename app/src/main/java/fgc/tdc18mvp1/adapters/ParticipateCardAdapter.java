package fgc.tdc18mvp1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.TDC17Activity;
import fgc.tdc18mvp1.dataModels.ParticipateData;

/**
 * Created by Aditya on 12/30/2017.
 */

public class ParticipateCardAdapter extends RecyclerView.Adapter<ParticipateCardAdapter.ParticipateRVViewHolder> {
    //Step 8: Instantiate the class created for the data of this RV into a List/ArrayList.
    List<ParticipateData> participate_rv_data = Collections.emptyList();
    //ArrayList<RVDataNews> data_RV_news; //Arraylist converts all data types to object type by upcasting
    //Step 16.a: Initiate a context vairable to be used in the on click view of inner class "MyRVNewsViewHolder"
    Context context;
    private LayoutInflater learning_rv_inflater;

    //Step 9: Create a contructor using alt+insert and add the context parameters to it.
    //Set the inflater using the context reference
    public ParticipateCardAdapter(Context context, List<ParticipateData> my_newsRVdata) {
        learning_rv_inflater = LayoutInflater.from(context);
        //Step 16.b: assign the context of current activity to the context variable created above.
        this.context = context;

        this.participate_rv_data = my_newsRVdata;
    }

    public void delete(int position) {
        participate_rv_data.remove(position);
        notifyItemRemoved(position);
    }

    //Step 4: Create a LayoutInflater object, pass the layouts you want ot inflate and store it in a View Object (Example: View myview)
    @Override   //Called everytime a new row is to be created.
    public ParticipateCardAdapter.ParticipateRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View learn_myview = learning_rv_inflater.inflate(R.layout.dash_participate_rv_card, parent, false);
        //View object "myview" here returns the root layout from the recycler_news_item

        //Step 5: Create a ViewHolder Object and pass the View Object created above into it.
        ParticipateCardAdapter.ParticipateRVViewHolder mynewsholder = new ParticipateCardAdapter.ParticipateRVViewHolder(learn_myview);

        Log.d("TDC'18", "Inside onCreateViewHolder in LearningRV");
        //Step 7: return the ViewHolder Object here
        return mynewsholder;
    }

    @Override
    public void onBindViewHolder(ParticipateCardAdapter.ParticipateRVViewHolder holder, final int position) {
        //Step 10: Create a new object of the class for Data that has to be passed and get the data at the current position like:-
        ParticipateData curernt_data = participate_rv_data.get(position);


        Log.d("TDC'18", "Inside onBindViewHolder in LearningRV @ #" + position);
        //Step 11: Start binding data to the ids referenced in the MyRVNewsViewHolder using the holder object by using the curret_data object.

        holder.participate_rv_vh_title.setText(curernt_data.part_string_step_name);
        holder.participate_rv_vh_description.setText(curernt_data.part_string_step_desc);
        holder.participate_rv_vh_status_strip.setImageResource(curernt_data.part_status_color);
        holder.participate_rv_vh_status_icon.setImageResource(curernt_data.part_pic_status_icon);
        holder.participate_rv_vh_status_vector.setImageResource(curernt_data.part_pic_step_vector);

        //Step 13: Add setOnClickListeners to the elements you want to be interactive
        /*holder.rv_news_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "News Image clicked at" + position, Snackbar.LENGTH_SHORT).show();
                //Toast.makeText(view, "Image clicked at" +position, Toast.LENGTH_SHORT);
            }
        });*/

/*        holder.rv_news_headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "News Headline clicked at" + position, Snackbar.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        //Step 12: Return the size of the List here
        return participate_rv_data.size();
    }

    //Step 2: Create an inner class and extend RecyclerView.ViewHolder, Remove errors by creating constuctor for superclass
    //Step 14: implement the View.OnClickListener and implement all of it's functions.

    class ParticipateRVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Step 6: Instantiate the elements of the RVitem Layout and add references to ut using R.id
        //        Once Created this referencing will now take place automatically and won't consume memory to instantiate items for eveery row
        TextView participate_rv_vh_title, participate_rv_vh_description;
        ImageView participate_rv_vh_status_strip, participate_rv_vh_status_icon, participate_rv_vh_status_vector;
        RelativeLayout participate_rv_vh_card_back;

        public ParticipateRVViewHolder(View itemView) {
            super(itemView);
            participate_rv_vh_title = itemView.findViewById(R.id.part_card_tv_stepname);
            participate_rv_vh_description = itemView.findViewById(R.id.part_card_tv_desc);
            participate_rv_vh_status_strip = itemView.findViewById(R.id.part_card_iv_status_strip);
            participate_rv_vh_status_icon = itemView.findViewById(R.id.part_card_iv_status);
            participate_rv_vh_status_vector = itemView.findViewById(R.id.part_card_iv_vector);
            participate_rv_vh_card_back = itemView.findViewById(R.id.part_card_lay_data);

            //Step 163: Add setOnClickListeners to the elements you want to be interactive
            participate_rv_vh_card_back.setOnClickListener(this);
        }

        //Step 15: Implement the method from OnClickListener class
        @Override
        public void onClick(View view) {

            switch (itemView.getId()) {

            }
            Snackbar.make(view, "News Image clicked at" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
            //Toast.makeText(, "News Image Clicked! @ #", Toast.LENGTH_SHORT).show();

            //Step 16.c: Use the context variable created in setp 16.a to reference and start the activity
            context.startActivity(new Intent(context, TDC17Activity.class));

            //delete(getPosition()); //Deprecaed method
            //delete(getAdapterPosition());
        }
    }
}