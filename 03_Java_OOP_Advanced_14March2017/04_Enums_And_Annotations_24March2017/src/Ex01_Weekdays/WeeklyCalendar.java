package Ex01_Weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        WeeklyEntry entry = new WeeklyEntry(weekday, notes);
        this.entries.add(entry);
    }

    public List<WeeklyEntry> getEntries() {
        return Collections.unmodifiableList(this.entries);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        Collections.sort(entries, WeeklyEntry.BY_WEEKDAY);
        return entries;
    }

//    public static void main(String[] args) {
//        WeeklyCalendar calendar = new WeeklyCalendar();
//        calendar.addEntry("Friday", "sleeping");
//        calendar.addEntry("Monday", "sport");
//
//        for(WeeklyEntry weeklyEntry : calendar.getWeeklySchedule()) {
//            System.out.println(weeklyEntry);
//        }
//    }
}
