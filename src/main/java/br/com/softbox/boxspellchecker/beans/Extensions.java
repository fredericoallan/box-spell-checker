
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
    "extensions",
    "dictionaryFile"
})
public class Extensions {

    @JsonProperty("extensions")
    @Valid
    private List<Extension> extensions = new ArrayList<Extension>();
    @JsonProperty("dictionaryFile")
    private String dictionaryFile;

    /**
     * 
     * @return
     *     The extensions
     */
    @JsonProperty("extensions")
    public List<Extension> getExtensions() {
        return extensions;
    }

    /**
     * 
     * @param extensions
     *     The extensions
     */
    @JsonProperty("extensions")
    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }

    /**
     * 
     * @return
     *     The dictionaryFile
     */
    @JsonProperty("dictionaryFile")
    public String getDictionaryFile() {
        return dictionaryFile;
    }

    /**
     * 
     * @param dictionaryFile
     *     The dictionaryFile
     */
    @JsonProperty("dictionaryFile")
    public void setDictionaryFile(String dictionaryFile) {
        this.dictionaryFile = dictionaryFile;
    }

}
