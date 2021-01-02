package com.codedifferently.hurt;


public class ItemParser {

	public Item convertStringToItem(String keyValuePair){
		/*
		1.get each value
		2.insert value into Item object
		 */
		return null;
	}

	public String findValueByKey(String key, String data){
		/*
		1.use data to find the key by matching value in data
		2.when matched return non alter form of value and key
		 */

		//replace non related special character as spaces
		data = data.replaceAll("[^A-Za-z0-9#/:.]"," ");
		String[] base = data.split("\\s");
		String keyValuePair = "";
		for (String eachPair : base) {
			//separate key from value
			String[] pairSplit = eachPair.split(":");
			//grab each key
			String currentPair = pairSplit[0];
			//compare key to this key
			if(key.equalsIgnoreCase(currentPair)){
				keyValuePair=eachPair;
			}
		}

		return keyValuePair;
	}
}