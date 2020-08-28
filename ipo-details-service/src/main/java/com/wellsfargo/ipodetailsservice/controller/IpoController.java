package com.wellsfargo.ipodetailsservice.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.ipodetailsservice.models.IPO;
import com.wellsfargo.ipodetailsservice.service.IpoService;

@RestController
public class IpoController {
	
	@Autowired
	private IpoService ipoService;
	
	@RequestMapping("/ipos")
	public List<IPO> getallIpos(){
		return ipoService.getAllIpos();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/ipos/company")
	public List<IPO> getallIposByCompanyName(@RequestBody JSONObject param){
		String companyName=(String)param.get("companyName");
		return ipoService.getsortedIpoDetailsFromCompanyName(companyName);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/ipos/se/company")
	public List<IPO> getallIposByCompanyNameAndSeName(@RequestBody JSONObject param){
		String companyName=(String)param.get("companyName");
		String seName=(String)param.get("seName");
		return ipoService.getsortedIpoDetailsFromCompanyNameAndSeName(companyName, seName);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/ipos/add")
	public void addIpo(@RequestBody IPO ipo) {
		ipoService.addIpo(ipo);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/ipos/update")
	public void updateIpo(@RequestBody IPO ipo) {
		ipoService.updateIpoDetails(ipo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/ipos/delete/{id}")
	public void updateIpo(@PathVariable long id) {
		ipoService.deleteIpoDetails(id);
	}
	
}
