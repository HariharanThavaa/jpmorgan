package com.jpmorgan.report.main;

import java.util.List;

import com.jpmorgan.report.model.Instruction;
import com.jpmorgan.report.model.Report;

public interface ExecuteInstruction {
	
	public List<Report> generateReport(List<Instruction> instructions);

}
