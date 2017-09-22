package com.amk.examen.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by andresaleman on 9/21/17.
 */

public class GettingStartedResponse
{
    @Expose
    @SerializedName("resultCount")
    private long resultCount;
    @Expose
    @SerializedName("results")
    private ArrayList<Result> results;

    public long getResultCount() { return resultCount; }
    public void setResultCount(long value) { this.resultCount = value; }

    public ArrayList<Result> getResults() { return results; }
    public void setResults(ArrayList<Result> value) { this.results = value; }

    public class Result {
        @Expose
        @SerializedName("collectionViewUrl")
        private String collectionViewUrl;
        @Expose
        @SerializedName("collectionArtistName")
        private String collectionArtistName;
        @Expose
        @SerializedName("artworkUrl100")
        private String artworkUrl100;
        @Expose
        @SerializedName("artistName")
        private String artistName;
        @Expose
        @SerializedName("artistId")
        private Long artistId;
        @Expose
        @SerializedName("artistViewUrl")
        private String artistViewUrl;
        @Expose
        @SerializedName("artworkUrl60")
        private String artworkUrl60;
        @Expose
        @SerializedName("artworkUrl30")
        private String artworkUrl30;
        @Expose
        @SerializedName("collectionArtistId")
        private Long collectionArtistId;
        @Expose
        @SerializedName("collectionHdPrice")
        private Double collectionHdPrice;
        @Expose
        @SerializedName("collectionCensoredName")
        private String collectionCensoredName;
        @Expose
        @SerializedName("collectionArtistViewUrl")
        private String collectionArtistViewUrl;
        @Expose
        @SerializedName("collectionExplicitness")
        private String collectionExplicitness;
        @Expose
        @SerializedName("collectionName")
        private String collectionName;
        @Expose
        @SerializedName("collectionId")
        private Long collectionId;
        @Expose
        @SerializedName("collectionPrice")
        private double collectionPrice;
        @Expose
        @SerializedName("kind")
        private String kind;
        @Expose
        @SerializedName("trackExplicitness")
        private String trackExplicitness;
        @Expose
        @SerializedName("discCount")
        private Long discCount;
        @Expose
        @SerializedName("country")
        private String country;
        @Expose
        @SerializedName("contentAdvisoryRating")
        private String contentAdvisoryRating;
        @Expose
        @SerializedName("currency")
        private String currency;
        @Expose
        @SerializedName("hasITunesExtras")
        private Boolean hasITunesExtras;
        @Expose
        @SerializedName("discNumber")
        private Long discNumber;
        @Expose
        @SerializedName("isStreamable")
        private Boolean isStreamable;
        @Expose
        @SerializedName("releaseDate")
        private String releaseDate;
        @Expose
        @SerializedName("previewUrl")
        private String previewUrl;
        @Expose
        @SerializedName("longDescription")
        private String longDescription;
        @Expose
        @SerializedName("primaryGenreName")
        private String primaryGenreName;
        @Expose
        @SerializedName("trackCensoredName")
        private String trackCensoredName;
        @Expose
        @SerializedName("shortDescription")
        private String shortDescription;
        @Expose
        @SerializedName("trackCount")
        private Long trackCount;
        @Expose
        @SerializedName("trackName")
        private String trackName;
        @Expose
        @SerializedName("trackHdRentalPrice")
        private Double trackHdRentalPrice;
        @Expose
        @SerializedName("trackHdPrice")
        private Double trackHdPrice;
        @Expose
        @SerializedName("trackId")
        private long trackId;
        @Expose
        @SerializedName("trackPrice")
        private double trackPrice;
        @Expose
        @SerializedName("trackTimeMillis")
        private long trackTimeMillis;
        @Expose
        @SerializedName("trackNumber")
        private Long trackNumber;
        @Expose
        @SerializedName("trackRentalPrice")
        private Double trackRentalPrice;
        @Expose
        @SerializedName("trackViewUrl")
        private String trackViewUrl;
        @Expose
        @SerializedName("wrapperType")
        private String wrapperType;

        public String getCollectionViewUrl() { return collectionViewUrl; }
        public void setCollectionViewUrl(String value) { this.collectionViewUrl = value; }

        public String getCollectionArtistName() { return collectionArtistName; }
        public void setCollectionArtistName(String value) { this.collectionArtistName = value; }

        public String getArtworkUrl100() { return artworkUrl100; }
        public void setArtworkUrl100(String value) { this.artworkUrl100 = value; }

        public String getArtistName() { return artistName; }
        public void setArtistName(String value) { this.artistName = value; }

        public Long getArtistId() { return artistId; }
        public void setArtistId(Long value) { this.artistId = value; }

        public String getArtistViewUrl() { return artistViewUrl; }
        public void setArtistViewUrl(String value) { this.artistViewUrl = value; }

