/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoursesystem;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author seanc
 */
public class testMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
        /*
        
        HouseSystemController h = new HouseSystemController();
        while (true) {
            System.out.println("start");
            h.recordWeatherIntoDB();
            Thread.sleep(6000);
            System.out.println("end");
        }
        */
        //WeatherInfo w= new WeatherInfo();
        //WeatherInfo.getWeatherConditionJsonObject();
        HouseSystemController h = new HouseSystemController();
        h.recordWeatherIntoDB();
        
    }
}
