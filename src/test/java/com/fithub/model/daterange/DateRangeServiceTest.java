package com.fithub.model.daterange;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateRangeServiceTest {

	@Autowired
	private DateRangeService dateRangeService;

	@Test
	@DisplayName("Generate from today to MonthAfter")
	void testGetRangeDate_whenInputOnlyMonthAfter_returnDateRange() {
		// Arrange
		int monthsAfter = 1;
		LocalDate today = LocalDate.now();
		LocalDate expectedStartDate = today;
		LocalDate expectedEndDate = today.plusMonths(monthsAfter).with(TemporalAdjusters.lastDayOfMonth());

		// Act
		DateRange result = dateRangeService.getRangeDate(monthsAfter);

		// Assert

		Assertions.assertEquals(Date.from(expectedStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getStartDate(), "Date Range is not correct");
		Assertions.assertEquals(Date.from(expectedEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getEndDate(), "Date Range is not correct");
	}

	@Test
	@DisplayName("Generate from MonthsBefore to MonthsAfter")
	void testGetRangeDate_whenInputMonthBeforeAndMonthAfter_returnDateRange() {
		// Arrange
		int monthsBefore = 1;
		int monthsAfter = 1;
		LocalDate today = LocalDate.now();
		LocalDate expectedStartDate = today.minusMonths(monthsBefore).withDayOfMonth(1);
		LocalDate expectedEndDate = today.plusMonths(monthsAfter).with(TemporalAdjusters.lastDayOfMonth());

		// Act
		DateRange result = dateRangeService.getRangeDate(monthsBefore, monthsAfter);

		// Assert

		Assertions.assertEquals(Date.from(expectedStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getStartDate(), "Date Range is not correct");
		Assertions.assertEquals(Date.from(expectedEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getEndDate(), "Date Range is not correct");
	}

	@Test
	@DisplayName("Generate from MonthsBefore=-1 to MonthsAfter")
	void testGetRangeDate_whenInputMonthBeforeBeMinusOneAndMonthAfter_returnDateRange() {
		// Arrange
		int monthsBefore = -1;
		int monthsAfter = 1;
		LocalDate today = LocalDate.now();
		LocalDate expectedStartDate = today.minusMonths(monthsBefore).withDayOfMonth(1);
		LocalDate expectedEndDate = today.plusMonths(monthsAfter).with(TemporalAdjusters.lastDayOfMonth());
		// Act
		DateRange result = dateRangeService.getRangeDate(monthsBefore, monthsAfter);

		// Assert

		Assertions.assertEquals(Date.from(expectedStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getStartDate(), "Date Range is not correct");
		Assertions.assertEquals(Date.from(expectedEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getEndDate(), "Date Range is not correct");
	}

	@Test
	@DisplayName("Generate from DaysAfter to MonthsAfter")
	void testgetRangeDateAfterFromGivenDaysToGivenMonths_whenInputDaysAfterAndMonthAfter_returnDateRange() {
		// Arrange
		int daysAfter = 10;
		int monthAfter = 1;
		LocalDate today = LocalDate.now();
		LocalDate expectedStartDate = today.plusDays(daysAfter);
		LocalDate expectedEndDate = today.plusMonths(monthAfter).with(TemporalAdjusters.lastDayOfMonth());

		// Act
		DateRange result = dateRangeService.getRangeDateAfterFromGivenDaysToGivenMonths(daysAfter, monthAfter);

		// Assert

		Assertions.assertEquals(Date.from(expectedStartDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getStartDate(), "Date Range is not correct");
		Assertions.assertEquals(Date.from(expectedEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				result.getEndDate(), "Date Range is not correct");
	}

}
