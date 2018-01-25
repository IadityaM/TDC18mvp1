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
import fgc.tdc18mvp1.dataModels.NavDrawData;

/**
 * Created by Aditya on 1/23/2018.
 */

public class NavDrawAdapter extends RecyclerView.Adapter<NavDrawAdapter.NavDrawRVViewHolder> {

    List<NavDrawData> drawer_rv_data = Collections.emptyList();

    Context context;
    private LayoutInflater drawer_rv_inflater;

    public NavDrawAdapter(Context context, List<NavDrawData> myRVdata) {

        drawer_rv_inflater = LayoutInflater.from(context);
        this.context = context;
        this.drawer_rv_data = myRVdata;
    }


    //Step 4: Create a LayoutInflater object, pass the layouts you want ot inflate and store it in a View Object (Example: View myview)
    @Override   //Called everytime a new row is to be created.
    public NavDrawAdapter.NavDrawRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View drawer_myview = drawer_rv_inflater.inflate(R.layout.nav_drawer_rv_item, parent, false);
        //View object "myview" here returns the root layout from the recycler_news_item

        //Step 5: Create a ViewHolder Object and pass the View Object created above into it.
        NavDrawAdapter.NavDrawRVViewHolder myDrawerHolder = new NavDrawAdapter.NavDrawRVViewHolder(drawer_myview);

        Log.d("TDC'18", "Inside onCreateViewHolder in drawerRV");
        //Step 7: return the ViewHolder Object here
        return myDrawerHolder;
    }

    @Override
    public void onBindViewHolder(NavDrawAdapter.NavDrawRVViewHolder holder, final int position) {
        //Step 10: Create a new object of the class for Data that has to be passed and get the data at the current position like:-
        NavDrawData curernt_data = drawer_rv_data.get(position);


        Log.d("TDC'18", "Inside onBindViewHolder in LearningRV @ #" + position);
        //Step 11: Start binding data to the ids referenced in the MyRVNewsViewHolder using the holder object by using the curret_data object.

        holder.drawer_rv_vh_title.setText(curernt_data.nav_string_title);
        holder.drawer_rv_vh_image.setImageResource(curernt_data.nav_pic_icon);

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
        return drawer_rv_data.size();
    }

    class NavDrawRVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Step 6: Instantiate the elements of the RVitem Layout and add references to ut using R.id
        //        Once Created this referencing will now take place automatically and won't consume memory to instantiate items for eveery row
        TextView drawer_rv_vh_title;
        ImageView drawer_rv_vh_image;
        Intent drawer_rv_vh_intent;

        public NavDrawRVViewHolder(View itemView) {
            super(itemView);
            drawer_rv_vh_title = itemView.findViewById(R.id.navdraw_tv_title);
            drawer_rv_vh_image = itemView.findViewById(R.id.navdraw_iv_icon);

            //Step 163: Add setOnClickListeners to the elements you want to be interactive
            drawer_rv_vh_image.setOnClickListener(this);
            drawer_rv_vh_title.setOnClickListener(this);
        }

        //Step 15: Implement the method from OnClickListener class
        @Override
        public void onClick(View view) {

            Snackbar.make(view, "News Image clicked at" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
            //Toast.makeText(, "News Image Clicked! @ #", Toast.LENGTH_SHORT).show();

            context.startActivity(new Intent(context, TDC17Activity.class));

        }
    }
}
