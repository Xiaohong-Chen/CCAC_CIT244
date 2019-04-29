package hoursesystem;

public class HouseWindowsSystem {

    private HouseWindowsMode hwm;

    public HouseWindowsMode getHwm() {
        return hwm;
    }

    public void setHwm(HouseWindowsMode hwm) {
        if (hwm == null) {
            this.hwm = HouseWindowsMode.CLOSE;
        } else {
            this.hwm = hwm;
        }
    }

    public int setHouseWindowsMotorRotationMode() {
        switch (hwm) {
            case OPEN:
                return 0;
            case HALFCLOSE:
                return 5;
            case CLOSE:
                return 10;
            default:
                return 10;
        }
    }
}
