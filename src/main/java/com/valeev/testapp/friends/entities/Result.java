
package com.valeev.testapp.friends.entities;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("pregnancy_settings")
    @Expose
    private PregnancySettings pregnancySettings;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The login
     */
    public String getLogin() {
        return login;
    }

    /**
     * 
     * @param login
     *     The login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * @return
     *     The avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * 
     * @param avatar
     *     The avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * @return
     *     The locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * 
     * @param locality
     *     The locality
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * 
     * @return
     *     The pregnancySettings
     */
    public PregnancySettings getPregnancySettings() {
        return pregnancySettings;
    }

    /**
     * 
     * @param pregnancySettings
     *     The pregnancy_settings
     */
    public void setPregnancySettings(PregnancySettings pregnancySettings) {
        this.pregnancySettings = pregnancySettings;
    }

}
