package fgc.tdc18mvp1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import fgc.tdc18mvp1.adapters.NavDrawAdapter;
import fgc.tdc18mvp1.dataModels.NavDrawData;
import fgc.tdc18mvp1.fragments.EntryPassFrag;
import fgc.tdc18mvp1.fragments.HiglightsFrag;
import fgc.tdc18mvp1.fragments.LearnFragment;
import fgc.tdc18mvp1.fragments.ParticipateFragment;
import fgc.tdc18mvp1.fragments.TDC18OverviewFragment;

public class DashboardActivity extends AppCompatActivity {

    private static final int NUM_PAGES_SWITCHY = 2, NUM_PAGES_HIGHLIGHTS = 5, HIGHLIGHTS_TIMER_NEXT = 4000, HIGHLIGHTS_TIMER_START = 4500;
    Timer dash_vp_highlights_timer;

    ViewPager dash_vp_highlights, dash_vp_switchy;
    PagerAdapter dash_vp_switchy_adapter, dash_vp_highlights_adapter;

    SwitchCompat dash_switch_pager_control;

    Toolbar dash_tool_bar;
    ActionBar dash_action_bar;

    TextView dash_tv_learn, dash_tv_participate;
    //Fragments
    EntryPassFrag epf1;

    //Nav Drawer
    private List<NavDrawData> drawerNavList;
    private RecyclerView dash_RV_drawer;
    private NavDrawAdapter mDrawerRVAdapter;
    private RecyclerView.LayoutManager mDrawerRVLayoutManager;

    private Button drawer_btn_logon;
    private ImageView drawer_iv_feedback, dash_entry_iv_loc;

    //-------------#End of Nav Drawer#--------------------

    private int color_participate = R.color.colorAccent;
    private int color_learn = R.color.colorAccent2;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        dash_tool_bar = findViewById(R.id.dash_toolbar);
        dash_tool_bar.setTitle(R.string.dash_title);

        setSupportActionBar(dash_tool_bar);
        dash_action_bar = getSupportActionBar();


        dash_switch_pager_control = findViewById(R.id.dash_switch_toggle);
        dash_vp_highlights = findViewById(R.id.dash_vp_highlights);
        dash_vp_switchy = findViewById(R.id.dash_vp_switchy);

        dash_tv_learn = findViewById(R.id.dash_tv_switch_learn);
        dash_tv_participate = findViewById(R.id.dash_tv_switch_participate);

        dash_switch_pager_control.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.v("Switch State=", "" + isChecked);

                if (isChecked) {
                    //dash_switch_vpcontrol.tint
                    //dash_switch_vpcontrol.setThumbTintList(R.color.colorAccent);
                    switchyVPParticipateMode();

                    //list_toggle.setText("Only Today's");  //To change the text near to switch
                    Log.d("You are :", "Checked");
                } else {
                    switchyVPLearnMode();
                    //list_toggle.setText("All List");  //To change the text near to switch
                    Log.d("You are :", " Not Checked");
                }
            }
        });

        dash_vp_switchy_adapter = new SwitcherPagerAdapter(getSupportFragmentManager());
        dash_vp_switchy.setAdapter(dash_vp_switchy_adapter);

        dash_vp_switchy.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    dash_switch_pager_control.setChecked(false);
                    //switchyVPParticipateMode();
                } else {
                    dash_switch_pager_control.setChecked(true);
                    //switchyVPLearnMode();
                }
                /*switch (position) {
                    case 0:
                        dash_switch_vpcontrol.setChecked(false);
                        switchyVPLearnMode();
                    case 1:
                        dash_switch_vpcontrol.setChecked(true);
                        switchyVPParticipateMode();
                }*/
            }
        });

        dash_vp_highlights_adapter = new HighlightsPagerAdapter(getSupportFragmentManager());
        dash_vp_highlights.setAdapter(dash_vp_highlights_adapter);
        dash_vp_highlights.addOnPageChangeListener(new CircularViewPagerHandler(dash_vp_highlights));

