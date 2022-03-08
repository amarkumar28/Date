package datedao;

public class CalculateNextDate {
	private static int[] numberOfDaysInMonth = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static int numberOfDaysLeftInCurrentMonth(Date date) {
		return numberOfDaysInMonth[date.getMonth()] - date.getDay();
	}

	private static int numberOfDaysLeftInYear(Date date) {

		int numberOfDaysLeft = numberOfDaysLeftInCurrentMonth(date);
		int k = date.getMonth() + 1;

		for (int i = k; i < numberOfDaysInMonth.length; i++) {
			numberOfDaysLeft += numberOfDaysInMonth[i];
		}

		return numberOfDaysLeft;
	}

	private static void findDateAndMonth(int dateOfNDaysAhead,Date date) {

		for (int i = date.getMonth(); i < numberOfDaysInMonth.length; i++) {

			if (dateOfNDaysAhead <= numberOfDaysInMonth[i]) {

				System.out.println(dateOfNDaysAhead + "-" + i + "-" + date.getYear());
				return;
			}

			dateOfNDaysAhead -= numberOfDaysInMonth[i];
		}
	}

	public static void getDateOfNDaysAhead(int dateOfNDaysAhead, Date date) {

		int daysLeftInMonth = numberOfDaysLeftInCurrentMonth(date);
		int daysLeftInYear = numberOfDaysLeftInYear(date);

		if (dateOfNDaysAhead <= daysLeftInMonth) {
			System.out.println(date.getDay() + dateOfNDaysAhead + "-" + date.getMonth() + "-" + date.getYear());
			return;
		}

		if (dateOfNDaysAhead <= daysLeftInYear) {

			daysLeftInYear -= daysLeftInMonth;
			dateOfNDaysAhead -= daysLeftInMonth;
			date.setMonth(date.getMonth()+1);

			findDateAndMonth(dateOfNDaysAhead,date);

		}

		if (dateOfNDaysAhead > daysLeftInYear) {

			dateOfNDaysAhead -= daysLeftInYear;
			date.setYear(date.getYear()+1);
			date.setDay(1);
			date.setMonth(1);

			while (true) {

				if (DateValidation.checkLeapYear(date.getYear())) {
					daysLeftInYear = 366;
					numberOfDaysInMonth[2] = 29;
				} else {
					daysLeftInYear = 365;
					numberOfDaysInMonth[2] = 28;
				}

				if (dateOfNDaysAhead <= daysLeftInYear) {
					findDateAndMonth(dateOfNDaysAhead,date);
					break;
				}

				else {
					date.setYear(date.getYear()+1);
					dateOfNDaysAhead -= daysLeftInYear;
				}
			}
		}

	}
}
