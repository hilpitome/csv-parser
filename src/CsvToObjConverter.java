import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CsvToObjConverter {
    private String filePath = "";
    private BufferedReader csvReader = null;
    private String delimiter = null;
    public CsvToObjConverter(){}

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
//                String[] data = row.split(",");
                if(index==0){
                    // create header row
                    convertHeadersToUnderscoreKeys(row);

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
        System.out.println(Arrays.toString(headerRowArrPascaled));
        return  headerRowArrPascaled;

    }

    private String insertUnderscores(String text) {
       return String.join("_", text.toLowerCase().split(" "));
    }
}
