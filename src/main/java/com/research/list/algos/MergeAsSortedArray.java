package com.research.list.algos;


public class MergeAsSortedArray {
	
	static Integer[] firstList = {1,2,2,4,5,12,12,23,63,65,235,624};
	static Integer[] secondList = {2,3,5,6,7,22,23,24,52,66,67,68,77,78,89,98};
	
	public static void main(String[] args) {
		merge2ArraysAsSortedArray();
		mergeArraysAsSortedArray();
	}
	
	public static void merge2ArraysAsSortedArray() {
		Integer[] resultList = new Integer[firstList.length+secondList.length];
		int i=0, j=0, k=0;
		
		while (i<firstList.length && j < secondList.length) {
			if(firstList[i] <= secondList[j]){
				resultList[k++] = firstList[i++];
			} else {
				resultList[k++] = secondList[j++];
			}
		}
		
		while (i<firstList.length) {
			resultList[k++] = firstList[i++];
		}
		
		while (j<secondList.length) {
			resultList[k++] = secondList[j++];
		}
		
		printList(resultList);
	}

	public static void printList(Integer[] list){
		for (Integer integer : list) {
			System.out.printf("%d ",integer);
		}
		System.out.printf("%n");
	}

	public static void mergeArraysAsSortedArray() {
		Integer[] resultList = new Integer[firstList.length+secondList.length];
		int i=firstList.length-1, j=secondList.length-1, k=resultList.length;
		
		while(k > 0){
			resultList[--k] = (j<0 || (i>=0 && firstList[i] >= secondList[j])) ? firstList[i--]: secondList[j--];
		}
		
		printList(resultList);
	}
	
}