        public String getArtworkUrl60() { return artworkUrl60; }
        public void setArtworkUrl60(String value) { this.artworkUrl60 = value; }

        public String getArtworkUrl30() { return artworkUrl30; }
        public void setArtworkUrl30(String value) { this.artworkUrl30 = value; }

        public Long getCollectionArtistId() { return collectionArtistId; }
        public void setCollectionArtistId(Long value) { this.collectionArtistId = value; }

        public Double getCollectionHdPrice() { return collectionHdPrice; }
        public void setCollectionHdPrice(Double value) { this.collectionHdPrice = value; }

        public String getCollectionCensoredName() { return collectionCensoredName; }
        public void setCollectionCensoredName(String value) { this.collectionCensoredName = value; }

        public String getCollectionArtistViewUrl() { return collectionArtistViewUrl; }
        public void setCollectionArtistViewUrl(String value) { this.collectionArtistViewUrl = value; }

        public String getCollectionExplicitness() { return collectionExplicitness; }
        public void setCollectionExplicitness(String value) { this.collectionExplicitness = value; }

        public String getCollectionName() { return collectionName; }
        public void setCollectionName(String value) { this.collectionName = value; }

        public Long getCollectionId() { return collectionId; }
        public void setCollectionId(Long value) { this.collectionId = value; }

        public double getCollectionPrice() { return collectionPrice; }
        public void setCollectionPrice(double value) { this.collectionPrice = value; }

        public String getKind() { return kind; }
        public void setKind(String value) { this.kind = value; }

        public String getTrackExplicitness() { return trackExplicitness; }
        public void setTrackExplicitness(String value) { this.trackExplicitness = value; }

        public Long getDiscCount() { return discCount; }
        public void setDiscCount(Long value) { this.discCount = value; }

        public String getCountry() { return country; }
        public void setCountry(String value) { this.country = value; }

        public String getContentAdvisoryRating() { return contentAdvisoryRating; }
        public void setContentAdvisoryRating(String value) { this.contentAdvisoryRating = value; }

        public String getCurrency() { return currency; }
        public void setCurrency(String value) { this.currency = value; }

        public Boolean getHasITunesExtras() { return hasITunesExtras; }
        public void setHasITunesExtras(Boolean value) { this.hasITunesExtras = value; }

        public Long getDiscNumber() { return discNumber; }
        public void setDiscNumber(Long value) { this.discNumber = value; }

        public Boolean getIsStreamable() { return isStreamable; }
        public void setIsStreamable(Boolean value) { this.isStreamable = value; }

        public String getReleaseDate() { return releaseDate; }
        public void setReleaseDate(String value) { this.releaseDate = value; }

        public String getPreviewUrl() { return previewUrl; }
        public void setPreviewUrl(String value) { this.previewUrl = value; }

        public String getLongDescription() { return longDescription; }
        public void setLongDescription(String value) { this.longDescription = value; }

        public String getPrimaryGenreName() { return primaryGenreName; }
        public void setPrimaryGenreName(String value) { this.primaryGenreName = value; }

        public String getTrackCensoredName() { return trackCensoredName; }
        public void setTrackCensoredName(String value) { this.trackCensoredName = value; }

        public String getShortDescription() { return shortDescription; }
        public void setShortDescription(String value) { this.shortDescription = value; }

        public Long getTrackCount() { return trackCount; }
        public void setTrackCount(Long value) { this.trackCount = value; }

        public String getTrackName() { return trackName; }
        public void setTrackName(String value) { this.trackName = value; }

        public Double getTrackHdRentalPrice() { return trackHdRentalPrice; }
        public void setTrackHdRentalPrice(Double value) { this.trackHdRentalPrice = value; }

        public Double getTrackHdPrice() { return trackHdPrice; }
        public void setTrackHdPrice(Double value) { this.trackHdPrice = value; }

        public long getTrackId() { return trackId; }
        public void setTrackId(long value) { this.trackId = value; }

        public double getTrackPrice() { return trackPrice; }
        public void setTrackPrice(double value) { this.trackPrice = value; }

        public long getTrackTimeMillis() { return trackTimeMillis; }
        public void setTrackTimeMillis(long value) { this.trackTimeMillis = value; }

        public Long getTrackNumber() { return trackNumber; }
        public void setTrackNumber(Long value) { this.trackNumber = value; }

        public Double getTrackRentalPrice() { return trackRentalPrice; }
        public void setTrackRentalPrice(Double value) { this.trackRentalPrice = value; }

        public String getTrackViewUrl() { return trackViewUrl; }
        public void setTrackViewUrl(String value) { this.trackViewUrl = value; }

        public String getWrapperType() { return wrapperType; }
        public void setWrapperType(String value) { this.wrapperType = value; }
    }
}
