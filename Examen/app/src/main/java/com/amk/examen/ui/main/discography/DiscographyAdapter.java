package com.amk.examen.ui.main.discography;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amk.examen.R;
import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.BaseViewHolder;
import com.amk.examen.ui.main.artist.ArtistAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andresaleman on 9/22/17.
 */

public class DiscographyAdapter extends RecyclerView.Adapter<BaseViewHolder>
{
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private DiscographyAdapter.Callback mCallback;
    private ArrayList<GettingStartedResponse.Result> mGettingStartedResponseList;

    public DiscographyAdapter(ArrayList<GettingStartedResponse.Result> gettingStartedResponseList) {
        mGettingStartedResponseList = gettingStartedResponseList;
    }

    public void setCallback(DiscographyAdapter.Callback callback) {
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
                return new DiscographyAdapter.ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discography, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new DiscographyAdapter.EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discography, parent, false));
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

        @BindView(R.id.artist_text_view)
        TextView artistTextView;

        @BindView(R.id.album_text_view)
        TextView albumTextView;

        @BindView(R.id.date_text_view)
        TextView dateTextView;

        @BindView(R.id.number_songs_text_view)
        TextView numberSongsTextView;

        @BindView(R.id.country_text_view)
        TextView countryTextView;

        @BindView(R.id.currency_text_view)
        TextView currencyTextView;

        @BindView(R.id.price_by_song_text_view)
        TextView priceBySongTextView;

        @BindView(R.id.price_text_view)
        TextView priceTextView;

        @BindView(R.id.streaming_text_view)
        TextView streamingTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            artistTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final GettingStartedResponse.Result result = mGettingStartedResponseList.get(position);

            if (result.getArtworkUrl100() != null) {
                Glide.with(itemView.getContext())
                        .load(result.getArtworkUrl100())
                        .into(coverImageView);
            }

            if (result.getArtistName() != null) {
                artistTextView.setText(result.getArtistName().toString());
            }

            if (result.getCollectionName() != null) {
                albumTextView.setText(result.getCollectionName().toString());
            }

            if (result.getReleaseDate() != null) {
                dateTextView.setText(result.getReleaseDate().toString());
            }

            if (result.getTrackCount() != null) {
                numberSongsTextView.setText(result.getTrackCount().toString());
            }

            if (result.getCollectionPrice() != 0) {
                priceTextView.setText(String.valueOf(result.getCollectionPrice()));
            }

            if (result.getTrackPrice() != 0) {
                priceBySongTextView.setText(String.valueOf(result.getTrackPrice()));
            }
            else
            {
                priceBySongTextView.setText("N/A");
            }

            if (result.getCountry() != null) {
                countryTextView.setText(result.getCountry().toString());
            }

            if (result.getCurrency() != null) {
                currencyTextView.setText(result.getCurrency().toString());
            }
            else
            {
                currencyTextView.setText("N/A");
            }

            if (result.getIsStreamable() != null) {
                streamingTextView.setText(result.getIsStreamable().toString());
            }
            else
            {
                streamingTextView.setText("N/A");
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (result != null)
                    {

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
