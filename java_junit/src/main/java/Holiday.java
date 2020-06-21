import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Holiday {
    public boolean isXmas() {
        String substring = getDay().substring(5, 10);
        return substring.equals("12/24");
    }

    protected String getDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }
}
