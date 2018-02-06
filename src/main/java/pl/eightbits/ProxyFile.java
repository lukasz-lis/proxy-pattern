package pl.eightbits;

import java.util.Optional;

public class ProxyFile  implements File {

    private static final int MAX_READ_COUNT = 2;
    private static final int MAX_WRITE_COUNT = 2;

    private final TextFile file;
    private long readCount;
    private long writeCount;

    public ProxyFile() {
        this.file = new TextFile();
        readCount = 0;
        writeCount = 0;
    }

    @Override
    public Optional<String> read() {
        if(readCount < MAX_READ_COUNT) {
            readCount++;
            return file.read();
        } else {
            System.out.println("Too many file attempts...");
            return Optional.empty();
        }
    }

    @Override
    public void write(String content) {
        if(writeCount < MAX_WRITE_COUNT) {
            writeCount++;
            file.write(content);
        } else {
            throw new RuntimeException("Write limit run out...");
        }
    }
}
