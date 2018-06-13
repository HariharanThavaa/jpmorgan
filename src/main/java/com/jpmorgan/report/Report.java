package com.jpmorgan.report;

import com.jpmorgan.model.Instruction;

public interface Report {

	public boolean isWorkingDay(Instruction instruction);
	public Instruction changeSettlementDate(Instruction instruction);
	public Double calculateTradeAmount(Instruction instruction);

}
