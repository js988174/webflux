package com.example.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FunctionalProgrammingTest {

    @Test
    public void produceOneToNine() {
        List<Integer> sink = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sink.add(i);
        }

            for (int i = 0; i <= 0; i++) {
                System.out.println(sink.get(i));
            }
    }
}
