package com.jpmorgan.report.bo;

import java.time.LocalDate;
import com.jpmorgan.report.model.Currency;

public class InstructionBoImpl implements InstructionBo {

	public LocalDate adjustSettlementDate(Currency currency, LocalDate settlementDate) {
		if (currency == Currency.AED || currency == Currency.SAR) {
			switch (settlementDate.getDayOfWeek()) {
			case FRIDAY:
				settlementDate = settlementDate.plusDays(2);
				break;
			case SATURDAY:
				settlementDate = settlementDate.plusDays(1);
				break;
			default:
				break;
			}
		} else {
			switch (settlementDate.getDayOfWeek()) {
			case SATURDAY:
				settlementDate = settlementDate.plusDays(2);
				break;
			case SUNDAY:
				settlementDate = settlementDate.plusDays(1);
				break;
			default:
				break;
			}
		}
		return settlementDate;
	}

	public double calculateTrade(double agreedFx, long units, double pricePerUnit) {
		return agreedFx*units*pricePerUnit;
	}

}
