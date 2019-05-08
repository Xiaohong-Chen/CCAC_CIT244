package windowSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.json.JSONObject;

/**
 * Using the OpenWeatherMap API and JSON-java to get the Pittsburgh current weather 
 * including Temperature, Condition, WindSpeed, Humidity, Pressure, Description, ID
 */
@ManagedBean(eager = true)
@SessionScoped
public class WeatherInformation implements Serializable{

    //Setting the URL
    private final static String API_KEY = "9e09186b4c56079c4d2325124aa8a392";
    private final static String ZIP_CODE = "15232";
    private static final String urlString = "http://api.openweathermap.org/data/2.5/weather?zip=" + ZIP_CODE + ",us&APPID=" + API_KEY;

    //Declaring the variable
    private int weatherConditionID;
    private long fahrenheitTemperature;
    private String weatherCondition;
    private String windSpeed;
    private String humidity;
    private String pressure;
    private String description;

    //Using the Construtor to set the variable
    public WeatherInformation() {
        setWeatherConditionID();
        setWeatherCondition();
        setFahrenheitTemperature();
        setDescription();
        setWindSpeed();
        setHumidity();
        setPressure();
    }

    //Getting the weatherConditionID
    public int getWeatherConditionID() {
        return weatherConditionID;
    }

    //Setting the weatherConditionID
    public void setWeatherConditionID() {
        weatherConditionID = getWeatherConditionJsonObject().getInt("id");
    }

    //Getting the weatherCondition
    public String getWeatherCondition() {
        return weatherCondition;
    }

    //Setting the weatherCondition
    public void setWeatherCondition() {
        weatherCondition = getWeatherConditionJsonObject().get("main").toString();
    }

    //Getting the Conditon description
    public String getDescription() {
        return description;
    }

    //Setting the Conditon description
    public void setDescription() {
        description = getWeatherConditionJsonObject().getString("description");
    }

    //Getting the fahrenheitTemperature
    public long getFahrenheitTemperature() {
        return fahrenheitTemperature;
    }

    //Setting the fahrenheitTemperature
    public void setFahrenheitTemperature() {
        //Convert KelvinT emperature into Fahrenheit Temperature
        double KelvinTemperature = Double.parseDouble(getTemperatureJsonObject().get("temp").toString());
        fahrenheitTemperature = convertKelvinToFahrenheit(KelvinTemperature);
    }

    //Getting the windSpeed
    public String getWindSpeed() {
        return windSpeed;
    }

    //Setting the windSpeed
    public void setWindSpeed() {
        windSpeed = getWindJsonObject().get("speed").toString();
    }

    //Getting the  humidity
    public String getHumidity() {
        return humidity;
    }

    //Setting the humidity
    public void setHumidity() {
        humidity = getTemperatureJsonObject().get("humidity").toString();
    }

    //Getting the pressure
    public String getPressure() {
        return pressure;
    }

    //Setting the pressure
    public void setPressure() {
        pressure = getTemperatureJsonObject().get("pressure").toString();
    }

    //Getting the whole weather JSON Object from the API 
    private static JSONObject getWeatherJsonObject() {
        try {
            //Declaring the API url
            URL url = new URL(urlString);
            //Creating an URLConnection to use the getInputStream() method to get the InputStream
            URLConnection conn = url.openConnection();
            //Getting the InputStream
            InputStream inputStream = conn.getInputStream();
            //Read the InputStream 
            InputStreamReader isr = new InputStreamReader(inputStream);
            //Using the BufferedReader to read each line of the InputStream
            BufferedReader bufr = new BufferedReader(isr);
            String r = bufr.readLine();
            //Creating An general weather JSONObject 
            JSONObject myWeatherJsonObject = new JSONObject(r);
            //Return the general weather JSONObject 
            return myWeatherJsonObject;
        } catch (MalformedURLException ex) {
            System.out.println("URL Exception");
            return null;
        } catch (IOException ex) {
            System.out.println("IO Exception");
            return null;
        }
    }

    //Creating an getTemperatureJsonObject() to get the Temperature JSONObject
    private static JSONObject getTemperatureJsonObject() {
        String tempString = getWeatherJsonObject().get("main").toString();
        return new JSONObject(tempString);
    }

    //Creating an getWeatherConditionJsonObject() to get the Temperature Conditon JSONObject
    private static JSONObject getWeatherConditionJsonObject() {
        String weatherStatus = getWeatherJsonObject().getJSONArray("weather").get(0).toString();
        return new JSONObject(weatherStatus);
    }

    //Creating an getWindJsonObject() to get the Wind JSONObject
    private static JSONObject getWindJsonObject() {
        String windStatus = getWeatherJsonObject().get("wind").toString();
        return new JSONObject(windStatus);
    }

    //Creating an convertKelvinToFahrenheit() to Convert KelvinT emperature into Fahrenheit Temperature
    private long convertKelvinToFahrenheit(double KelvinTemperature) {
        return Math.round((KelvinTemperature - 273.15) * 9 / 5 + 32);
    }

}
