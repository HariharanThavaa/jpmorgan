package com.jpmorgan.report.utils;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.jpmorgan.report.model.BuyOrSell;
import com.jpmorgan.report.model.Currency;
import com.jpmorgan.report.model.Instruction;

public class InstructionUtils {
	
	/**
	 * Populate Test data for instruction to evaluate report generation
	 * @return List<Instructions>
	 */
	public static List<Instruction> populateInstructions(){
		List<Instruction> instructions = new ArrayList<Instruction>();
		Instruction instructionFoo = new Instruction("foo", BuyOrSell.B, 0.5, Currency.SGP, 
				LocalDate.of(2016, 01, 01), LocalDate.of(2016, 01, 02), 200, 100.25);
		instructions.add(instructionFoo);
		Instruction instructionBar = new Instruction("bar", BuyOrSell.S, 0.5, Currency.AED, 
				LocalDate.of(2016, 01, 05), LocalDate.of(2016, 01, 07), 450, 150.5);
		instructions.add(instructionBar);
		return instructions;
	}

}
