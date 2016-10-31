import converter.UserConverter;
import inputData.*;
import org.junit.*;
import outputData.*;


public class TestUserConverter {
    private static UserConverter converter;
    private static InputUsers inputUsers;
    private OutputUsers outputUserConverterResult;
    private OutputUsers outputUsersForTest;

    @BeforeClass
    public static void init() {
        converter = new UserConverter();
        inputUsers = new InputUsers();
        inputUsers.addUser(new InputUser("Vasia","Petrov",1,"AAAA","1111"));
    }

    @Test(expected = NullPointerException.class)
    public void testConvertUserReturnNullPointerExeption() {
        converter.convertUser(null);
    }

    @Test
    public void testConvertUserReturnNotNoll() {
        Assert.assertNotNull(converter.convertUser(inputUsers));
    }

    @Test
    public void testConvertUserReturnOutputUsers() {
        Assert.assertNotNull(converter.convertUser(inputUsers));
    }

    @Test
    public void testConvertUserNotReturnNullPointerExeption() {
        converter.convertUser(inputUsers);
    }

    @Test
    public void testConvertUserReturnEquelsOtputUser() {
        outputUsersForTest = new OutputUsers();
        outputUsersForTest.addUser(new OutputUser("Vasia Petrov",1,"AAAA","1111"));
        outputUserConverterResult = converter.convertUser(inputUsers);
        Assert.assertEquals(outputUsersForTest,outputUserConverterResult);
    }

    @Test
    public void testConvertUserReturnNotEquelsOtputUser() {
        outputUsersForTest = new OutputUsers();
        outputUsersForTest.addUser(new OutputUser("VasiaPetrov",1,"AAAA","1111"));
        outputUserConverterResult = converter.convertUser(inputUsers);
        Assert.assertNotEquals(outputUsersForTest,outputUserConverterResult);
    }
    @AfterClass
    public static void close(){
        converter = null;
        inputUsers = null;
    }
}
