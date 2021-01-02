package com.codedifferently.hurt;

import java.util.Arrays;

import static java.util.function.Predicate.isEqual;

public class ItemParser {

	public Item convertStringToItem(String data){
		return null;
	}

	public String findValueByKey(String key, String data){
		/*
		1.use data to find the key by matching value in data
		2.when matched return string of value and key
		 */
		String[] base = data.split("[^0-9a-zA-Z-#-:./]");
		String keyValuePair = "";
		int counter = 0;

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