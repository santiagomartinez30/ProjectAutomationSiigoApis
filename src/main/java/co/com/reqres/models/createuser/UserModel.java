package co.com.reqres.models.createuser;

import lombok.Data;

@Data
public class UserModel {
    private String name;
    private String job;
    private String id;
    private String createdAt;
    private String updatedAt;
}
