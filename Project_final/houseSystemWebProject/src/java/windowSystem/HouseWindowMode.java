package windowSystem;

public enum HouseWindowMode {

    CLOSE_0("https://s3.us-east-2.amazonaws.com/chenxh/0close.png", "0 percent Closed"),
    CLOSE_25("https://s3.us-east-2.amazonaws.com/chenxh/25close.png", "25 percent Closed"),
    CLOSE_50("https://s3.us-east-2.amazonaws.com/chenxh/50close.png", "50 percent Closed"),
    CLOSE_75("https://s3.us-east-2.amazonaws.com/chenxh/75close.png", "75 percent Closed"),
    CLOSE_100("https://s3.us-east-2.amazonaws.com/chenxh/100close.png", "100 percent Closed");

    private String houseWindowsModelDisplayURL;
    private String houseWindowsStatus;

    private HouseWindowMode(String URL, String status) {
        houseWindowsModelDisplayURL = URL;
        houseWindowsStatus = status;
    }

    public String getHouseWindowsModelDisplayURL() {
        return houseWindowsModelDisplayURL;
    }

    public String getHouseWindowsStatus() {
        return houseWindowsStatus;
    }
}
