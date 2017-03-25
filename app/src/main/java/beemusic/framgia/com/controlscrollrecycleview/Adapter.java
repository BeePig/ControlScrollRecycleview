package beemusic.framgia.com.controlscrollrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import beemusic.framgia.com.controlscrollrecycleview.databinding.ItemRecycleViewBinding;

/**
 * Created by beepi on 25/03/2017.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] mItems;
    private LayoutInflater mLayoutInflater;

    public Adapter(String[] items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) mLayoutInflater = LayoutInflater.from(parent.getContext());
        ItemRecycleViewBinding binding =
            ItemRecycleViewBinding.inflate(mLayoutInflater, parent, false);
        return new Adapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecycleViewBinding mBinding;

        public ViewHolder(ItemRecycleViewBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        private void bind(int pos) {
            mBinding.setText(mItems[pos]);
            mBinding.executePendingBindings();
        }
    }
}
