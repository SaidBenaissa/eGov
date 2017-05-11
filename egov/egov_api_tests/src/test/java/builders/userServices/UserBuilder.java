package builders.userServices;

import entities.requests.userServices.Roles;
import entities.requests.userServices.User;

public class UserBuilder {

   User user = new User();
   Roles[] roles = new Roles[1];
   Roles role1 = new RolesBuilder().build();

   public UserBuilder(){
       user.setPassword("12345");
       user.setSalutation("Mrs");
       user.setName("Testing");
       user.setGender("MALE");
       user.setMobileNumber("9999999999");
       user.setEmailId("Tester@Testing.com");
       user.setDob("20/02/1990");
       user.setLocale("en_IN");
       user.setType("CITIZEN");
       user.setAccountLocked(false);
       user.setTenantId("default");
       roles[0] = role1;
       user.setRoles(roles);
   }

   public UserBuilder withUserName(String userName){
       user.setUserName(userName);
       return this;
   }

   public User build(){
       return user;
   }
}

