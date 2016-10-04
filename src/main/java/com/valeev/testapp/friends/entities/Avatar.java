
package com.valeev.testapp.friends.entities;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Avatar {

    @SerializedName("full_url")
    @Expose
    private String fullUrl;
    @SerializedName("thumb_url")
    @Expose
    private String thumbUrl;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;

    /**
     * 
     * @return
     *     The fullUrl
     */
    public String getFullUrl() {
        return fullUrl;
    }

    /**
     * 
     * @param fullUrl
     *     The full_url
     */
    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    /**
     * 
     * @return
     *     The thumbUrl
     */
    public String getThumbUrl() {
        return thumbUrl;
    }

    /**
     * 
     * @param thumbUrl
     *     The thumb_url
     */
    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

}
