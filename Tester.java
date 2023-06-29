package Sorting114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import BST114.Dictionary.BSTDictionary;
import heaps114.priorityQueue.MaxHeap;

public class Tester {

	public static void main(String[] args) {
		
		// test partition
		Integer[] randArr = new Integer[] {72, 6, 57, 88, 85, 42, 83, 73, 48, 52};
		
      System.out.print("The randArr array sorted is: ");
		partition(randArr, 50);
		for (Integer i : randArr) {
			System.out.print(i + " ");
		}

		Integer[] a = new Integer[] {7, 13, 26, 32};
		Integer[] b = new Integer[] {5, 6, 20, 30, 40};
		mergeSort(a,b);
      
      sortCards();
		
	}
	
	/** Print the sorted array*/
	public static void heapSort(Integer[] arr) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++){
			arrlist.add(i);
		}

		MaxHeap heap = new MaxHeap(arrlist);
		for (int i = 0; i < arrlist.size(); i++){
		}
			
	
	}
	
	/** Print the sorted array*/
	public static void BST(Integer[] arr){
		BSTDictionary bd = new BSTDictionary ();
		for (int i = 0; i < arr.length; i++){
			bd.insert(i);
		}
	}
	
	/** Merge 2 sorted arrays into one sorted array*/
	public static void mergeSort(Integer[] a, Integer[] b) {
		Integer[] result = new Integer[a.length + b.length];
		int k = 0;
		int i = 0;
		int j = 0;

		while ( i < a.length && j < b.length){
			if (a[i] < b[j]){
				result[k] = a[i];
				i++;
			}
			else{
				result[k] = b[j];
				j++;
			}
			k++;
		}

		while (i < a.length){
			result[k] = a[i];
			i++;
			k++;
		}
		while (j < b.length){
			result[k] = b[j];
			j++;
			k++;
		}
		System.out.println("\nThe merge sorted array is: " + Arrays.toString(result));
	}
	
	/**Partition array by last element*/
	public static void partition(Integer[] a, int pivot) {
		int i = 0;
		int j= 0;

		while ( i < a.length){
			if (a[i] > pivot){
				i++;
			}
			else if (a[i] <= pivot){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			}
		}
	}
   
	public static void sortCards() {
    ArrayList<Card> cards1 = new ArrayList<Card>();
    cards1.add(new Card(Rank.EIGHT, Suit.CLUBS));
    cards1.add(new Card(Rank.FIVE, Suit.DIAMONDS));
    cards1.add(new Card(Rank.EIGHT, Suit.HEARTS));
    cards1.add(new Card(Rank.ACE, Suit.SPADES));
    cards1.add(new Card(Rank.J, Suit.DIAMONDS));
    cards1.add(new Card(Rank.TWO, Suit.CLUBS));
    cards1.add(new Card(Rank.FOUR, Suit.HEARTS));
    cards1.add(new Card(Rank.FOUR, Suit.CLUBS));

    System.out.println("Before sorting:");
    for (Card c : cards1) {
        System.out.print(c + " ");
    }
    System.out.println();

    Collections.sort(cards1);

    System.out.println("After sorting:");
    for (Card c : cards1) {
        System.out.print(c + " ");
    }
    System.out.println();
   }
  
		
}
