package type.many.extend.pakage.appdemo.data.model;

/**
 * Created by User on 2020/5/4.
 */

import com.google.gson.annotations.SerializedName;

/**
 * 縮圖資料模型
 * "albumId": 1,
 "id": 3,
 "title": "officia porro iure quia iusto qui ipsa ut modi",
 "url": "https://via.placeholder.com/600/24f355",
 "thumbnailUrl": "https://via.placeholder.com/150/24f355"
 */
public class PhotoDetail {

    //相簿ID
    @SerializedName("albumId")
    private String mAlbumID = "";

    public String getAlbumID() {
        return mAlbumID;
    }

    public void setAlbumID(String albumID) {
        mAlbumID = albumID;
    }

    //ID編號
    @SerializedName("id")
    private String mID = "";

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    //名稱
    @SerializedName("title")
    private String mTitle = "";

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    //圖片連結
    @SerializedName("url")
    private String mUrl = "";

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    //縮圖連結
    @SerializedName("thumbnailUrl")
    private String mThumbnailUrl = "";

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        mThumbnailUrl = thumbnailUrl;
    }
}
