package co.com.reqres.models.createuser.builder;

import co.com.reqres.models.createuser.UserModel;

public class UserModelBuilder {
    UserModel userModel;

    private UserModelBuilder() {
        userModel = new UserModel();
    }

    public static UserModelBuilder with() {
        return new UserModelBuilder();
    }

    public UserModelBuilder name(String name) {
        this.userModel.setName(name);
        return this;
    }

    public UserModelBuilder job(String job) {
        this.userModel.setJob(job);
        return this;
    }

    public UserModel build() {
        return userModel;
    }
}
