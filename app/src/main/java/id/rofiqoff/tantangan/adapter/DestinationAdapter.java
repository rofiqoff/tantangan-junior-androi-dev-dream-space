package id.rofiqoff.tantangan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.rofiqoff.tantangan.R;
import id.rofiqoff.tantangan.model.Destination;
import id.rofiqoff.tantangan.utils.Tools;

public class DestinationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Destination> mItems;

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Destination obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public DestinationAdapter(Context context, List<Destination> items) {
        this.mItems = items;
        this.mContext = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView imageFirst;
        public AppCompatImageView imageSecond;
        public RelativeLayout rootParent;

        public OriginalViewHolder(View v) {
            super(v);
            imageFirst = v.findViewById(R.id.image_map);
            imageSecond = v.findViewById(R.id.image_item);
            rootParent = v.findViewById(R.id.root);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_destination_item, parent, false);
        viewHolder = new OriginalViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            Destination data = mItems.get(position);

            if (position == 0) {
                view.imageSecond.setVisibility(View.GONE);
                view.imageFirst.setVisibility(View.VISIBLE);
                Tools.displayImageOriginal(mContext, view.imageFirst, data.image);
            } else {
                view.imageFirst.setVisibility(View.GONE);
                view.imageSecond.setVisibility(View.VISIBLE);
                Tools.displayImageOriginal(mContext, view.imageSecond, data.image);
            }

            view.rootParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, mItems.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
