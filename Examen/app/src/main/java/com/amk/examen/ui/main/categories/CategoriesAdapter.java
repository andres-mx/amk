package com.amk.examen.ui.main.categories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amk.examen.R;
import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.BaseViewHolder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andresaleman on 9/21/17.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<BaseViewHolder>
{
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private ArrayList<GettingStartedResponse.Result> mGettingStartedResponseList;

    public CategoriesAdapter(ArrayList<GettingStartedResponse.Result> gettingStartedResponseList) {
        mGettingStartedResponseList = gettingStartedResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mGettingStartedResponseList != null && mGettingStartedResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mGettingStartedResponseList != null && mGettingStartedResponseList.size() > 0) {
            return mGettingStartedResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(ArrayList<GettingStartedResponse.Result> entryList) {
        mGettingStartedResponseList.addAll(entryList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onRepoEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.cover_image_view)
        ImageView coverImageView;

        @BindView(R.id.category_text_view)
        TextView categoryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            categoryTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final GettingStartedResponse.Result result = mGettingStartedResponseList.get(position);

            if (result.getArtworkUrl100() != null) {
                Glide.with(itemView.getContext())
                        .load(result.getArtworkUrl100())
                        .into(coverImageView);
            }

            if (result.getPrimaryGenreName() != null) {
                categoryTextView.setText(result.getPrimaryGenreName().toString());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (result != null)
                    {
                        /*Intent intent = new Intent(itemView.getContext(), DetalleActivity.class);
                        intent.putExtra(itemView.getContext().getString(R.string.item_url_image), entry.getImage().get(2).getLabel().toString());
                        intent.putExtra(itemView.getContext().getString(R.string.item_name), entry.getName().getLabel().toString());
                        intent.putExtra(itemView.getContext().getString(R.string.item_price), entry.getPrice().getAttributes().getAmount().toString());
                        intent.putExtra(itemView.getContext().getString(R.string.item_summary), entry.getSummary().getLabel().toString());
                        itemView.getContext().startActivity(intent);*/
                    }
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder
    {
        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
