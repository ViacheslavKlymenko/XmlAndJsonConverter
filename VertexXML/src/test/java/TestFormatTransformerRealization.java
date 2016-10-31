import org.junit.*;
import org.mockito.Mock;

import java.io.File;

public class TestFormatTransformerRealization {

    private FormatTransformerRealization formatTransformerRealization;
    @Mock
    private static File xmlFile;
    private static File jsonFile;

    @BeforeClass
    public static void init() {
        xmlFile = new File("D:\\VertexHome\\src\\main\\resources\\xmlFile.xml");
        jsonFile = new File("D:\\VertexHome\\src\\main\\resources\\jsonFile.txt");
    }

    @Test(expected = NullPointerException.class)
    public void testCsvToCsvReturnNullPointExeption(){
        formatTransformerRealization.csvToXml(null);
    }

    @Test
    public void testCsvToCsvNotReturnNullPointExeption(){
        Assert.assertTrue(jsonFile.exists());
    }

    @Test(expected = NullPointerException.class)
    public void testXmlToCsvReturnNullPointExeption(){
        formatTransformerRealization.xmlToCsv(null);
    }
}
