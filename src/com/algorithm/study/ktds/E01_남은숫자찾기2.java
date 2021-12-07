package com.algorithm.study.ktds;

import java.util.ArrayList;
import java.util.Collections;

public class E01_남은숫자찾기2 {
	public static void main(String[] args) {
		ArrayList<Integer> itemList = items();
		ArrayList<Integer> selectedItemList = selectedItemLists(itemList);

		// 남은 숫자 찾기 버전 1 : n^2 : 첫 for문 100번 * 둘째 for문 99번=9900번
		for (int i = 0; i < itemList.size(); i++) { // 100번
			boolean isMatched = false;
			for (int j = 0; j < selectedItemList.size(); j++) { // 99번
				if(itemList.get(i) == selectedItemList.get(j)) {
					isMatched = true;
					break;
				}
			}// for 2
			System.out.println("i="+ i + ", isMatched=" + isMatched);
			if(!isMatched) { // 다른 것 찾기
				System.out.println("남은 수 찾기 버전 1, 답은=" + itemList.get(i));
				break;
			}
		}// for 1
		
	}// main

	private static ArrayList<Integer> selectedItemLists(ArrayList<Integer> itemList) {
		ArrayList<Integer> selectedItemList = new ArrayList<Integer>();
		for (int i = 0; i < itemList.size(); i++) {
			selectedItemList.add(itemList.get(i));
		}
		Collections.shuffle(selectedItemList); // 섞는다.
		selectedItemList.remove(selectedItemList.size() - 1); // 맨 끝의 하나를 삭제한다.
		return selectedItemList; // 섞인 99개 리턴
	}

	private static ArrayList<Integer> items() {
		final int SIZE = 100;
		ArrayList<Integer> itemList = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			itemList.add(i + 1);
		}
		return itemList; // 1 ~ 100 (순서대로)
	}
}// end
