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

        Statement st = con.createStatement();
        String SQL = "INSERT INTO `housesystem`.`weathers`(`temperature`,`condition`,`description`) VALUES (" + temperature + ",'" + weatherCondition + "','" + weatherDescription + "')";
       
        st.executeUpdate(SQL);

        hdb.disconnectDB();
        
    }

}
