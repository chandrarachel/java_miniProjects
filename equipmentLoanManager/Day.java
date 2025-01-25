public class Day implements Cloneable, Comparable<Day> {
	
	private int year;
	private int month;
	private int day;

    private static final String MonthNames="JanFebMarAprMayJunJulAugSepOctNovDec";

	//Constructor
	public Day(int y, int m, int d) {
		this.year=y;
		this.month=m;
		this.day=d;		
	}

	public Day(String date){
		String[] dateParts = date.split("-");
		this.day = Integer.parseInt(dateParts[0]);
		this.year = Integer.parseInt(dateParts[2]);
		this.month = MonthNames.indexOf(dateParts[1])/3+1;
	}

	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}

	public boolean after(String sNew, String sOld){
		String[] sOldParts = sOld.split("-");
		int intOldDay = Integer.parseInt(sOldParts[0]);
		int intOldYear = Integer.parseInt(sOldParts[2]);
		int intOldMonth = MonthNames.indexOf(sOldParts[1])/3+1;

		String[] sNewParts = sNew.split("-");
		int intNewDay = Integer.parseInt(sNewParts[0]);
		int intNewYear = Integer.parseInt(sNewParts[2]);
		int intNewMonth = MonthNames.indexOf(sNewParts[1])/3+1;

		if(intNewYear > intOldYear || (intNewYear == intOldYear && intNewMonth > intOldMonth) || (intNewYear == intOldYear && intNewMonth == intOldMonth && intNewDay > intOldDay)){
			return true;
		} else{
			return false;
		}
	}

	public boolean isValidMonth(String month){
        String[] realMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(String m: realMonths){
            if(m.equals(month)){
                return true;
            }
        }
        return false;
	}

	public boolean isValidYear(String year){
		char[] yearChars = {year.charAt(0), year.charAt(1), year.charAt(2), year.charAt(3)};

		for(char y: yearChars){
			if(!Character.isDigit(y)){
				return false;
			}
		}
		return true;
	}

	public boolean validate(String sDay) throws NumberFormatException{
		if(sDay.length()!=11){
			return false;
		} else{
			String[] sDayStrings = sDay.split("-");
			
			if(!isValidMonth(sDayStrings[1]) || !isValidYear(sDayStrings[2])){
				return false;
			}
			int day = Integer.parseInt(sDayStrings[0]);
			int monthInt = MonthNames.indexOf(sDayStrings[1])/3+1;
			int year = Integer.parseInt(sDayStrings[2]);

			if(valid(year, monthInt, day)){
				return true;
			}
		}
		return false;
	}

    public void set(String sDay){
		String[] sDayParts = sDay.split("-");
		this.day = Integer.parseInt(sDayParts[0]);
		this.year = Integer.parseInt(sDayParts[2]);
		this.month = MonthNames.indexOf(sDayParts[1])/3+1;
    }

    // public Day (String sDay) {
    //     set(sDay);
    // }
	
	// check if a given year is a leap year
	static public boolean isLeapYear(int y) {
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}
	
	// check if y,m,d valid
	static public boolean valid(int y, int m, int d) {
		if (m<1 || m>12 || d<1) return false;
		switch(m){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					 return d<=31; 
			case 4: case 6: case 9: case 11:
					 return d<=30; 
			case 2:
					 if (isLeapYear(y))
						 return d<=29; 
					 else
						 return d<=28; 
		}
		return false;
	}

	public Day countEndDate(Day startDate, int loanPeriod){
        int startDay = startDate.getDay();
        int startMonth = startDate.getMonth();
        int startYear = startDate.getYear();

        int endDay = startDay + loanPeriod;
        int endMonth = startMonth;
        int endYear = startYear;

        while(startDay > daysInMonth(endMonth, endYear)){
            endDay -= daysInMonth(endMonth, endYear);
            endMonth++;

            if(endMonth > 12){
                endYear++;
                endMonth = 1;
            }
        }


        return new Day(endYear, endMonth, endDay);
    }

	private int daysInMonth(int month, int year){
        switch(month){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					 return 31; 
			case 4: case 6: case 9: case 11:
					 return 0; 
			case 2:
					 if (isLeapYear(year))
						 return 29; 
					 else
						 return 28; 
		}
        return 0;
    }

    @Override
	public String toString() {
		final String[] MonthNames = {
				"Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec"};
		
		return day+"-"+ MonthNames[month-1] + "-"+ year;
	}

    @Override
    public Day clone()
    {
        Day copy=null;
        try {
            copy = (Day) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

	private String dateToString(Day date) {
		return String.format("%04d%02d%02d", date.year, date.month, date.day);
	}

	@Override
	public int compareTo(Day another) {
		String date1 = dateToString(this);
		String date2 = dateToString(another);
		return date1.compareTo(date2);
	}
}