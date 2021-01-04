package com.codedifferently.hurt;


import java.util.ArrayList;
import java.util.HashMap;

public class ItemParser extends DataReader {
	private ArrayList<String > listOfKey;
	private Item item;

	public ItemParser(){
		listOfKey = new ArrayList<>();
		listOfKey.add("name");
		listOfKey.add("price");
		listOfKey.add("type");
		listOfKey.add("expiration");
	}

	public Item convertStringToItem(String data) {
		/*
		1.get each value
		2.insert value into Item object
		3.store error if value is null
		 */
		HashMap<String,String> itemData = new HashMap<>();

			for (String key:listOfKey) {
				String valueByKey = findValueByKey(key,data);
				itemData.put(key,valueByKey);
			}

			return this.item = new Item(itemData);
	}

	public String findValueByKey(String key, String data){
		/*
		1.use data to find the key by matching value in data
		2.when matched return non alter form of value and key
		 */

		//replace non related special character as spaces
		data = data.replaceAll("[^A-Za-z0-9#/:.]"," ");
		String[] base = data.split("\\s");
		String value = " ";
		for (String eachPair : base) {
			//separate key from value
			String[] pairSplit = eachPair.split(":");
			//grab each key
			String currentPair = pairSplit[0];

			//compare key to this key and throw exception when value is not present
			if(key.equalsIgnoreCase(currentPair)){
				try{
					boolean isNotEmptyValue = pairSplit.length == 2;
					if(isNotEmptyValue) {
						value = pairSplit[1];
						value = value.substring(0,1).toUpperCase()
								+ value.substring(1).toLowerCase();
						if(value.matches("(?i)c..kies")){
							value = value.replace("0","o");
						}
					}
					else throw new ItemParserMissingValueException();
					}
				catch (ItemParserMissingValueException valueException){
					value = null;
					System.err.println( currentPair +" is " + null);
					valueException.printStackTrace();
				}
			}
		}
		return value;
	}
}