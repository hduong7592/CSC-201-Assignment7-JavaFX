package sample;
import javafx.scene.control.*;
import javafx.fxml.FXML;

public class Controller {
    @FXML private Button SubmitBtn;
    @FXML private TextField InputText;
    @FXML private Label CurrentIndexLB;
    @FXML private Label OriginalArrayLB;
    @FXML private Label SortedArrayLB;
    @FXML private Label FinalArrayLB;
    @FXML private int CIndex;
    @FXML private int[] OriginalArray;

    /**
     * Initialize Array
     */
    @FXML private void initialize(){
        SetCurrentIndex(0);
        InitializeArray();
    }

    /**
     * Initialize Array
     */

    @FXML private void InitializeArray() {
        OriginalArray = new int[10];
    }

    /**
     * This method will be invoked when SubmitBtn is clicked
     */
    @FXML private void SubmitBtn_Click(){

        int CurrentIndexValue = GetCurrentIndex();
        if(CurrentIndexValue < 10) {
            CurrentIndexLB.setText(CurrentIndexValue + "");

            String input = InputText.getText();

            try {
                int RealNumber = Integer.parseInt(input);
                AddValueToArray(CurrentIndexValue, RealNumber);
                CurrentIndexValue++;
                SetCurrentIndex(CurrentIndexValue);
                InputText.setText("");
                InputText.requestFocus();
                OriginalArrayLB.setText(DisplayArray(getArray()));
            } catch (Exception e) {
                infoBox("Input is not a real value!", "Error", null);
                InputText.setText("");
                InputText.requestFocus();
            }
        }
        else
        {
            infoBox("You have reached the limit of the array.",null,null);
            InputText.setText("");
            SubmitBtn.setDisable(true);
            int[] Array = getArray();
            int[] SortedArray = SortArray(Array);
            int[] FinalArray = EliminateDuplicates(SortedArray);
            SortedArrayLB.setText(DisplayArray(SortedArray));
            FinalArrayLB.setText(DisplayArray(FinalArray));
        }
    }

    /**
     * Sort the array
     * @param list
     * @return
     */
    @FXML private int[] SortArray(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }

        return list;
    }

    /**
     * Elimilate duplicates
     * @param list
     * @return
     */
    @FXML public int[] EliminateDuplicates(int[] list) {

        int CurrentIndex=0;
        list[CurrentIndex]=list[0];
        for(int i=0;i<list.length;i++)
        {
            //If the current index value is the same with compared value, do nothing
            //Else replace current index value with compared value
            //Then increment current index by one and keep checking
            if (list[CurrentIndex]!=list[i])
            {
                CurrentIndex++;
                list[CurrentIndex]=list[i];
            }
        }

        int[] nonDuplicatesArray = new int[CurrentIndex+1];
        for (int i=0;i<=CurrentIndex;i++ )
        {
            nonDuplicatesArray[i] = list[i];
        }

        return nonDuplicatesArray;
    }

    /**
     * Display Array
     * @param list
     * @return
     */
    @FXML private String DisplayArray(int[] list) {

        String ArrayValue = "";
        if(list.length > 0)
        {
            for(int value:list){
                ArrayValue += value +" ";
            }
        }
        return ArrayValue;
    }

    @FXML private int[] getArray(){
        return OriginalArray;
    }

    @FXML private void AddValueToArray(int currentIndexValue, int realNumber) {
        OriginalArray[currentIndexValue] = realNumber;
    }

    @FXML private void SetCurrentIndex(int CurrentIndexValue){
        CIndex = CurrentIndexValue;
    }

    @FXML private int GetCurrentIndex(){
        return CIndex;
    }

    /**
     * This method will show the alert box
     * @param infoMessage
     * @param titleBar
     * @param headerMessage
     */
    @FXML private void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

}
