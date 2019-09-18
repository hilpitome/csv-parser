public class Main {

    public static void main(String[] args) {
        CsvToObjConverter converter = new CsvToObjConverter();
        converter.setFilePath("C2ImportCalEventSample.csv");
        converter.readFile();

    }
}
