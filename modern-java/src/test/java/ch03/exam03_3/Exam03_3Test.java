package ch03.exam03_3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class Exam03_3Test {
    @Test
    public void 한번에_1줄씩_읽기() throws IOException {
        String readText = Exam03.readLine((BufferedReader br) -> br.readLine());
        System.out.println("1줄 읽기: " + readText);
    }

    @Test
    public void 한번에_2줄씩_읽기() throws IOException {
        String readText = Exam03.readLine((BufferedReader br) -> br.readLine() + " " + br.readLine());
        System.out.println("2줄 읽기: " + readText);
    }
}
