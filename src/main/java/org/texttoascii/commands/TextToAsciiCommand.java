package org.texttoascii.commands;

import org.texttoascii.fonts.FontLoader;
import org.texttoascii.service.TextToAsciiService;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "t2a", version = "1.0", mixinStandardHelpOptions = true)
public class TextToAsciiCommand implements Runnable {

    @CommandLine.Option(names = {"-f", "--font"}, description = "The name of the font")
    String fontType;

    @CommandLine.Option(names = {"-ff", "--font-file"}, description = "Yaml for Font Declarations")
    String fontFilePath;
    @CommandLine.Option(names = {"-t", "--text"}, description = "The text to ascii-fy", required = true)
    String text;

    @CommandLine.Option(names = {"--fitted"}, description = "Smushes with letters together")
    boolean fitted;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new TextToAsciiCommand()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        FontLoader fontLoader = new FontLoader();
        TextToAsciiService textToAsciiService = new TextToAsciiService();
        try {
            System.out.println(textToAsciiService.generate(fontLoader.loadFontFile(), text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
