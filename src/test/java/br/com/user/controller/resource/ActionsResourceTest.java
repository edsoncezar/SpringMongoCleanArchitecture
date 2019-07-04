package br.com.user.controller.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.user.controller.request.UsersResourceRequest;
import br.com.user.controller.resource.ActionResource;

@RunWith(MockitoJUnitRunner.class)
public class ActionsResourceTest {

    @Test
    public void testShoudReturnAdd() {
	Assert.assertEquals(ActionResource.ADD, ActionResource.fromString("ADD"));
    }

    @Test
    public void testShoudReturnRemove() {
	Assert.assertEquals(ActionResource.REMOVE, ActionResource.fromString("REMOVE"));
    }

    @Test
    public void testShoudReturnNull() {
	Assert.assertEquals(null, ActionResource.fromString("aa"));
    }

    @Test
    public void testShoudVerifyEnumList() {
	Assert.assertEquals(2, ActionResource.values().length);
    }

    @Test
    public void testIfActionIsAdd() {
	final var action = UsersResourceRequest.builder().action(ActionResource.ADD).build();
	Assert.assertTrue(ActionResource.isAdd(action));
    }

    @Test
    public void testIfActionIsNotAdd() {
	final var action = UsersResourceRequest.builder().action(null).build();
	Assert.assertFalse(ActionResource.isAdd(action));
    }

    @Test
    public void testIfRemoveIsAdd() {
	final var action = UsersResourceRequest.builder().action(ActionResource.REMOVE).build();
	Assert.assertTrue(ActionResource.isRemove(action));
    }

    @Test
    public void testIfRemoveIsNotAdd() {
	final var action = UsersResourceRequest.builder().action(null).build();
	Assert.assertFalse(ActionResource.isRemove(action));
    }

    @Test
    public void testGetName() {
	Assert.assertEquals("Add", ActionResource.ADD.getName());
    }

}