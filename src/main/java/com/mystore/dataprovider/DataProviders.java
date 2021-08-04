/**
 * 
 */
package com.mystore.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utility.NewExcelLibrary;

/**
 * @author prasa
 *
 */
public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;
		//System.out.println("rows: "+actRows);
		//System.out.println("Colums: "+column);

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
				/*data[1][0]= "admin@xyz.com";
				data[1][1]= "admin@xyz.com";
				data[2][0]= "admin@xyz.com";
				data[2][1]= "admin@xyz.com";*/
		
				//System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
				//System.out.println(data[i][j]);
			}
			
		}
		return data;
		
	}
	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest
	@DataProvider(name = "Email")
	public Object[][] getEmail()
	{
		int rows=obj.getRowCount("Email");
		int column=obj.getColumnCount("Email");
		int actRows=rows-1;
		
		Object data[][]=new Object[actRows][column];
		for(int i=0;i<actRows;i++)
		{
			for(int j=0; j<column;j++)
			{
				data[i][j]=obj.getCellData("Email", j, i+2);
			}
		}
		return data;
	}

	//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
	@DataProvider(name = "getProduct")
	public Object[][] getProduct()
	{
		int rows=obj.getRowCount("ProductDetails");
		int column=obj.getColumnCount("ProductDetails");
		int actRows=rows-1;
		
		Object data[][]=new Object[actRows][column];
		for(int i=0;i<actRows;i++)
		{
			for(int j=0; j<column;j++)
			{
				data[i][j]=obj.getCellData("ProductDetails", j, i+2);
			}
		}
		return data;
	}
	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		@DataProvider(name = "searchProduct")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = obj.getRowCount("SearchProduct");
			// Total Columns
			int column = obj.getColumnCount("SearchProduct");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "newAcountDetailsData")
		public Object[][] accountCreation() {
			int rows=obj.getRowCount("AccountCreationData");
			int column=obj.getColumnCount("AccountCreationData");
			int actRows=rows-1;
			
			Object[][] data=new Object[actRows][1];
			for(int i=0; i<actRows; i++)
			{
				Map<String, String> hasmap=new HashMap<String, String>();
				for(int j=0; j<column; j++)
				{
					hasmap.put(obj.getCellData("AccountCreationData", j, 1), obj.getCellData("AccountCreationData", j, i+2));
				}
				data[i][0]=hasmap;
			}
			return data;
		}
}
