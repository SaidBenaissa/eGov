package builders.userServices;

import entities.requests.userServices.Roles;

public class RolesBuilder {

    Roles roles = new Roles();

    public RolesBuilder(){
        roles.setCode("CITIZEN");
        roles.setDescription("Technical Lead for HR & Other Modules");
    }

    public Roles build(){
        return roles;
    }
}
