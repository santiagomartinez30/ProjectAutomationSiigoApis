package co.com.reqres.data;

import co.com.reqres.models.createuser.UserModel;
import co.com.reqres.models.createuser.builder.UserModelBuilder;
import com.github.javafaker.Faker;

public class DataUser {
    private static final Faker faker = new Faker();

    private DataUser() {
    }

    public static UserModel correct() {
        return UserModelBuilder.with()
                .name(faker.name().fullName())
                .job(faker.job().title())
                .build();
    }
}
