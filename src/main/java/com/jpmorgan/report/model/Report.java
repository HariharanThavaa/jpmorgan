package com.jpmorgan.report.model;

import java.time.LocalDate;

public class Report {
	
	private LocalDate date;
	private String entity;
	private Double incoming;
	private double outgoing;
	private int incomingRanking;
	private int outgoingRanking;
	
	public Report(LocalDate date, String entity, double incoming, double outgoing, int incomingRanking, int outgoingRanking) {
		super();
		this.date = date;
		this.entity = entity;
		this.incoming = incoming;
		this.outgoing = outgoing;
		this.incomingRanking = incomingRanking;
		this.outgoingRanking = outgoingRanking;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Double getIncoming() {
		return incoming;
	}
	public void setIncoming(double incoming) {
		this.incoming = incoming;
	}
	public double getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(double outgoing) {
		this.outgoing = outgoing;
	}
	public int getIncomingRanking() {
		return incomingRanking;
	}
	public void setIncomingRanking(int incomingRanking) {
		this.incomingRanking = incomingRanking;
	}
	public int getOutgoingRanking() {
		return outgoingRanking;
	}
	public void setOutgoingRanking(int outgoingRanking) {
		this.outgoingRanking = outgoingRanking;
	}

	public boolean equalInstruction(Instruction instruction){
		return (this.entity.equalsIgnoreCase(instruction.getEntity()) && this.date.equals(instruction.getSettlementDate()));
	}
	
	@Override
	public String toString() {
		return "Report [date=" + date + ", entity=" + entity + ", incoming=" + incoming + ", outgoing=" + outgoing
				+ ", incomingRanking=" + incomingRanking + ", outgoingRanking=" + outgoingRanking + "]";
	}
	
}
