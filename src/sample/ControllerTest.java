package sample;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ControllerTest {
    @org.junit.Test
    public void eliminateDuplicates() {
        int[] TestArray = {1,4,2,1,2,3,6,7,8,10};
        int[] ExpectedArray = {1,2,3,4,6,7,8,10};

        int[] SortedArray = Controller.SortArray(TestArray);
        int[] NonDuplicateArray = Controller.EliminateDuplicates(SortedArray);

        Assert.assertArrayEquals("Error!",ExpectedArray, NonDuplicateArray);
        String Result = "";
        for(int i=0; i<NonDuplicateArray.length; i++)
        {
            Result += NonDuplicateArray[i]+" ";
        }
        System.out.println("Result: "+Result);
    }

}