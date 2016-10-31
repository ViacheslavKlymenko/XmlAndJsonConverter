package inputData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "All-users")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputUsers {

    @XmlElement(name = "user")
    private List<InputUser> users = new ArrayList<>();

    public void addUser(InputUser user) {
        users.add(user);
    }

    public List<InputUser> getUsers() {
        return users;
    }

    public void setUsers(List<InputUser> users) {
        this.users = users;
    }
}
