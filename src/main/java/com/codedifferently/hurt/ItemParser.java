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

		for (String eachPair : base) {

			String[] keyValueSplit = eachPair.split(":");
			if (Arrays.stream(keyValueSplit).anyMatch(isEqual(key))){
				keyValuePair = eachPair;
			}
		}

		return keyValuePair;
	}
}