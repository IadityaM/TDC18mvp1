package fgc.tdc18mvp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fgc.tdc18mvp1.fragments.OnBoardFrag;
import fgc.tdc18mvp1.transformers.DepthPageTransformer;

public class OnBoardActivity extends AppCompatActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 3;
    Button btn_onBoard_Skip, btn_onBoard_Next;
    Intent toHome;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.ob_vp_intro);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.setPageTransformer(true, new DepthPageTransformer());

        toHome = new Intent(OnBoardActivity.this, DashboardActivity.class);
    }

    //All button and view clicks are handled together in this function
    public void obClick(View view) {
        switch (view.getId()) {
            case R.id.ob_btn_next:
                if (mPager.getCurrentItem() == 2) {
                    // If the user is currently looking at the first step, allow the system to handle the
                    // Back button. This calls finish() on this activity and pops the back stack.
                    startActivity(toHome);
                    finish();
                } else {
                    // Otherwise, go to the next screen.
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                }
                break;
            case R.id.ob_btn_skip:
                startActivity(toHome);
                finish();
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
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new OnBoardFrag();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
