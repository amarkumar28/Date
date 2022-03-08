package datedao;

import date.exceptions.WrongDateInputException;

public class DateValidation {

	public static boolean checkLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public static boolean setTodaysDate(int day, int month, int year) {

		boolean isLeapYear = false;

		if (year < 1900) {
			throw new WrongDateInputException("year");
		}

		if (month > 12) {
			throw new WrongDateInputException("month");
		}

		if (day > 31) {
			throw new WrongDateInputException("day");
		}

		if (day > 28) {
			if (day == 29 && month == 2) {
				if (isLeapYear == false) {
					System.out.println("You Entered wrong day ");
				}
			}
		}

		return true;
	}

}