
package br.com.softbox.boxspellchecker.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "dicionario"
})
public class Dictionary {

    @JsonProperty("dicionario")
    private List<String> dicionario = new ArrayList<String>();

    /**
     * 
     * @return
     *     The dicionario
     */
    @JsonProperty("dicionario")
    public List<String> getDicionario() {
        return dicionario;
    }

    /**
     * 
     * @param dicionario
     *     The dicionario
     */
    @JsonProperty("dicionario")
    public void setDicionario(List<String> dicionario) {
        this.dicionario = dicionario;
    }

}
