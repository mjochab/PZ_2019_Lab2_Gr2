package modelFX;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserFx {
    private SimpleLongProperty userId = new SimpleLongProperty();
    private SimpleStringProperty username = new SimpleStringProperty();
    private SimpleStringProperty password = new SimpleStringProperty();
    private SimpleStringProperty linkedAcc = new SimpleStringProperty();

    public long getUserId() {
        return userId.get();
    }

    public SimpleLongProperty userIdProperty() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId.set(userId);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getLinkedAcc() {
        return linkedAcc.get();
    }

    public SimpleStringProperty linkedAccProperty() {
        return linkedAcc;
    }

    public void setLinkedAcc(String linkedAcc) {
        this.linkedAcc.set(linkedAcc);
    }

    @Override
    public String toString() {
        return "UserFx{" +
                "userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", linkedAcc=" + linkedAcc +
                '}';
    }
}
