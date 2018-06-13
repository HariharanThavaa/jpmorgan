package com.jpmorgan.report;

import java.time.DayOfWeek;

import com.jpmorgan.model.Currency;
import com.jpmorgan.model.Instruction;

public class ReportImpl implements Report {

	public boolean isWorkingDay(Instruction instruction) {
		boolean workingDay = true;
		// unless the currency of the trade is AED or SAR
		if (!instruction.getCurrency().equals(Currency.AED) || !instruction.getCurrency().equals(Currency.SAR)) {
			// A work week starts Monday and ends Friday
			if (instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)
					|| instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				workingDay = false;
			}
		} else {
			// starts Sunday and ends Thursday
			if (instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)
					|| instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
				workingDay = false;
			}
		}
		return workingDay;
	}

	public Instruction changeSettlementDate(Instruction instruction) {
		if(!isWorkingDay(instruction)){
			if (!instruction.getCurrency().equals(Currency.AED) || !instruction.getCurrency().equals(Currency.SAR)) {
				// A work week starts Monday and ends Friday
				if (instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)){
					instruction.setSettlementDate(instruction.getSettlementDate().plusDays(2));
				}else if(instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					instruction.setSettlementDate(instruction.getSettlementDate().plusDays(1));
				}
			} else {
				// starts Sunday and ends Thursday
				if (instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)){
					instruction.setSettlementDate(instruction.getSettlementDate().plusDays(1));
				}else if(instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.FRIDAY)){
					instruction.setSettlementDate(instruction.getSettlementDate().plusDays(2));
				}
			}
		}
		return instruction;

	}

	public Double calculateTradeAmount(Instruction instruction) {
		float agreedFx = instruction.getAgreedFx();
		double ppu = instruction.getPricePerUnit();
		long units = instruction.getUnits();
		Double tradeAmount = agreedFx * ppu * units;
		return  tradeAmount;
	}

}
