package com.research.list.algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostOccuredElement {
	
	static Integer[] intList = {5,21,21,3,4,5,5,3,6,7,65,5,21,21,21,4,4,4,4,4,4,4,4,4,4};
	
	public static void main(String[] args) {
		mostOccurentElementByMap();
		//mostOccurentElement();
	}
	
	public static void mostOccurentElement(){
		Integer mostOccurentElement=0;
		Integer mostOccurences = 0;
		for (Integer number : intList) {
			int count = 0;
			for (Integer number2 : intList) {
				if(number.equals(number2)){
					count++;
				} 
			}
			if(count > mostOccurences){
				mostOccurences = count;
				mostOccurentElement = number;
			}
		}
		System.out.println("Most Occured element = "+mostOccurentElement+" Most occurnces are : "+mostOccurences);
	}
	
	
	public static void mostOccurentElementByMap(){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer mostOccurentElement=0;
		Integer mostOccurences = 0;
		
		for (Integer number : intList) {
			if(map.containsKey(number)){
				Integer integer = map.get(number);
				map.put(number, integer+1);
			} else {
				map.put(number, 1);
			}
		}
		
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if(mostOccurences < entry.getValue()){
				mostOccurences = entry.getValue();
				mostOccurentElement = entry.getKey();
			}
		}
		
		System.out.println("Most Occured element = "+mostOccurentElement+" Most occurnces are : "+mostOccurences);
	}

}
