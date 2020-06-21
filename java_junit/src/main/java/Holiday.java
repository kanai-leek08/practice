import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Holiday {
    public boolean isXmas() {
        // 500 lines code here...
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
        LocalDate localDate = LocalDate.now();
        // 500 lines code here...
        return dtf.format(localDate).equals("12/25");
    }
}
