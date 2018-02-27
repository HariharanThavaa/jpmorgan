package com.jpmorgan.report.model;

import java.time.LocalDate;


public class Instruction {
	
	private String entity;
	private BuyOrSell buyOrSell;
	private double agreedFx;
	private Currency currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private long Units;
	private double pricePerUnit;
	
	
	
	public Instruction(String entity, BuyOrSell buyOrSell, double agreedFx, Currency currency, LocalDate instructionDate,
			LocalDate settlementDate, long units, double pricePerUnit) {
		super();
		this.entity = entity;
		this.buyOrSell = buyOrSell;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		Units = units;
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

	public double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public long getUnits() {
		return Units;
	}

	public void setUnits(long units) {
		Units = units;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "Instruction [entity=" + entity + ", buyOrSell=" + buyOrSell + ", agreedFx=" + agreedFx + ", currency="
				+ currency + ", instructionDate=" + instructionDate + ", settlementDate=" + settlementDate + ", Units="
				+ Units + ", pricePerUnit=" + pricePerUnit + "]";
	}

}
