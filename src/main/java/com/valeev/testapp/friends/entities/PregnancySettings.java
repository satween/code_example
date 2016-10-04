
package com.valeev.testapp.friends.entities;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PregnancySettings {

    @SerializedName("pregnancy")
    @Expose
    private Integer pregnancy;

    /**
     * 
     * @return
     *     The pregnancy
     */
    public Integer getPregnancy() {
        return pregnancy;
    }

    /**
     * 
     * @param pregnancy
     *     The pregnancy
     */
    public void setPregnancy(Integer pregnancy) {
        this.pregnancy = pregnancy;
    }

}
