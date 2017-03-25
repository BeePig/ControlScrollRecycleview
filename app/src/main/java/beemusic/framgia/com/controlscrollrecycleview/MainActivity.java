package beemusic.framgia.com.controlscrollrecycleview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import beemusic.framgia.com.controlscrollrecycleview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String[] mList;
    private Adapter mAdapter;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mList = getResources().getStringArray(R.array.items);
        mAdapter = new Adapter(mList);
        mBinding.setActivity(this);
    }

    public Adapter getAdapter() {
        return mAdapter;
    }
}