/*        //Doesn't take care of the fact that user may change the viewpager fragment
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (dash_vp_highlights.getCurrentItem() == 4) {
                    dash_vp_highlights.setCurrentItem(0);
                }
                else{
                    dash_vp_highlights.setCurrentItem(dash_vp_highlights.getCurrentItem()+1, true);
                }
            }
        };
        dash_vp_highlights_timer = new Timer(); // This will create a new Thread
        dash_vp_highlights_timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, HIGHLIGHTS_TIMER_START, HIGHLIGHTS_TIMER_NEXT);*/


        epf1 = new EntryPassFrag();

        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = findViewById(R.id.dash_lay_drawer);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.nav_drawer_open,
                R.string.nav_drawer_close) {

            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

                drawer_btn_logon = findViewById(R.id.nav_btn_signon);
                dash_entry_iv_loc = findViewById(R.id.dash_epass_iv_location);

                /*Click Listeners*/
                drawer_btn_logon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DashboardActivity.this, LogonActivity.class));
                    }
                });

                dash_entry_iv_loc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DashboardActivity.this, MapsActivity.class));
                    }
                });

                getDrawerData();
                dash_RV_drawer = findViewById(R.id.nav_rv_activities);

                // use a linear layout manager
                mDrawerRVLayoutManager = new LinearLayoutManager(getApplicationContext());
                dash_RV_drawer.setLayoutManager(mDrawerRVLayoutManager);

                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                dash_RV_drawer.setHasFixedSize(true);

                //learnDataset = new ArrayList<>();

                // specify an adapter (see also next example)
                mDrawerRVAdapter = new NavDrawAdapter(getApplicationContext(), drawerNavList);
                dash_RV_drawer.setAdapter(mDrawerRVAdapter);

                drawer_iv_feedback = findViewById(R.id.nav_drawer_iv_feedback);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    //All button and view clicks are handled together in this function
    public void dashClick(View view) {
        switch (view.getId()) {
            case R.id.dash_tv_switch_learn:
                dash_switch_pager_control.setChecked(false);
                break;
            case R.id.dash_tv_switch_participate:
                dash_switch_pager_control.setChecked(true);
                break;

            case R.id.nav_drawer_iv_feedback:
                //TODO: Add a feedback Activity
                Snackbar.make(view, "Feed us your grievences or appreciation", Snackbar.LENGTH_SHORT).show();
                break;

            /*case R.id.home_fab_add_claims:
                startActivity(toServiceRequest);
                break;
            case R.id.home_fab_share_item:
                startActivity(toSharing);
                break;
            case R.id.home_tv_reg_products:
                startActivity(toRegistered);
                break;
            case R.id.home_tv_claims:
                startActivity(toClaims);
                break;
            case R.id.home_tv_shared:
                startActivity(toSharing);
                break;*/
            default:
                Snackbar.make(view, "Button has no linked functions or actions", Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        switch (item.getItemId()) {
            case R.id.action_refresh:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                item.setIcon(R.drawable.ic_favorite_black_24dp);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void switchyVPLearnMode() {
        dash_tv_learn.setTextColor(getResources().getColor(R.color.colorAccent2));
        dash_tv_participate.setTextColor(getResources().getColor(R.color.colorBackground_W));
        dash_vp_switchy.setCurrentItem(0);
    }

    public void switchyVPParticipateMode() {
        dash_tv_participate.setTextColor(getResources().getColor(R.color.colorAccent));
        dash_tv_learn.setTextColor(getResources().getColor(R.color.colorBackground_W));
        dash_vp_switchy.setCurrentItem(1);
    }

    public void ePassOnClick(View view) {
        epf1.ePassOnClick(view);
    }

    public void getDrawerData() {
        drawerNavList = new ArrayList<>();

        drawerNavList.add(
                new NavDrawData(
                        R.drawable.pika,
                        "My Profile",
                        new Intent(this, UserProfileActivity.class)
                ));

        drawerNavList.add(
                new NavDrawData(
                        R.drawable.icon_tdc_plane,
                        "TDC Legacy",
                        new Intent(this, TDC17Activity.class)
                ));
    }

    //ViewPager Handler Classes
    private class SwitcherPagerAdapter extends FragmentPagerAdapter {
        public SwitcherPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new LearnFragment();

                case 1:
                    return new ParticipateFragment();

                default:
                    return new LearnFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES_SWITCHY;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

    private class HighlightsPagerAdapter extends FragmentStatePagerAdapter {
        public HighlightsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new EntryPassFrag();

                case 1:
                    return new TDC18OverviewFragment();

                default:
                    return new HiglightsFrag();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES_HIGHLIGHTS;
        }


    }

    public class CircularViewPagerHandler implements ViewPager.OnPageChangeListener {
        private ViewPager mViewPager;
        private int mCurrentPosition;
        private int mScrollState;

        public CircularViewPagerHandler(final ViewPager viewPager) {
            mViewPager = viewPager;
        }

        @Override
        public void onPageSelected(final int position) {
            mCurrentPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(final int state) {
            handleScrollState(state);
            mScrollState = state;
        }

        private void handleScrollState(final int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                setNextItemIfNeeded();
            }
        }

        private void setNextItemIfNeeded() {
            if (!isScrollStateSettling()) {
                handleSetNextItem();
            }
        }

        private boolean isScrollStateSettling() {
            return mScrollState == ViewPager.SCROLL_STATE_SETTLING;
        }

        private void handleSetNextItem() {
            final int lastPosition = mViewPager.getAdapter().getCount() - 1;
            if (mCurrentPosition == 0) {
                mViewPager.setCurrentItem(lastPosition, false);
            } else if (mCurrentPosition == lastPosition) {
                mViewPager.setCurrentItem(0, false);
            }
        }

        @Override
        public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
        }
    }
}
