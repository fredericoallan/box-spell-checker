
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
    "ext",
    "path",
    "files",
    "regex"
})
public class Extension {

    @JsonProperty("ext")
    private String ext;
    @JsonProperty("path")
    private String path;
    @JsonProperty("files")
    @Valid
    private List<String> files = new ArrayList<String>();
    @JsonProperty("regex")
    @Valid
    private Regex regex;

    /**
     * 
     * @return
     *     The ext
     */
    @JsonProperty("ext")
    public String getExt() {
        return ext;
    }

    /**
     * 
     * @param ext
     *     The ext
     */
    @JsonProperty("ext")
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * 
     * @return
     *     The path
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 
     * @return
     *     The files
     */
    @JsonProperty("files")
    public List<String> getFiles() {
        return files;
    }

    /**
     * 
     * @param files
     *     The files
     */
    @JsonProperty("files")
    public void setFiles(List<String> files) {
        this.files = files;
    }

    /**
     * 
     * @return
     *     The regex
     */
    @JsonProperty("regex")
    public Regex getRegex() {
        return regex;
    }

    /**
     * 
     * @param regex
     *     The regex
     */
    @JsonProperty("regex")
    public void setRegex(Regex regex) {
        this.regex = regex;
    }

}
