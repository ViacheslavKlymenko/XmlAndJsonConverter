import fileResources.FileOperation;

public class StartApplication {

    public static void main(String[] args) {

        FormatTransformerRealization formatTransformer = new FormatTransformerRealization();
        FileOperation fileOperation = new FileOperation();

        System.out.println("Convert json file to .xml");
        formatTransformer.csvToXml(fileOperation.getFile());

        System.out.println("Convert .xml to json");
        formatTransformer.xmlToCsv(fileOperation.getFile());
    }
}