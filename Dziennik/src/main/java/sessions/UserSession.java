package sessions;

import Modele.User;

public class UserSession {
    private final static UserSession instance = new UserSession();

    public static UserSession getInstance(){
        return instance;
    }

    private User user = new User();

    public User currentUser(){
        return user;
    }
    public void setCurrentUser(User user){
        this.user = user;
    }

}
