package com.wellsfargo.stockexchangeservice.models;

import java.util.List;

import com.wellsfargo.stockexchangeservice.models.IPO;

public class IPODetails {
 private List<IPO> ipo;

 public List<IPO> getIpo() {
     return ipo;
 }

 public void setIpo(List<IPO> ipo) {
     this.ipo = ipo;
 }
}