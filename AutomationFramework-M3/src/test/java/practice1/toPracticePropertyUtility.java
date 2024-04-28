package practice1;

import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;

public class toPracticePropertyUtility {

	public static void main(String[] args) throws Exception {
		// fetching data from property utilit
		propertyFileUtility pUtility = new propertyFileUtility();
		String url = pUtility.toReadDataFromPropertyFile("password");
		System.out.println(url);
		// fetching data fromexcel utility
		excelFileUtility exUtility = new excelFileUtility();
		String lastname = exUtility.toReadDataFromExcelFile("Contacts", 1, 2);
		System.out.println(lastname);
		int rowCount = exUtility.toGetRowCount("Contacts");
		System.out.println(rowCount);
	}

}
