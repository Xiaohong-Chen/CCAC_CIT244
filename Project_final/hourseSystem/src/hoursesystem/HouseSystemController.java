package hoursesystem;

import java.sql.*;
import java.sql.SQLException;

public class HouseSystemController {

    public void recordWeatherIntoDB() throws ClassNotFoundException, SQLException {

        WeatherInfo weatherInfo = new WeatherInfo();
        HouseSystemDB hdb = new HouseSystemDB();

        int temperature = (int) weatherInfo.getFahrenheitTemperature();
        String weatherCondition = weatherInfo.getWeatherCondition();
        String weatherDescription = weatherInfo.getWeatherDescription();

        Connection con = hdb.getDatabaseConnection();

        String datetime = "aa";
        int temperature1 = 5;
        String weatherCondition1 = "sss";
        String windSpeed = "ss";
        String humidity ="ss";
        String pressure = "ss";
        String status = "ss";

        Statement st = con.createStatement();
        String SQL = "SELECT * FROM housesystem.weathers";
        ResultSet rs = st.executeQuery(SQL);

        System.out.println(rs);
        while(rs.next()){
            String d = rs.getString("status");
            System.out.println(d);
            
        }
        
    }

}
