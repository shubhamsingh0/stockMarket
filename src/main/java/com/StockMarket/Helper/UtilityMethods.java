package com.StockMarket.Helper;

public class UtilityMethods {
	private UtilityMethods(){}
	private static UtilityMethods utilityMethods;
	public static UtilityMethods getInstance()
	{if( utilityMethods == null)
		{utilityMethods = new UtilityMethods();return utilityMethods;}
		return utilityMethods;
	}
	
	
	
	public String generateCompanyId(String companyName,int companyStockCode)
	{	System.out.println("generateCompanyId..........");
		char[] collect=companyName.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<3;i++){
			builder.append(collect[i]);
		}
		System.out.println(builder.toString());
		String companyId=builder.toString().toUpperCase()+"_"+companyStockCode;
		System.out.println(companyId);
		return companyId;
	}
	public String generateIpoId(String companyId)
	{
		
		return null;
	}
	
}
