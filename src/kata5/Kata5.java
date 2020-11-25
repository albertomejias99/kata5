package kata5;
import java.sql.*;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.persistance.MailListReader;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String query = "SELECT * FROM people WHERE state='CA'";
        List<Mail> mailList = MailListReader.read("org.sqlite.JDBC", query);

        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay= new HistogramDisplay("HISTOGRAM", mailHistogram);
        histogramDisplay.execute();
    }
    
}
