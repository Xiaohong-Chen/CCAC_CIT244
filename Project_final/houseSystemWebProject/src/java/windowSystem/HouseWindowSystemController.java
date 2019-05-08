package windowSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(eager = true)
@SessionScoped
public class HouseWindowSystemController extends HouseWindowSystem {
    
    //Declaring the variable
    private HouseWindowMode windowMode;
    private String mostRecentWindowModeStatus;
    private String HouseWindowModelDisplayURL="https://s3.us-east-2.amazonaws.com/chenxh/loading.gif";
    private List<HouseWindowSystem> houseWindowSystemList;
    
    //Creating a WeatherInformation Object to gather weather infomation
    WeatherInformation weatherInformation = new WeatherInformation();

    //Constructor
    public HouseWindowSystemController() {

    }

    //Getting the Window Mode
    public HouseWindowMode getWindowMode() {
        return windowMode;
    }

    //Setting Automatic Mode 
    public void setAutomaticWindowMode() {
        //Setting the autoModeStatus as ON
        autoModeStatus = "on";
        //Getting the weatherConditionID
        weatherConditionID = weatherInformation.getWeatherConditionID();

        //Setting the Mode by Dictecting the weatherConditionID
        //200<weatherConditionID<300 represent Thunderstorm
        //300<weatherConditionID<400 represent Drizzle
        //500<weatherConditionID<600 represent Rain
        //600<weatherConditionID<700 represent Snow
        //700<weatherConditionID<800 represent Atmosphere
        //800<weatherConditionID<900 represent Cloud and Clear
        if (weatherConditionID >= 200 && weatherConditionID < 300) {
            windowMode = HouseWindowMode.CLOSE_100;
        } else if (weatherConditionID >= 300 && weatherConditionID < 400) {
            windowMode = HouseWindowMode.CLOSE_50;
        } else if (weatherConditionID == 500) {
            windowMode = HouseWindowMode.CLOSE_75;
        } else if (weatherConditionID > 500 && weatherConditionID < 600) {
            windowMode = HouseWindowMode.CLOSE_100;
        } else if (weatherConditionID >= 600 && weatherConditionID < 700) {
            windowMode = HouseWindowMode.CLOSE_100;
        } else if (weatherConditionID >= 700 && weatherConditionID < 800) {
            windowMode = HouseWindowMode.CLOSE_100;
        } else if (weatherConditionID >= 800 && weatherConditionID < 900) {
            windowMode = HouseWindowMode.CLOSE_0;
        } else {
            windowMode = HouseWindowMode.CLOSE_100;
        }

        try {
            //Getting the most recent mode status in database
            String tempModeStatus = getMostRecentWindowModeStatus();
            //Getting th current mode status from weather API
            String currentMode = windowMode.getHouseWindowsStatus();
            
            //Checking whether the modes are different or not
            if (!tempModeStatus.equals(currentMode)) {
                //recording the Mode if the mode is diffent
                recordWeatherIntoDB();
            }
        } catch (Exception ex) {
            recordWeatherIntoDB();
        }
        //Setting the Model Display URL according to the mode
        setHouseWindowModelDisplayURL(windowMode);
    }

    //Setting Manual Mode CLOSE_100
    public void setWindowManualModeCLOSE_100() {
        autoModeStatus = "off";
        windowMode = HouseWindowMode.CLOSE_100;
        recordWeatherIntoDB();
        setHouseWindowModelDisplayURL(windowMode);
    }

    //Setting Manual Mode CLOSE_75
    public void setWindowManualModeCLOSE_75() {
        autoModeStatus = "off";
        windowMode = HouseWindowMode.CLOSE_75;
        recordWeatherIntoDB();
        setHouseWindowModelDisplayURL(windowMode);
    }

    //Setting Manual Mode CLOSE_50
    public void setWindowManualModeCLOSE_50() {
        autoModeStatus = "off";
        windowMode = HouseWindowMode.CLOSE_50;
        recordWeatherIntoDB();
        setHouseWindowModelDisplayURL(windowMode);
    }

    //Setting Manual Mode CLOSE_25
    public void setWindowManualModeCLOSE_25() {
        autoModeStatus = "off";
        windowMode = HouseWindowMode.CLOSE_25;
        recordWeatherIntoDB();
        setHouseWindowModelDisplayURL(windowMode);
    }
    
