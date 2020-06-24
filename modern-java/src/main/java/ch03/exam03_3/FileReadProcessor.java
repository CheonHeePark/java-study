package ch03.exam03_3;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface FileReadProcessor {
    String read(BufferedReader br) throws IOException;
}
