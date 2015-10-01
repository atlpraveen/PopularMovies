package com.example.praveen.popularmovies;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by praveen on 24/07/15.
 */
public class MoviePojo implements Parcelable {

        private Boolean adult;
        @SerializedName("backdrop_path")
        private String backdropPath;
        @SerializedName("genre_ids")
        private List<Integer> genreIds = new ArrayList<Integer>();
        private Integer id;
        @SerializedName("original_language")
        private String originalLanguage;
        @SerializedName("original_title")
        private String originalTitle;
        private String overview;
        @SerializedName("release_date")
        private String releaseDate;
        @SerializedName("poster_path")
        private String posterPath;
        private Double popularity;
        private String title;
        private Boolean video;
        @SerializedName("vote_average")
        private Double voteAverage;
        @SerializedName("vote_count")
        private Integer voteCount;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public MoviePojo(Boolean adult, String backdropPath, List<Integer> genreIds, Integer id, String originalLanguage, String originalTitle, String overview, String releaseDate, String posterPath, Double popularity, String title, Boolean video, Double voteAverage, Integer voteCount, Map<String, Object> additionalProperties) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.additionalProperties = additionalProperties;
    }

    private MoviePojo(Parcel in) {
        adult = Boolean.valueOf(in.readString());
        backdropPath = in.readString();

        in.readList(genreIds,List.class.getClassLoader());
        id = Integer.valueOf(in.readInt());
        originalLanguage = in.readString();
        originalTitle = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        posterPath = in.readString();
        popularity = in.readDouble();
        title = in.readString();
        video = Boolean.valueOf(in.readString());
        voteAverage = in.readDouble();
        voteCount = Integer.valueOf(in.readInt());
        additionalProperties = in.readHashMap(Map.class.getClassLoader());

    }
    /**
         *
         * @return
         * The adult
         */
        public Boolean getAdult() {
            return adult;
        }

        /**
         *
         * @param adult
         * The adult
         */
        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        /**
         *
         * @return
         * The backdropPath
         */
        public String getBackdropPath() {
            return backdropPath;
        }

        /**
         *
         * @param backdropPath
         * The backdrop_path
         */
        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        /**
         *
         * @return
         * The genreIds
         */
        public List<Integer> getGenreIds() {
            return genreIds;
        }

        /**
         *
         * @param genreIds
         * The genre_ids
         */
        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        /**
         *
         * @return
         * The id
         */
        public Integer getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The originalLanguage
         */
        public String getOriginalLanguage() {
            return originalLanguage;
        }

        /**
         *
         * @param originalLanguage
         * The original_language
         */
        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        /**
         *
         * @return
         * The originalTitle
         */
        public String getOriginalTitle() {
            return originalTitle;
        }

        /**
         *
         * @param originalTitle
         * The original_title
         */
        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        /**
         *
         * @return
         * The overview
         */
        public String getOverview() {
            return overview;
        }

        /**
         *
         * @param overview
         * The overview
         */
        public void setOverview(String overview) {
            this.overview = overview;
        }

        /**
         *
         * @return
         * The releaseDate
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         *
         * @param releaseDate
         * The release_date
         */
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        /**
         *
         * @return
         * The posterPath
         */
        public String getPosterPath() {
            return posterPath;
        }

        /**
         *
         * @param posterPath
         * The poster_path
         */
        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        /**
         *
         * @return
         * The popularity
         */
        public Double getPopularity() {
            return popularity;
        }

        /**
         *
         * @param popularity
         * The popularity
         */
        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The video
         */
        public Boolean getVideo() {
            return video;
        }

        /**
         *
         * @param video
         * The video
         */
        public void setVideo(Boolean video) {
            this.video = video;
        }

        /**
         *
         * @return
         * The voteAverage
         */
        public Double getVoteAverage() {
            return voteAverage;
        }

        /**
         *
         * @param voteAverage
         * The vote_average
         */
        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        /**
         *
         * @return
         * The voteCount
         */
        public Integer getVoteCount() {
            return voteCount;
        }

        /**
         *
         * @param voteCount
         * The vote_count
         */
        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(Boolean.toString(adult));
        parcel.writeString(backdropPath);
        parcel.writeList(genreIds);
        parcel.writeInt(id);
        parcel.writeString(originalLanguage);
        parcel.writeString(originalTitle);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeString(posterPath);
        parcel.writeDouble(popularity);
        parcel.writeString(Boolean.toString(video));
        parcel.writeDouble(voteAverage.doubleValue());
        parcel.writeInt(voteCount);
        parcel.writeMap(additionalProperties);

    }

    public final Parcelable.Creator<MoviePojo> CREATOR = new Parcelable.Creator<MoviePojo>() {

        @Override
        public MoviePojo createFromParcel(Parcel parcel) {
            return new MoviePojo(parcel);
        }

        @Override
        public MoviePojo[] newArray(int size) {
            return new MoviePojo[size];
        }
    };
}
