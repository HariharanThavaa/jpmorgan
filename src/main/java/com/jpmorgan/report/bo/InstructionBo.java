package com.jpmorgan.report.bo;

import java.time.LocalDate;

import com.jpmorgan.report.model.Currency;

public interface InstructionBo {
	
	public LocalDate adjustSettlementDate(Currency currency, LocalDate settlementDate);
	public double calculateTrade(double agreedFx, long units, double pricePerUnit);

}
