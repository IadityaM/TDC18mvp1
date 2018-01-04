package fgc.tdc18mvp1.transformers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Aditya on 8/10/2017.
 */

public class HorizontalViewPager extends VerticalViewPager {


    public HorizontalViewPager(Context context) {
        this(context, null);
    }

    public HorizontalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(false, new DepthTransformer());
    }

    private MotionEvent swapTouchEvent(MotionEvent event) {
        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercept = super.onInterceptTouchEvent(swapTouchEvent(event));
        //If not intercept, touch event should not be swapped.
        swapTouchEvent(event);
        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapTouchEvent(ev));
    }
}
