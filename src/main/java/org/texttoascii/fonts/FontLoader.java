package org.texttoascii.fonts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FontLoader {

    private final String basePath = "src/main/resources/fonts/standard-font.yaml/";
    private final String defaultFont = "standard-font.yaml";

    public String[][] loadFontFile() throws IOException {
        String fileName = basePath + defaultFont;
        String yaml = new String(Files.readAllBytes(Paths.get("D:\\Codebase\\text-to-ascii\\src\\main\\resources\\fonts\\standard-font.yaml")));
        return loadFont(yaml);
    }

    private String[][] loadFont(String yaml) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        Font font;

        font = objectMapper.readValue(yaml, Font.class);
        List<AsciiCharacter> asciiCharacters = font.getAsciiCharacters();
        String[][] characterList = new String[128][];
        for (var character : asciiCharacters) {
            characterList[character.getName()] = character.getText();
        }
        return characterList;
    }
}
