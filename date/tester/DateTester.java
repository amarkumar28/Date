package date.tester;

import datedao.Date;

public class DateTester{
    public static void main(String args[]){

        Date todaysDate=new Date(37,1,2021);

        int dateOfNDaysAhead = 1000;

        todaysDate.getDateOfNDaysAhead(dateOfNDaysAhead,todaysDate);
    }
}