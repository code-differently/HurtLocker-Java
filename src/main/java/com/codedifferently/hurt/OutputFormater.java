package com.codedifferently.hurt;

import java.util.ArrayList;

public class OutputFormater {
		/*
		todo
		x after itemParser convert data to item
		x track key name for occurrence of similar values
		track key price for different price for each name
		x track errors by looking for null values
		report occurrences on each track
		output report with each name separated and errors reported last
		 */
	private ItemParser itemParser;
	private int errors = 0;
	private ArrayList<String> actualRawData;
	private ArrayList<Item> trimmedList;

	public OutputFormater(String data){
		this.itemParser = new ItemParser();
		actualRawData = itemParser.rawDataReader(data);
		trimmedList = trimList(actualRawData);

	}

	private ArrayList<Item> trimList(ArrayList<String> lineOfRawData){
		//deletes items with null after counted for
		ArrayList<Item> items = new ArrayList<>();
		lineOfRawData.forEach((line) ->{
			Item item = itemParser.convertStringToItem(line);
			if(item.getName() == null || item.getPrice() == null){
				errors++;
			}else items.add(item);
		});
		return items;
	}

	private String printLineValue(ArrayList<Item> finalData, String value){
		//keeps count of different price for each name
		String divider= "-------------";
		String divider2= "=============";
		int seenName = 0;
		String name = "";
		Integer firstPrices = 0;
		Integer secondPrice = 0;
		String price = "";
		String price2 = "";
		StringBuilder stringBuilder = new StringBuilder();

		for (Item item : finalData) {

			 if(item.getName().equalsIgnoreCase(value)){

				 if(item.getName().equalsIgnoreCase(value)){
					 if(name.isEmpty()|name.contains(item.getName())){
						 name = item.getName();
						 seenName++;
					 }
				 }

				if(price.isEmpty()|price.contains(item.getPrice())){
					price = item.getPrice();
					firstPrices++;
				}
				if(!price.isEmpty()&&!price.contains(item.getPrice())){
					price2 = item.getPrice();
					secondPrice++;
				}
			 }
		}
		stringBuilder.append("\nname: \t " + name + "\t\t " + "seen: " + seenName +" times\n" + divider2 +" \t \t " + divider2);
		stringBuilder.append("\nPrice: \t ").append(price).append("\t\t ").append("seen: ").append(firstPrices).append(" times\n").append(divider).append(" \t \t ").append(divider).append("\n");
		if(!price2.isEmpty()){
			stringBuilder.append("Price: \t ").append(price2).append("\t\t ").append("seen: ").append(secondPrice).append(" times\n").append(divider).append(" \t \t ").append(divider).append("\n");
		}
		return stringBuilder.toString();
	}


	public String report(){
		//report names seen, different prices for each name seen, and error
		String divider1 = "============= \t \t ";
		StringBuilder output = new StringBuilder();
		output.append(printLineValue(trimmedList,"milk"));
		output.append(printLineValue(trimmedList,"bread"));
		output.append(printLineValue(trimmedList,"cookies"));
		output.append(printLineValue(trimmedList,"apples"));
		output.append("\nErrors         \t \t "+ "seen: " + errors +" times");


		return output.toString();
	}

}
