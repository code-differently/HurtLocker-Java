package com.codedifferently.hurt.DataHandler;

import com.codedifferently.hurt.DataHandler.Interfaces.IDataParser;
import com.codedifferently.hurt.DataHandler.Interfaces.IFileCreator;
import com.codedifferently.hurt.DataHandler.Interfaces.IRawDataParser;

import java.util.List;

// Container for objects that handle parsing raw data, parsing the class data, and printing output files.
public class DataHandler {

    private IRawDataParser rawDataParser;
    private IDataParser dataParser;
    private IFileCreator fileCreator;

    // Automatically instantiates a class for each JSON object.
    public DataHandler(String rawData) {
        rawDataParser = new RawDataParser();
        List<Data> dataList = rawDataParser.convertJSONToObjects(rawData);
        dataParser = new DataParser(dataList);
        fileCreator = new FileCreator(dataParser, rawDataParser);
    }

    public boolean printDataToFile() {
        return fileCreator.createLogFile();
    }

    public List<Data> getData() {
        return dataParser.getData();
    }

    public IDataParser getDataParser() {
        return dataParser;
    }

    public IFileCreator getFileCreator() {
        return fileCreator;
    }
}
