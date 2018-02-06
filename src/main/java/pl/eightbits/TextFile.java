package pl.eightbits;

import java.util.Optional;

import static java.lang.String.format;

public class TextFile implements File {


    @Override
    public Optional<String> read() {
        return Optional.of("content");
    }

    @Override
    public void write(String content) {
        System.out.println(format("Writing file content: %s", content));
    }
}
