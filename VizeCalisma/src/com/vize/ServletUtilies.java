package com.vize;

public class ServletUtilies {
	/**
	 * html title 'ı üreten bir sınıf
	 */
	public static String HeadWithTitle(String title) {
		
		return ("<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n");
	}
}
