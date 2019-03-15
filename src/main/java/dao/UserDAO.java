package dao;

import model.UserModel;

import java.util.HashMap;

public class UserDAO {
    private final HashMap<String, UserModel> userModelHashMap = new HashMap<String, UserModel>();

    public UserDAO() {
        UserModel userModel1 = new UserModel("abebe", "belay");
        UserModel userModel2 = new UserModel("surafel", "behailu");
        UserModel userModel3 = new UserModel("muluken", "sisay");

        userModelHashMap.put(userModel1.getUsername(), userModel1);
        userModelHashMap.put(userModel2.getUsername(), userModel1);
        userModelHashMap.put(userModel3.getUsername(), userModel1);
    }

    public UserModel addUser(UserModel userModel) {
        userModelHashMap.put(userModel.getUsername(), userModel);
        return userModel;
    }

    public UserModel getUser(String username, String password) {
        UserModel userModel = userModelHashMap.get(username);

        if (username.equals(userModel.getUsername()) && password.equals(userModel.getPassword())) {
            return userModel;
        }

        return null;
    }

    public boolean authenticateUser(String username, String password) {
        UserModel userModel = userModelHashMap.get(username);
        if (userModel == null) {
            return false;
        } else {
            return username.equals(userModel.getUsername()) && password.equals(userModel.getPassword());
        }
    }
}
