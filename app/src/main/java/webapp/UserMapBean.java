package webapp;

import java.util.HashMap;

public class UserMapBean {
    HashMap<String, User> userMapBean = new HashMap<String, User>();

    public void add(User user) //adding user to hashMap
    {
        userMapBean.put(user.getUsername(),user);
    }

    public String getUsername(String username) //getting nickname from hashMap
    {
        return userMapBean.get(username).getUsername();
    }

    public boolean ifThereIs(String username) //checking if there's key using "String username"
    {
        return username.equals(userMapBean.get(username).getUsername());
    }

    public boolean doesPasswordMatch(String username, String password) //checking that password match
    {
        return  password.equals(userMapBean.get(username).getPasswd());
    }
}
