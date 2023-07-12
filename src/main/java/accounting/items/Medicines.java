package accounting.items;

import java.time.LocalDate;

public class Medicines extends Item {
    private String name;
    private long days;
    private long years;
    private long months;
    private LocalDate validByDate;
    public Medicines(String name, int id, double width, double length, double height, int day,int month,int year) {
        super(name, id, width, length, height);
        this.name = name;
        this.validByDate =LocalDate.of(year,month,day);
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

    public LocalDate getValidByDate() {
        return validByDate;
    }
}
