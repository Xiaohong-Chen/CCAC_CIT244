package hoursesystem;

import java.io.*;
import java.net.*;
import org.json.*;

public class WeatherInfo {

    private final static String API_KEY = "9e09186b4c56079c4d2325124aa8a392";
    private final static String ZIP_CODE = "15232";
    private final static String urlString = "http://api.openweathermap.org/data/2.5/weather?zip=" + ZIP_CODE + ",us&APPID=" + API_KEY;

    public static JSONObject getWeatherJsonObject() {

        try {
            System.out.println(urlString);
            URL url = new URL(urlString);

            URLConnection conn = url.openConnection();

            InputStream inputStream = conn.getInputStream();

            InputStreamReader isr = new InputStreamReader(inputStream);

            BufferedReader bufr = new BufferedReader(isr);

            String r = bufr.readLine();
            
            JSONObject myWeatherJsonObject = new JSONObject(r);
            
            return myWeatherJsonObject;
            
        } catch (MalformedURLException ex) {
            System.out.println("URL Exception");
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
        return null;
    }

    private static JSONObject getTemperatureJsonObject(){
        String tempString = getWeatherJsonObject().get("main").toString();
        return new JSONObject(tempString);
    }
    
    public static JSONObject getWeatherConditionJsonObject(){
        String weatherStatus = getWeatherJsonObject().getJSONArray("weather").get(0).toString();
        return new JSONObject(weatherStatus);
    }
    
    public long convertKelvinToFahrenheit(double KelvinTemperature) {
        return Math.round((KelvinTemperature - 273.15) * 9 / 5 + 32);
    }

    
    public long getFahrenheitTemperature() {
        double KelvinTemperature = Double.parseDouble(getTemperatureJsonObject().get("temp").toString());
        return convertKelvinToFahrenheit(KelvinTemperature);
    }
            
    public String getWeatherCondition(){
        return getWeatherConditionJsonObject().get("main").toString();
    }
    
    public String getWeatherDescription(){
        return getWeatherConditionJsonObject().get("description").toString();
    }
    

}
