package com.StockMarket.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.StockMarket.Entity.Company;
import com.StockMarket.Entity.Directors;
import com.StockMarket.Entity.IPO;
import com.StockMarket.Helper.UtilityMethods;
import com.StockMarket.Service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**Add Company**/
	private UtilityMethods utilityMethods;
	
	int lastIndex=0;int counter=0;int countDirector=0;int tempDirectorCount=0;
	@RequestMapping("addCompany")
	public ModelAndView addCompany(@RequestParam String companyName,@RequestParam int companyTurnOver,@RequestParam String companyCeo,@RequestParam String companyBrief,@RequestParam int companyStockCode,@RequestParam String companySector)
	{	tempDirectorCount=countDirector;
		System.out.println("tempDirectorCount-->"+tempDirectorCount);
		countDirector=0;
		++counter;
		System.out.println("counterCompany-->"+counter);
		ModelAndView mv=new ModelAndView();
		Company company=new Company();
//		char[] collect=companyName.toCharArray();
//		StringBuilder builder = new StringBuilder();
//		
//		for(int i=0;i<3;i++){
//			builder.append(collect[i]);
//		}
//		System.out.println(builder.toString());
//		String companyId=builder.toString().toUpperCase()+"_"+companyStockCode;
//		System.out.println(companyId);
		String companyId=utilityMethods.getInstance().generateCompanyId(companyName, companyStockCode);
		company.setCompanyId(companyId);
		company.setCompanyName(companyName);
		company.setCompanyTurnOver(companyTurnOver);
		company.setCompanyCeo(companyCeo);
		company.setCompanyBrief(companyBrief);
		company.setCompanyStockCode(companyStockCode);
		company.setCompanySector(companySector);
		
		lastIndex=adminService.fetchDirectorsLastId();
		System.out.println("lastIndex "+ lastIndex);
		List<Directors> director=new ArrayList<Directors>();
		if(counter==1){
		director=adminService.fetchDirectors(lastIndex,counter);	
		company.setDirectorName(director);}
		else
		{	int temp=lastIndex-tempDirectorCount;
			director=adminService.fetchDirectors(lastIndex,temp);	
			company.setDirectorName(director);
		}
		System.out.println(company.getDirectorName());
		company=adminService.addCompany(company);
		if(company.getCompanyId()!=null)
		{
			mv.addObject("companyDetails",company);
			mv.setViewName("Welcome");
		}
		else
		{
			mv.addObject("errorAddingCompany",company);
			mv.setViewName("Welcome");
		}
		tempDirectorCount=0;
		
		return mv;
	}
	
	@RequestMapping("addBod")
	public ModelAndView addBod(@RequestParam String companyBod)
	{	
		
		ModelAndView mv=new ModelAndView();
		Directors director=new Directors();
		director.setName(companyBod);
		adminService.AddBod(director);
		++countDirector;
		System.out.println("countdirector-->"+countDirector);
		return mv;
	}
	/**Deactivate Account**/
	
	@RequestMapping("deactivateAccount")
	public ModelAndView deactivateAccount(@RequestParam String companyName,@RequestParam int companyStockCode){
		ModelAndView mv=new ModelAndView();
		String companyId=utilityMethods.getInstance().generateCompanyId(companyName, companyStockCode);
		boolean status=adminService.deactivateCompany(companyId);
		mv.addObject("deactivateCompany",status);
		mv.setViewName("Welcome");
		return mv;
				
	}
	
	/** Show all Companies **/
	@RequestMapping("showAllCompanies")
	public ModelAndView showAllCompanies(){
		ModelAndView mv=new ModelAndView();
		List<Company> companyList=adminService.showAllCompany();
		mv.addObject("showAllCompanies",companyList);
		mv.setViewName("Welcome");
		return mv;
	}
	
	
	/** add IPO **/
	/*@RequestMapping("addIpo")
	public ModelAndView addIpo(@RequestParam int pricePerShare,@RequestParam String remarks,@RequestParam int totalNumberOfShares ,String companyId,String stockExchangeId)
	{	
		
		ModelAndView mv=new ModelAndView();
		IPO ipo1=new IPO();
		Company company=adminService.fetchCompanyById(companyId);
		ipo1.setCompanyId(company);
		ipo1.setDateAndtime(new Date());
		ipo1.setPricePerShare(pricePerShare);
		ipo1.setRemarks(remarks);
		ipo1.setTotalNumberOfShares(totalNumberOfShares);
		ipo1.setStockExchangeid(stockExchangeId);
		adminService.AddIpo();
		++countDirector;
		System.out.println("countdirector-->"+countDirector);
		return mv;
	}
	
	*/
	
}
