package com.codedifferently.hurt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataParserTest {
    DataParser dataParser;
    String rawData;
    Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
        rawData = main.readRawDataToString();
    }

    @Test
    public void parse() {
        dataParser =  new DataParser();
        dataParser.parse(rawData);
    }

    @Test
    public void createData() {
    }
}