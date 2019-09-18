import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvToObjConverter {
    private String filePath = "";
    private BufferedReader csvReader = null;
    public CsvToObjConverter(){}

    public String getFilePath() {
        return filePath;
    }

    public void initFileReader(String filePath) {
        this.filePath = filePath;

    }

    public void readFile(){
        String row = "";
        System.out.println(this.filePath);
        try {
            csvReader = new BufferedReader(new FileReader(this.filePath));
            while ((row = csvReader.readLine()) != null) {
//                String[] data = row.split(",");
                System.out.println(row);
            }
            csvReader.close();
        } catch (IOException e) {
            System.out.println("The file provided was not found");
        }
    }

    public void convertFileToObjs(){

    }
}
