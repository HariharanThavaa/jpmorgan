package com.jpmorgan.model;

import java.time.LocalDateTime;

public class Instruction {
	
	private String entity;
	private BuyOrSell buyOrSell;
	private float agreedFx;
	private Currency currency;
	private LocalDateTime instructionDate;
	private LocalDateTime settlementDate;
	private long units;
	private double pricePerUnit;
	
	public Instruction(String entity, BuyOrSell buyOrSell, float agreedFx, Currency currency, LocalDateTime instructionDate,
			LocalDateTime settlementDate, long units, double pricePerUnit) {
		super();
		this.entity = entity;
		this.buyOrSell = buyOrSell;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public BuyOrSell getBuyOrSell() {
		return buyOrSell;
	}
	public void setBuyOrSell(BuyOrSell buyOrSell) {
		this.buyOrSell = buyOrSell;
	}
	public float getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(float agreedFx) {
		this.agreedFx = agreedFx;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public LocalDateTime getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(LocalDateTime instructionDate) {
		this.instructionDate = instructionDate;
	}
	public LocalDateTime getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(LocalDateTime settlementDate) {
		this.settlementDate = settlementDate;
	}
	public long getUnits() {
		return units;
	}
	public void setUnits(long units) {
		this.units = units;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	

}
