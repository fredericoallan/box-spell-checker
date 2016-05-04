
package br.com.softbox.boxspellchecker.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "exp",
    "group"
})
public class Regex {

    @JsonProperty("exp")
    @Valid
    private List<String> exp = new ArrayList<String>();
    @JsonProperty("group")
    private Integer group;

    /**
     * 
     * @return
     *     The exp
     */
    @JsonProperty("exp")
    public List<String> getExp() {
        return exp;
    }

    /**
     * 
     * @param exp
     *     The exp
     */
    @JsonProperty("exp")
    public void setExp(List<String> exp) {
        this.exp = exp;
    }
    
    /**
     * 
     * @return
     *     The group
     */
    @JsonProperty("group")
    public Integer getGroup() {
        return group;
    }

    /**
     * 
     * @param group
     *     The group
     */
    @JsonProperty("group")
    public void setGroup(Integer group) {
        this.group = group;
    }
    

}
