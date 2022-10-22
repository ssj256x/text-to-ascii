package org.texttoascii.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.texttoascii.fonts.AsciiCharacter;
import org.texttoascii.fonts.Font;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TextToAsciiService {

//    public static void main(String[] args) throws IOException {
//
//        String fileName = "src/main/resources/fonts/standard-font.yaml";
//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        objectMapper.findAndRegisterModules();
//        Font font = objectMapper.readValue(new File(fileName), Font.class);
//
//        List<AsciiCharacter> asciiCharacters = font.getAsciiCharacters();
//
//        String[][] characterList = new String[128][];
//
//        for(var character : asciiCharacters) {
//            characterList[character.getName()] = character.getText();
//        }
//        System.out.println(generate(characterList, "ssj256x@outlook.com"));
//    }

    public String generate(String[][] characterList, String toGenerate) {

        String[][] currentChars = new String[toGenerate.length()][];

        for(int i = 0; i < toGenerate.length(); i++) {
            currentChars[i] = characterList[toGenerate.charAt(i)];
        }

        StringBuilder sb = new StringBuilder();
        int rows = currentChars.length;
        int cols = currentChars[0].length;

        for (int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++){
                sb.append(currentChars[j][i]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
