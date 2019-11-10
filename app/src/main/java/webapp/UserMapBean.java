package webapp;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;


@ApplicationScoped
public class UserMapBean {
    HashMap<String, User> userMapBean = new HashMap<String, User>();

    public void add(User user)
    {
        userMapBean.put(user.getUsername(),user);
    }

    public boolean ifThereIs(String username)
    {
        return username.equals(userMapBean.get(username).getUsername());
    }

    public boolean doesPasswordMatch(String username, String password)
    {
        return  password.equals(userMapBean.get(username).getPasswd());
    }
}
