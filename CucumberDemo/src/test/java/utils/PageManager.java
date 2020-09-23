package utils;

import pages.CMSDropdownPage;

public class PageManager {
	private static CMSDropdownPage ddPage = new CMSDropdownPage(DriverManager.getDriver());
	
	public static CMSDropdownPage getCMSDropdownPage() {
		return ddPage;
	}
}
