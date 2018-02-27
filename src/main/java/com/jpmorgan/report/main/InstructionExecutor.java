package com.jpmorgan.report.main;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.report.bo.InstructionBo;
import com.jpmorgan.report.bo.InstructionBoImpl;
import com.jpmorgan.report.model.Instruction;
import com.jpmorgan.report.model.Report;
import com.jpmorgan.report.utils.InstructionUtils;

public class InstructionExecutor implements ExecuteInstruction {

	public static void main(String[] args) {
		ExecuteInstruction ie = new InstructionExecutor();
		List<Report> reports = ie.generateReport(InstructionUtils.populateInstructions());
		for (Report report : reports) {
			System.out.println(report);
		}

	}

	public List<Report> generateReport(List<Instruction> instructions) {
		List<Report> reports = new ArrayList<Report>();
		InstructionBo insbo = new InstructionBoImpl();
		for(Instruction instruction: instructions ){
			instruction.setSettlementDate(insbo.adjustSettlementDate(instruction.getCurrency(), instruction.getSettlementDate()));
			if(reports.isEmpty()){
				Report report = addReportEntry(instruction);
				reports.add(report);
			}else{
				//Check report associated this instruction already exist
				for(int i=0; i< reports.size(); i++){
					if(reports.get(i).equalInstruction(instruction)){
						Report rp = updateReportEntry(instruction, reports.get(i));
						reports.set(i, rp);
					}else{
						Report report = addReportEntry(instruction);
						reports.add(report);
					}
				}
			}
		}
		
		return reports;
	}

	

	private Report addReportEntry(Instruction instruction) {
		return updateReportEntry( instruction, null);
	}
	
	private Report updateReportEntry(Instruction instruction,Report report) {
		InstructionBo ins = new InstructionBoImpl();
		if (report == null) {
			report = new Report(instruction.getSettlementDate(), instruction.getEntity(), 0, 0, 0, 0);
		}
		switch (instruction.getBuyOrSell()) {
		case B:
			report.setIncoming(ins.calculateTrade(instruction.getAgreedFx(), instruction.getUnits(),
					instruction.getPricePerUnit()));
			break;
		case S:
			report.setOutgoing(ins.calculateTrade(instruction.getAgreedFx(), instruction.getUnits(),
					instruction.getPricePerUnit()));
			break;
		default:
			break;
		}

		return report;
	}

}
