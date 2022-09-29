import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkingWithDate {
    public static void main(String[] args) throws ParseException {
        System.out.println(timeConversion("11:46:12PM"));
    }
    private static String timeConversion(String s) throws ParseException {
        SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm:ssaa");
        Date date = dt1.parse(s.substring(0));
        SimpleDateFormat dt2 = new SimpleDateFormat("HH:mm:ss");
        String formatedDate = dt2.format(date).toString();
        return formatedDate;
    }
}
