package com.fithub.model.daterange;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateRangeService {

	public DateRange getRangeDate(int monthsAfter) {
		LocalDate today = LocalDate.now();
		LocalDate startDate = today;
		LocalDate endDate = today.plusMonths(monthsAfter).with(TemporalAdjusters.lastDayOfMonth());

		return new DateRange(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public DateRange getRangeDate(int monthsBefore, int monthsAfter) {
		LocalDate today = LocalDate.now();
		LocalDate startDate = today.minusMonths(monthsBefore).withDayOfMonth(1);
		LocalDate endDate = today.plusMonths(monthsAfter).with(TemporalAdjusters.lastDayOfMonth());

		return new DateRange(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public DateRange getRangeDateAfterFromGivenDaysToGivenMonths(int daysAfter, int monthsAfter) {
		LocalDate today = LocalDate.now();
		LocalDate startDate = today.plusDays(daysAfter);
		LocalDate endDate = today.plusMonths(monthsAfter).with(TemporalAdjusters.lastDayOfMonth());

		return new DateRange(Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}
}
