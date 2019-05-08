package windowSystem;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Creating an class about the properties of house window system including
 * recordDatetime,autoModeStatus, weatherConditionID, temperature,
 * weatherCondition, description,windSpeed, humidity, pressure, status
 */
@ManagedBean
@SessionScoped
public class HouseWindowSystem implements Serializable {

    //Declaring the variable
    String recordDatetime;
    int weatherConditionID;
    String status;
    String autoModeStatus;
    int temperature;
    String weatherCondition;
    String description;
    String windSpeed;
    String humidity;
    String pressure;

    //Getting variable
    public String getDescription() {
        return description;
    }

    //Setting variable
    public void setDescription(String description) {
        this.description = description;
    }

    //Getting variable
    public int getWeatherConditionID() {
        return weatherConditionID;
    }

    //Setting variable
    public void setWeatherConditionID(int weatherConditionID) {
        this.weatherConditionID = weatherConditionID;
    }

    //Getting variable
    public String getAutoModeStatus() {
        return autoModeStatus;
    }

    //Setting variable
    public void setAutoModeStatus(String autoModeStatus) {
        this.autoModeStatus = autoModeStatus;
    }

    //Getting variable
    public String getRecordDatetime() {
        return recordDatetime;
    }

    //Setting variable
    public void setRecordDatetime(String recordDatetime) {
        this.recordDatetime = recordDatetime;
    }

    //Getting variable
    public int getTemperature() {
        return temperature;
    }

    //Setting variable
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //Getting variable
    public String getWeatherCondition() {
        return weatherCondition;
    }
    //Setting variable

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    //Getting variable
    public String getWindSpeed() {
        return windSpeed;
    }

    //Setting variable
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    //Getting variable
    public String getHumidity() {
        return humidity;
    }

    //Setting variable
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    //Getting variable
    public String getPressure() {
        return pressure;
    }

    //Setting variable
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    //Getting variable
    public String getStatus() {
        return status;
    }

    //Setting variable
    public void setStatus(String status) {
        this.status = status;
    }

}
