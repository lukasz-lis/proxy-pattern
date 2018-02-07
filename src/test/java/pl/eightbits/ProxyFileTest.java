package pl.eightbits;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProxyFileTest {

    @Test
    void returnLastEmptyOnReadingTooManyTimes() {
        //given:
        ProxyFile proxyFile = new ProxyFile();
        proxyFile.read();
        proxyFile.read();
        //when:
        Optional<String> result = proxyFile.read();
        //then:
        assertFalse(result.isPresent());
    }

    @Test
    void throwExceptionOnWritingTooManyTimes() {
        //given:
        ProxyFile proxyFile = new ProxyFile();
        proxyFile.write("content");
        proxyFile.write("content");
        //when:
        Executable executable = () -> proxyFile.write("content");
        //then:
        assertThrows(RuntimeException.class, executable);
    }
}