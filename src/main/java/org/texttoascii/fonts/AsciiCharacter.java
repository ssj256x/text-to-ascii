package org.texttoascii.fonts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AsciiCharacter {
    @JsonProperty("name")
    private char name;
    @JsonProperty("text")
    private String[] text;
}
