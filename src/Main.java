public class Main {

    public static void main(String[] args) {
        CsvToObjConverter converter = new CsvToObjConverter();
        converter.initFileReader("C2ImportFamRelSample.csv");
        converter.readFile();

    }
}
