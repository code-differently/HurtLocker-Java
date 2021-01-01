package com.codedifferently.hurt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {

	public ArrayList<String> rawDataReader(String data){
		String[] dataArray = data.split("##");
		ArrayList<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
		return  dataList;
	}


}
