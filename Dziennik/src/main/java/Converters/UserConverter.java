package Converters;

import Modele.User;
import modelFX.UserFx;

public class UserConverter {
    public static UserFx convertToUserFx(User user){
        UserFx userFx = new UserFx();
        userFx.setUserId(user.getUserId());
        userFx.setUsername(user.getUsername());
        userFx.setPassword(user.getPasswrd());
        userFx.setLinkedAcc(user.getLinkedAcc());

        return userFx;
    }

    public static User convertToUser(UserFx userFx){
        User user = new User();
        user.setUserId(userFx.getUserId());
        user.setUsername(userFx.getUsername());
        user.setPasswrd(userFx.getUsername());
        user.setLinkedAcc(userFx.getLinkedAcc());
        return user;
    }
}
