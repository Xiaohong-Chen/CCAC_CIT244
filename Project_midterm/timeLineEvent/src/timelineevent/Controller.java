package timelineevent;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {

    public void execute() {
        
        //Creating an instance of Model to Write and Read the data from text
        Model dataModel = new Model();
        
        //looping the function until System is closed
        boolean controlLoop = true;
        while (controlLoop) {
            try {
                
                //Creating an instance of View_DataInput
                View_DataInput input = new View_DataInput();
                //Creating an instance of View_DataOutput
                View_DataOutput output = new View_DataOutput();
                
                //Checking the Choices
                input.choiseInput();
                switch (input.choise) {
                    case 1:
                        input.computerSystemInput();
                        while (input.submitControl) {
                            System.out.println("Wait.......");
                            System.out.close();
                        }
                        if (!input.backControl == false) {
                            ComputerSystem cs = new ComputerSystem(input);
                            dataModel.writeComputerSystem(cs);
                            break;
                        }
                        break;
                    case 2:
                        input.computerHardwareInput();
                        while (input.submitControl) {
                            System.out.println("Wait.......");
                            System.out.close();
                        }
                        if (!input.backControl == false) {
                            ComputerHardware ch = new ComputerHardware(input);
                            dataModel.writeComputerHardware(ch);
                            break;
                        }
                        break;
                    case 3:
                        input.humanInterestInput();
                        while (input.submitControl) {
                            System.out.println("Wait.......");
                            System.out.close();
                        }
                        if (!input.backControl == false) {
                            HumanInterest hi = new HumanInterest(input);
                            dataModel.writeHumanInterest(hi);
                            break;
                        }
                        break;
                    case 4:
                        output.displayAll(this, dataModel);
                        while(output.backControl == true){
                            System.out.println("Wait.......");
                            System.out.close();
                        }
                        break;
                    default:
                        throw new Exception("Please Input the Valid Number");
                }
            } catch (Exception ex) {
                System.out.println("Please Input the Valid Number");
            }
        }
        dataModel.close();
    }

    public int getDataRow(Model model) throws FileNotFoundException {

        Scanner userOutput = new Scanner(model.getFile());

        int n = 0;
        while (userOutput.hasNextLine()) {
            userOutput.nextLine();
            n = n + 1;
        }
        return n;
    }

    public String[][] readDataFromModel(Model model) throws FileNotFoundException {

        int row = getDataRow(model);

        Scanner userOutput = new Scanner(model.getFile());
        String[][] s = new String[row][];
        int m = 0;
        while (userOutput.hasNextLine()) {
            s[m] = userOutput.nextLine().split(",");
            m = m + 1;
        }

        return s;

    }

    public TimelineEvent[] getTimelineEventArray(Model m) throws Exception {

        String[][] s = readDataFromModel(m);

        TimelineEvent[] teArray = new TimelineEvent[s.length - 1];

        for (int i = 1; i < s.length; i++) {

            if ("HumanInterest".equals(s[i][0])) {
                View v = new View();

                v.tpye = s[i][0];
                v.title = s[i][1];
                v.year = Integer.parseInt(s[i][2].trim());
                v.description = s[i][3];

                teArray[i - 1] = new HumanInterest(v);
            } else if ("ComputerSystem".equals(s[i][0])) {
                View v = new View();

                v.tpye = s[i][0];
                v.title = s[i][1];
                v.year = Integer.parseInt(s[i][2].trim());
                v.description = s[i][3];
                v.modelNumber = Integer.parseInt(s[i][4].trim());
                v.manufacturer = s[i][5];
                v.releaseYear = Integer.parseInt(s[i][6].trim());
                v.retailPriceIn2018 = Double.valueOf(s[i][7].trim());
                v.reasonOfChoosing = s[i][8];

                teArray[i - 1] = new ComputerSystem(v);
            } else if ("ComputerHardware".equals(s[i][0])) {
                View v = new View();

                v.tpye = s[i][0];
                v.title = s[i][1];
                v.year = Integer.parseInt(s[i][2].trim());
                v.description = s[i][3];
                v.modelNumber = Integer.parseInt(s[i][4].trim());
                v.manufacturer = s[i][5];
                v.releaseYear = Integer.parseInt(s[i][6].trim());
                v.retailPriceIn2018 = Double.valueOf(s[i][7].trim());
                v.mostImportantSpecifications = s[i][9];

                teArray[i - 1] = new ComputerHardware(v);

            }
        }
        Arrays.sort(teArray);
        return teArray;
    }

}
