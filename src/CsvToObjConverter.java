import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvToObjConverter {
    private String filePath = "";
    private BufferedReader csvReader = null;
    private String delimiter = null;
    private String[] columnKeys;
    private List<DataObjectWrapper> customObjectList;
    public CsvToObjConverter(){
        customObjectList = new ArrayList<>();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setDelimiter(String delimiter){
        this.delimiter = delimiter;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;

    }

    public void readFile(){
        String row = "";
        System.out.println(this.filePath);
        try {
            csvReader = new BufferedReader(new FileReader(this.filePath));
            int index = 0;
            while ((row = csvReader.readLine()) != null) {
                if(index==0){
                    // create header row
                    this.columnKeys = convertHeadersToUnderscoreKeys(row);
                } else {
                    String[] data = row.split(delimiter);

                    // create objects from the other raws
                    DataObjectWrapper obj = new DataObjectWrapper();
                    int j = 0;
                    for (String k:this.columnKeys){
                        obj.add(k, data[j]); // add current key value pair
                        j++;
                    }
                    System.out.println(obj.objToString());
                    customObjectList.add(obj); // add current obj to custom list of objects

                }
                index++;
            }
            csvReader.close();
        } catch (IOException e) {
            System.out.println("The file provided was not found");
        }
    }

    public void convertFileToObjs(){

    }

    /**
     * @param row header row of the csv not yet split by the delimeter
     * @return String[] of strings with underscores
     */
    public String[] convertHeadersToUnderscoreKeys(String row){

        String[] headerRowArr = row.split(delimiter);
        System.out.println(Arrays.toString(headerRowArr));
        String[] headerRowArrPascaled = new String[headerRowArr.length];
        for(int i = 0; i < headerRowArr.length; i++ ){

            headerRowArrPascaled[i] = insertUnderscores(headerRowArr[i]);

        }
        return  headerRowArrPascaled;

    }

    private String insertUnderscores(String text) {
       return String.join("_", text.toLowerCase().split(" "));
    }
}
