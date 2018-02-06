package pl.eightbits;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProxyFileTest {

    @Test
    void returnLastEmptyWhenReadingTooManyTimes() {
        //given:
        ProxyFile proxyFile = new ProxyFile();
        //when:
        proxyFile.read();
        proxyFile.read();
        Optional<String> result = proxyFile.read();
        //then:
        assertFalse(result.isPresent());
    }

    @Test
    void thrownExceptionWhenWritingTooManyTimes() {
        //given:
        ProxyFile proxyFile = new ProxyFile();
        //when:
        proxyFile.write("content");
        proxyFile.write("content");
        Executable executable = () -> proxyFile.write("content");
        //then:
        assertThrows(RuntimeException.class, executable);
    }
}