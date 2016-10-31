package outputData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "All-users")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputUsers {

    @XmlElement(name = "user")
    private List<OutputUser> users = new ArrayList<>();

    public void addUser(OutputUser user) {
        users.add(user);
    }

    public List<OutputUser> getUsers() {
        return users;
    }

    public void setUsers(List<OutputUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputUsers)) return false;

        OutputUsers that = (OutputUsers) o;

        return getUsers().equals(that.getUsers());

    }

    @Override
    public int hashCode() {
        return getUsers().hashCode();
    }
}
