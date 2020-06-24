package ch03.exam03_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exam03 {
    /**
     * 파일을 라인별로 읽는 동작을 함수형 인터페이스로 구현하여 readLine을 추상화한다.
     * @param p 라인별로 파일을 읽는 동작을 구현한 인터페이스
     * @return
     * @throws IOException
     */
    public static String readLine(FileReadProcessor p) throws IOException {
        // try-resource 구문을 사용하면 close(); 를 명시적으로 호출하지 않아도됨
        // Closeable 인터페이스를 구현한 클래스만 사용 가능함 (BufferedReader -> Reader -> Closeable)
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input/ch03-03_data.txt"))) {
            return p.read(br);
        }
    }
}
