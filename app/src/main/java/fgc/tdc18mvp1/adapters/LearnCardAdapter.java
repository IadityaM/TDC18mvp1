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
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.TDC17Activity;
import fgc.tdc18mvp1.dataModels.LearningData;

/**
 * Created by Aditya on 12/26/2017.
 */
//Step 1: Create a class and extend RecyclerView.Adapter, remove errors by overriding the required methods
//Step 2: Refer Below (class MyRVNewsViewHolder extends RecyclerView.ViewHolder)
//Step 3: Pass the ViewHolder class made in step 2 as an argument to the extend statement in step1
//        Replace the usage of RecyclerView.ViewHolder with your custom ViewHolder Class using alt+enter
//        Be Careful not to replace the AdapterClass with the Data class while using auto-complete
//Step 4: Refer Below (above public MyRVNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType))
//Step 5: Refer Below (inside public MyRVNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType))
//Step 6: Refer Below (inside class MyRVNewsViewHolder extends RecyclerView.ViewHolder)
//Step 7: Refer Below (inside public MyRVNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType))
//Step 8: Refer Below (Right inside the main adapter class)
//Step 9: Refer Below (Below Step 8)
//Step 10: Refer Below (inside public void onBindViewHolder(MyRVNewsViewHolder holder, int position))
//Step 11: Refer Below (inside public void onBindViewHolder(MyRVNewsViewHolder holder, int position))
//Step 12: Refer Below (inside public int getItemCount())
//Step 13: Refer Below (inside public void onBindViewHolder(MyRVNewsViewHolder holder, int position))
//Step 14:
//Step 15:
//Step 16:

public class LearnCardAdapter extends RecyclerView.Adapter<LearnCardAdapter.LearningRVViewHolder> {
    //Step 8: Instantiate the class created for the data of this RV into a List/ArrayList.
    List<LearningData> learning_rv_data = Collections.emptyList();
    //ArrayList<RVDataNews> data_RV_news; //Arraylist converts all data types to object type by upcasting
    //Step 16.a: Initiate a context vairable to be used in the on click view of inner class "MyRVNewsViewHolder"
    Context context;
    private LayoutInflater learning_rv_inflater;

    //Step 9: Create a contructor using alt+insert and add the context parameters to it.
    //Set the inflater using the context reference
    public LearnCardAdapter(Context context, List<LearningData> myRVdata) {
        learning_rv_inflater = LayoutInflater.from(context);
        //Step 16.b: assign the context of current activity to the context variable created above.
        this.context = context;

        this.learning_rv_data = myRVdata;
    }

    public void delete(int position) {
        learning_rv_data.remove(position);
        notifyItemRemoved(position);
    }

    //Step 4: Create a LayoutInflater object, pass the layouts you want ot inflate and store it in a View Object (Example: View myview)
    @Override   //Called everytime a new row is to be created.
    public LearningRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View learn_myview = learning_rv_inflater.inflate(R.layout.dash_learn_rv_card, parent, false);
        //View object "myview" here returns the root layout from the recycler_news_item

        //Step 5: Create a ViewHolder Object and pass the View Object created above into it.
        LearningRVViewHolder myLearningHolder = new LearningRVViewHolder(learn_myview);

        Log.d("TDC'18", "Inside onCreateViewHolder in LearningRV");
        //Step 7: return the ViewHolder Object here
        return myLearningHolder;
    }

    @Override
    public void onBindViewHolder(LearningRVViewHolder holder, final int position) {
        //Step 10: Create a new object of the class for Data that has to be passed and get the data at the current position like:-
        LearningData curernt_data = learning_rv_data.get(position);


        Log.d("TDC'18", "Inside onBindViewHolder in LearningRV @ #" + position);
        //Step 11: Start binding data to the ids referenced in the MyRVNewsViewHolder using the holder object by using the curret_data object.

        holder.learn_rv_vh_title.setText(curernt_data.learn_string_title);
        holder.learn_rv_vh_description.setText(curernt_data.learn_string_description);
        holder.learn_rv_vh_duration.setText(curernt_data.learn_string_duration);
        holder.learn_rv_vh_action.setText(curernt_data.learn_string_action);
        holder.learn_rv_vh_image.setImageResource(curernt_data.learn_pic_header);
        holder.learn_rv_vh_endorse.setImageResource(curernt_data.learn_pic_endorse);

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
        return learning_rv_data.size();
    }

    //Step 2: Create an inner class and extend RecyclerView.ViewHolder, Remove errors by creating constuctor for superclass
    //Step 14: implement the View.OnClickListener and implement all of it's functions.

    class LearningRVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Step 6: Instantiate the elements of the RVitem Layout and add references to ut using R.id
        //        Once Created this referencing will now take place automatically and won't consume memory to instantiate items for eveery row
        TextView learn_rv_vh_title, learn_rv_vh_description, learn_rv_vh_duration, learn_rv_vh_action;
        ImageView learn_rv_vh_image, learn_rv_vh_endorse;

        public LearningRVViewHolder(View itemView) {
            super(itemView);
            learn_rv_vh_title = itemView.findViewById(R.id.learn_card_content_title);
            learn_rv_vh_description = itemView.findViewById(R.id.learn_card_content_desc);
            learn_rv_vh_duration = itemView.findViewById(R.id.learn_card_content_duration);
            learn_rv_vh_action = itemView.findViewById(R.id.learn_card_content_action);
            learn_rv_vh_image = itemView.findViewById(R.id.learn_card_iv_poster);
            learn_rv_vh_endorse = itemView.findViewById(R.id.learn_card_content_endorse);

            //Step 163: Add setOnClickListeners to the elements you want to be interactive
            learn_rv_vh_image.setOnClickListener(this);
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