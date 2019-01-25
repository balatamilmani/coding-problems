/*
 * Copyright (c) 2019. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.misproblems;

/**
 * @author Balamurugan Tamilmani
 * Given two strings s1, s2 the method should return true if replacing/adding/deleting a char on s1 make the string matches with s2 char by char
 * E.g 
 * Replacing s1->abc, s2->acc
 * Inserting s1->ac, s2->acc
 * Deleting  s1->abc, s2->ac
 */
public class StringMatcher {
	
	/**
	 * This method returns true if INSERTING/DELETING/REPLACING a single char on the source sting matches the target string
	 * @param source Source String
	 * @param target Target String
	 * @return returns true if INSERTING/DELETING/REPLACING a single char on the source sting matches the target string, false otherwise
	 */
	public static boolean matches(String source, String target) {
		boolean matches = true;
		
		if(source == null || target == null) {
			matches = false;
		} else if(Math.abs(source.length()-target.length()) >1) {
			//both strings must be of same length or One char longer than other
				matches = false;
		} else if(source.length()-target.length() == 0){
			//Both string same length, char needs to be replaced
			//if chars differs more than once return false
			//diffCountThreshold=1, one char replacement is allowed
			matches = matchesCharByChar(source, target, 1);
		} else if(source.length()-target.length() > 0) {
			//Source longer than Target, char needs to be deleted
			for(int i=0; i<target.length(); i++) {
				if(source.charAt(i) != target.charAt(i)) {
					//current char on source is dropped, remaining chars should match with target
					matches = matchesCharByChar(source.substring(i+1), target.substring(i),0);
				}
			}
		} else {
			//Source shorter than Target, char needs to be inserted
			for(int i=0; i<source.length(); i++) {
				if(source.charAt(i) != target.charAt(i)) {
					//current char on target is added to source, remaining chars should match with target
					matches = matchesCharByChar(source.substring(1), target.substring(i+1),0);
				}
			}
		}
		return matches;
	}
	/**
	 * Method matches source string with target char by char until number of differences within Threshold
	 * @param source The Source String
	 * @param target The Target String
	 * @param diffCountThreshold Number of char differences Threshold
	 * @return true if number of char differences is nil or within allowed threshold, false otherwise 
	 */
	public static boolean matchesCharByChar(String source, String target, int diffCountThreshold) {
		boolean matches = true;
		int numberOfDiffs = 0;
		if(source == null || target == null) {
			matches = false;
		} else if(Math.abs(source.length()-target.length()) >0) {
			matches = false;
		} else {
			for(int i=0; i<source.length(); i++) {
				if(source.charAt(i) != target.charAt(i)) {
					numberOfDiffs++;
					if(numberOfDiffs>diffCountThreshold) {
						matches = false;
						break;
					}
				}
			}
		}
		return matches;
	}
	
}