    //Setting Manual Mode CLOSE_0
    public void setWindowManualModeCLOSE_0() {
        autoModeStatus = "off";
        windowMode = HouseWindowMode.CLOSE_0;
        recordWeatherIntoDB();
        setHouseWindowModelDisplayURL(windowMode);
    }

    //Getting the Model Display URL
    public String getHouseWindowModelDisplayURL() {
        return HouseWindowModelDisplayURL;
    }
    
    //Setting the Model Display URL
    public void setHouseWindowModelDisplayURL(HouseWindowMode hm) {
        HouseWindowModelDisplayURL = hm.getHouseWindowsModelDisplayURL();
    }

    //Creating a method to get the most recent mode status of window mode recorded 
    //in database
    public String getMostRecentWindowModeStatus() {
        //Getting whole data from database
        List<HouseWindowSystem> logInfoList = getHouseWindowSystemList();
        //Return the last one recorded in database
        if (logInfoList.size() < 1) {
            return null;
        } else {
            mostRecentWindowModeStatus = logInfoList.get(logInfoList.size() - 1).status;
            return mostRecentWindowModeStatus;
        }
    }

    //Creating a method to get the current date time
    public String getDatetime() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        return timestamp.toString();
    }

    //Creating a method to record the data into the database
    public void recordWeatherIntoDB() {
        //Creating a connection to the database
        HouseSystemDB hdb = new HouseSystemDB();

        //Getting the properties of House Window System in one certain time
        recordDatetime = getDatetime();
        temperature = (int) weatherInformation.getFahrenheitTemperature();
        weatherCondition = weatherInformation.getWeatherCondition();
        description = weatherInformation.getDescription();
        windSpeed = weatherInformation.getWindSpeed();
        humidity = weatherInformation.getHumidity();
        pressure = weatherInformation.getPressure();
        status = windowMode.getHouseWindowsStatus();

        //Making a connection to the database and use SQL to INSERT data properties 
        //into the database
        Connection con;
        try {
            con = hdb.getDatabaseConnection();
            Statement st = con.createStatement();
            String SQL = "INSERT INTO `housesystem`.`weathers`(`recordDatetime`,`conditonID`,`condition`,`description`,`autoModeStatus`,`status`,`temperature`,`windSpeed`,`humidity`,`pressure`) "
                    + "VALUES ('" + recordDatetime + "','" + weatherConditionID + "','" + weatherCondition + "','" + description + "','" + autoModeStatus + "','" + status + "','" + temperature + "','" + windSpeed + "','" + humidity + "','" + pressure + "')";
            st.executeUpdate(SQL);
            hdb.disconnectDB();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
    }

    //Creating a method to get a list about each property of the window system recorded in the database
    public List<HouseWindowSystem> getHouseWindowSystemList() {
        //Creating a houseWindowSystemList 
        houseWindowSystemList = new ArrayList<HouseWindowSystem>();
        //Initialize HouseSystemDB to make a connection to the database
        HouseSystemDB hdb = new HouseSystemDB();
        //Making a connection to the database and use SQL to select all the item
        //in in the databse
        Connection con;
        try {
            con = hdb.getDatabaseConnection();
            Statement st = con.createStatement();
            String SQL = "SELECT * FROM housesystem.weathers";
            ResultSet rs = st.executeQuery(SQL);
            //Declaring a variable of House Window System 
            HouseWindowSystem hws;
            while (rs.next()) {
                //Initialize an HouseWindowSystem Object
                hws = new HouseWindowSystem();
                //Setting the varable in the HouseWindowSystem Object
                hws.setRecordDatetime(rs.getString("recordDatetime"));
                hws.setWeatherConditionID(rs.getInt("conditonID"));
                hws.setStatus(rs.getString("status"));
                hws.setAutoModeStatus(rs.getString("autoModeStatus"));
                hws.setTemperature(rs.getInt("temperature"));
                hws.setWeatherCondition(rs.getString("condition"));
                hws.setDescription(rs.getString("description"));
                hws.setWindSpeed(rs.getString("windSpeed"));
                hws.setHumidity(rs.getString("humidity"));
                hws.setPressure(rs.getString("pressure"));
                //adding the HouseWindowSystem Object into houseWindowSystemList
                houseWindowSystemList.add(hws);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        //returning an list of HouseWindowSystem
        return houseWindowSystemList;
    }

}
