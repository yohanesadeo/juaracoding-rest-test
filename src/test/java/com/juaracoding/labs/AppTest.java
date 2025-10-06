package com.juaracoding.labs;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.labs.model.Group;
import com.juaracoding.labs.service.GroupService;
import io.restassured.response.ValidatableResponse;

public class AppTest {
  private Group group;
  
  @Test(priority = 1, enabled = false)
  public void getListGroupTest() {
    GroupService groupService = new GroupService();
    ValidatableResponse validatorResponse = groupService.all().then();
    validatorResponse.statusCode(200);
  }

  @Test(priority = 2)
  public void createGroupTest() {
    GroupService groupService = new GroupService();
    group = new Group("Ayam", "Rumah Makan Ayam Goreng");

    group = groupService.create(group);

    Assert.assertEquals(group.getTitle(), "Ayam");
    Assert.assertEquals(group.getOrigin(), "Rumah Makan Ayam Goreng");
    Assert.assertNotNull(group.getId());
    Assert.assertNotNull(group.getCreated_at());
    Assert.assertNotNull(group.getUpdated_at());
  }

  @Test(priority = 3)
  public void updateGroupTest() {
    GroupService groupService = new GroupService();

    group.setOrigin("Rumah Makan Madura");
    group = groupService.update(group);

    Assert.assertEquals(group.getOrigin(), "Rumah Makan Madura");
  }

  @Test(priority = 4)
  public void deleteGroupTest() {
    GroupService groupService = new GroupService();
    int statusCode = groupService.remove(group.getId());
    Assert.assertEquals(statusCode, 204);
  }
}
