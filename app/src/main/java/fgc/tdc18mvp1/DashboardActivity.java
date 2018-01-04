package fgc.tdc18mvp1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Timer;

import fgc.tdc18mvp1.fragments.EntryPassFrag;
import fgc.tdc18mvp1.fragments.HiglightsFrag;
import fgc.tdc18mvp1.fragments.LearnFragment;
import fgc.tdc18mvp1.fragments.ParticipareFragment;
import fgc.tdc18mvp1.fragments.TDC18OverviewFragment;

public class DashboardActivity extends AppCompatActivity {

    private static final int NUM_PAGES_SWITCHY = 2, NUM_PAGES_HIGHLIGHTS = 5, HIGHLIGHTS_TIMER_NEXT = 4000, HIGHLIGHTS_TIMER_START = 4500;
    Timer dash_vp_highlights_timer;
    ViewPager dash_vp_highlights, dash_vp_switchy;
    SwitchCompat dash_switch_vpcontrol;

    Toolbar dash_tool_bar;
    ActionBar dash_action_bar;

    PagerAdapter dash_vp_switchy_adapter, dash_vp_highlights_adapter;

    TextView dash_tv_learn, dash_tv_participate;
    //Fragments
    EntryPassFrag epf1;
    private int enable_color = R.color.colorAccent;
    private int disable_color = R.color.colorAccent2Dark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        dash_tool_bar = findViewById(R.id.dash_toolbar);
        dash_tool_bar.setTitle(R.string.dash_title);
        setSupportActionBar(dash_tool_bar);
        dash_action_bar = getSupportActionBar();


        dash_switch_vpcontrol = findViewById(R.id.dash_switch_toggle);
        dash_vp_highlights = findViewById(R.id.dash_vp_highlights);
        dash_vp_switchy = findViewById(R.id.dash_vp_switchy);

        dash_tv_learn = findViewById(R.id.dash_tv_switch_learn);
        dash_tv_participate = findViewById(R.id.dash_tv_switch_participate);

        dash_switch_vpcontrol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

                if (position == 1) {
                    dash_switch_vpcontrol.setChecked(true);
                    //switchyVPParticipateMode();
                } else {
                    dash_switch_vpcontrol.setChecked(false);
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
    }

    //All button and view clicks are handled together in this function
    public void dashClick(View view) {
        switch (view.getId()) {
            case R.id.dash_tv_switch_learn:
                dash_switch_vpcontrol.setChecked(false);
            case R.id.dash_tv_switch_participate:
                dash_switch_vpcontrol.setChecked(true);
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
    public boolean onOptionsItemSelected(MenuItem item) {
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
        dash_tv_participate.setTextColor(getResources().getColor(R.color.colorTextMultiline));
        dash_vp_switchy.setCurrentItem(0);
    }

    public void switchyVPParticipateMode() {
        dash_tv_participate.setTextColor(getResources().getColor(R.color.colorAccent));
        dash_tv_learn.setTextColor(getResources().getColor(R.color.colorTextMultiline));
        dash_vp_switchy.setCurrentItem(1);
    }

    public void ePassOnClick(View view) {
        epf1.ePassOnClick(view);
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
                    return new ParticipareFragment();

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
