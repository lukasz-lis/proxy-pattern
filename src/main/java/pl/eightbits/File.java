package pl.eightbits;

import java.util.Optional;

public interface File {

    Optional<String> read();
    void write(String content);
}
