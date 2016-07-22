package com.research.list.algos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPair {
	static Integer[] intList = {-4,5,1,3,-2};
	static Integer sum = 1;

	public static void main(String[] args) {
		findPairs();
		findPairsWithSet();
		findPairsWithSorting();
	}
	
	public static void findPairs(){
		for (int i=0;i<intList.length;i++) {
			for (int j=i+1;j<intList.length;j++) {
				if(sum.equals(intList[i]+intList[j])){
					System.out.printf("(%d, %d) %n",intList[j],intList[i]);
				}
			}
		}
		System.out.println("");
	}
	
	public static void findPairsWithSet(){
		Set<Integer> set = new HashSet<Integer>(intList.length);

		for (int i=0;i<intList.length;i++) {
			Integer target = sum - intList[i];
			if(set.contains(target)){
				System.out.printf("(%d, %d) %n",intList[i],target);
			} else{
				set.add(intList[i]);
			}
		}
		System.out.println("");
	}
	
	public static void findPairsWithSorting(){
		Arrays.sort(intList);
		int left=0;
		int right = intList.length -1;
		while(left < right){
			Integer addition = intList[left] + intList[right];
			if(addition.equals(sum)){
				System.out.printf("(%d, %d) %n",intList[left],intList[right]);
				left++;
				right--;
			} else if(addition.compareTo(sum) <0){
				left++;
			} else {
				right-- ;
			}
				
		}
	}

}
