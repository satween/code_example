
package com.valeev.testapp.friends.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class UserInfo {

    @SerializedName("result")
    @Expose
    private List<Result> result = new ArrayList<Result>();
    @SerializedName("scroll_id")
    @Expose
    private String scrollId;

    /**
     * @return The result
     */
    public List<Result> getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    public void setResult(List<Result> result) {
        this.result = result;
    }

    /**
     * @return The scrollId
     */
    public String getScrollId() {
        return scrollId;
    }

    /**
     * @param scrollId The scroll_id
     */
    public void setScrollId(String scrollId) {
        this.scrollId = scrollId;
    }

}
