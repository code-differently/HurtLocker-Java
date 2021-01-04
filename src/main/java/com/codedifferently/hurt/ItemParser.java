package com.codedifferently.hurt;


import java.util.ArrayList;
import java.util.HashMap;

public class ItemParser extends DataReader {
	private ArrayList<String > listOfKey;

	public ItemParser(){
		listOfKey = new ArrayList<>();
		listOfKey.add("name");
		listOfKey.add("price");
		listOfKey.add("item");
		listOfKey.add("expiration");
	}

	public Item convertStringToItem(String keyValuePairs) {
		/*
		1.get each value
		2.insert value into Item object
		3.store error if value is null
		 */
		HashMap<String,String> itemData = new HashMap<>();

			for (String key:listOfKey) {
				String value = findValueByKey(key,keyValuePairs);
				itemData.put(key,value);
			}

			return new Item(itemData);
	}

	public String findValueByKey(String key, String data){
		/*
		1.use data to find the key by matching value in data
		2.when matched return non alter form of value and key
		 */

		//replace non related special character as spaces
		data = data.replaceAll("[^A-Za-z0-9#/:.]"," ");
		String[] base = data.split("\\s");
		String value = null;
		for (String eachPair : base) {
			//separate key from value
			String[] pairSplit = eachPair.split(":");
			//grab each key
			String currentPair = pairSplit[0];
			//compare key to this key and throw exception when value is not present
			try{
				if(key.equalsIgnoreCase(currentPair)){
					if(pairSplit.length < 2) throw new ItemParserMissingValueException();
					value = pairSplit[1];
				}
			}catch (ItemParserMissingValueException valueException){
				valueException.printStackTrace();
				return value;
			}
		}
		return value;
	}
}