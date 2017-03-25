package beemusic.framgia.com.controlscrollrecycleview;

import android.databinding.BindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by beepi on 25/03/2017.
 */
public class BindingUtil {
    @BindingAdapter({"adapter", "context", "toolbar"})
    public static void initRecycleview(RecyclerView recyclerView, Adapter adapter,
                                       AppCompatActivity activity, final Toolbar toolbar) {
        if (recyclerView == null || adapter == null) return;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new ControlScrollListener() {
            @Override
            public void onHide() {
                toolbar.animate().translationY(-toolbar.getHeight())
                    .setInterpolator(new AccelerateInterpolator(2));
            }

            @Override
            public void onShow() {
                toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
            }
        });
    }

    @BindingAdapter("activity")
    public static void setSupportActionBar(Toolbar toolbar, AppCompatActivity activity) {
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
    }
}
