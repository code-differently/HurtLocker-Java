package com.codedifferently.hurt;


import java.util.ArrayList;
import java.util.List;

public class ItemParser {
    private RawDataProvider rawDataProvider;
    String normalizedData;
    String[] itemEntries;
    public List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public ItemParser(){
        rawDataProvider = new RawDataProvider();
        items = new ArrayList<>();
        initializeData();
        parseItems();
    }
    private void initializeData(){
            String rawData = rawDataProvider.readRawDataToString();
            String cleanData = rawData.replaceAll("\\^|\\*|@|%|!", ";");
            itemEntries = cleanData.split("##");
    }
    private void parseItems(){
        for(String unparsedItem : itemEntries){
            try {
                items.add(parseItem(unparsedItem));
            } catch (Exception e){
                ErrorCounter.getInstance().incrementErrorCount();
            }
        }
        System.out.println("errors " + ErrorCounter.getInstance().getErrorCount());
    }
    private Item parseItem(String unparsedItem) throws Exception{

       String[] itemFields = unparsedItem.split(";");
        for(String field: itemFields){
           String[] keyValue = field.split(":");
           if(keyValue.length < 2){
               throw new Exception();
           }
        }

        // CREATE ITEM AND RETURN
        return null;
    };

}
