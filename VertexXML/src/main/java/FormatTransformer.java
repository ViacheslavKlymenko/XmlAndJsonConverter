import java.io.File;

public interface FormatTransformer {

    File xmlToCsv (File xmlFile);

    File csvToXml (File csvFile);
}
