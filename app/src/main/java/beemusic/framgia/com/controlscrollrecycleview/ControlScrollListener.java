package beemusic.framgia.com.controlscrollrecycleview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by beepi on 25/03/2017.
 */
public abstract class ControlScrollListener extends RecyclerView.OnScrollListener {
    private static final int HIDE_THRESHOLD = 20;
    private int mScrolledDistance = 0;
    private boolean mVisible = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int firstVisibleItem =
            ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        //show views if first item is first visible position and views are hidden
        if (firstVisibleItem == 0) {
            if (!mVisible) {
                onShow();
                mVisible = true;
            }
        } else {
            if (mScrolledDistance > HIDE_THRESHOLD && mVisible) {
                onHide();
                mVisible = false;
                mScrolledDistance = 0;
            } else if (mScrolledDistance < -HIDE_THRESHOLD && !mVisible) {
                onShow();
                mVisible = true;
                mScrolledDistance = 0;
            }
        }
        if ((mVisible && dy > 0) || (!mVisible && dy < 0)) {
            mScrolledDistance += dy;
        }
    }

    public abstract void onHide();
    public abstract void onShow();
}
