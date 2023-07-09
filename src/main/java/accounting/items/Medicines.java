package accounting.items;

import java.time.LocalDate;

public class Medicines extends Item {
    private String name;
    private long days;
    private long years;
    private long months;
    private LocalDate dateOfPurchase;
    public Medicines(String name, int id, double width, double length, double height, int day,int month,int year,String time, long amount) {
        super(name, id, width, length, height);
        this.name = name;
        this.dateOfPurchase=LocalDate.of(year,month,day);
        if (time.equals("d")){
            this.days = amount;
        }else if (time.equals("m")){
            this.months=amount;
        }else if(time.equals("y")){
            this.years=amount;
        }
    }

    public String getName() {
        return name;
    }

    public long getDays() {
        return days;
    }

    public long getYears() {
        return years;
    }

    public long getMonths() {
        return months;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }
}
