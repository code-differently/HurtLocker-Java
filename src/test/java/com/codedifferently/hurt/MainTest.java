package com.codedifferently.hurt;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    @Test
    public void testCleanItUp() throws Exception {
        Map<String, Integer> itemMap = new HashMap<>();
        String result = new Main().readRawDataToString();
        String[] s = new Main().cleanItUp(result);

    }
}

