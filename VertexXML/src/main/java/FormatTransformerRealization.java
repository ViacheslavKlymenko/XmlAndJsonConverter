import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import converter.UserConverter;
import fileResources.FileOperation;
import inputData.InputUsers;
import outputData.OutputUsers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

class FormatTransformerRealization implements FormatTransformer {

    public FormatTransformerRealization() {
    }

    public File xmlToCsv(File xmlFile) {
        InputUsers inputUsers = new InputUsers();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(InputUsers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            inputUsers = (InputUsers) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        FileOperation fileOperation = new FileOperation();
        File result = fileOperation.createNewFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        UserConverter converter = new UserConverter();
        OutputUsers outputUser = converter.convertUser(inputUsers);
        String jsonUsers = gson.toJson(outputUser);
        try (FileWriter fileWriter = new FileWriter(result)) {
            fileWriter.write(jsonUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public File csvToXml(File csvFile) {
        InputUsers users = new InputUsers();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            String json = new String(Files.readAllBytes(csvFile.toPath()));
            users = gson.fromJson(json, InputUsers.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOperation fileOperation = new FileOperation();
        File result = fileOperation.createNewFile();
        UserConverter converter = new UserConverter();
        OutputUsers outputUsers = converter.convertUser(users);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OutputUsers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(outputUsers, result);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
