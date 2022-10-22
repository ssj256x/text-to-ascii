package org.texttoascii.fonts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Font {
    @JsonProperty("name")
    private String name;
    @JsonProperty("onlyUpperCase")
    private boolean onlyUpperCase;
    @JsonProperty("characters")
    private List<AsciiCharacter> asciiCharacters;
}
