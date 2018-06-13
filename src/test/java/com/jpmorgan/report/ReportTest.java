package com.jpmorgan.report;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.model.BuyOrSell;
import com.jpmorgan.model.Currency;
import com.jpmorgan.model.Instruction;

public class ReportTest {
	
	Report report;
	Instruction foo;
	Instruction bar;

	@Before
	public void setData(){
		report = new ReportImpl();
		foo = new Instruction("foo", 
				BuyOrSell.B, 
				0.5F, 
				Currency.SGP, 
				LocalDateTime.of(2016,Month.JANUARY, 1,0,0), 
				LocalDateTime.of(2016,Month.JANUARY, 2,0,0), 
				200L, 
				100.25);
		bar = new Instruction("bar", 
				BuyOrSell.S, 
				0.22F, 
				Currency.AED, 
				LocalDateTime.of(2016,Month.JANUARY, 5,0,0), 
				LocalDateTime.of(2016,Month.JANUARY, 6,0,0), 
				450L, 
				150.25);
	}
	
	
	@Test
	public void isWorkingDayTest(){
		//Saturday, 2 January 2016
		boolean workingDay = report.isWorkingDay(foo);
		assertFalse(workingDay);
		//Thursday, 7 January 2016
		workingDay = report.isWorkingDay(bar);
		assertTrue(workingDay);
	}
	
	@Test 
	public void changeSettlementDateTest(){
		LocalDateTime barDate = bar.getSettlementDate();
		LocalDateTime fooDate = foo.getSettlementDate();
		foo = report.changeSettlementDate(foo);
		bar = report.changeSettlementDate(bar);
		assertEquals(barDate, bar.getSettlementDate());
		assertEquals(fooDate.plusDays(2), foo.getSettlementDate());
	}
	
	@Test
	public void calculateTradeAmountTest(){
		Double fooTrade = 0.5 * 200* 100.25;
		Double barTrade = 0.22 * 450 * 150.25;
		assertEquals(fooTrade, report.calculateTradeAmount(foo));
		assertEquals(Math.round(barTrade), Math.round(report.calculateTradeAmount(bar)));
	}

}
