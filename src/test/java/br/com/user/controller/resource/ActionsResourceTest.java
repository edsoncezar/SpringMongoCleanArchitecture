/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
package br.com.user.controller.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.user.controller.request.UsersResourceRequest;


/**
 * The Class ActionsResourceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class ActionsResourceTest {

    /**
     * Test shoud return add.
     */
    @Test
    public void testShoudReturnAdd() {
	Assert.assertEquals(ActionResource.ADD, ActionResource.fromString("ADD"));
    }

    /**
     * Test shoud return remove.
     */
    @Test
    public void testShoudReturnRemove() {
	Assert.assertEquals(ActionResource.REMOVE, ActionResource.fromString("REMOVE"));
    }

    /**
     * Test shoud return null.
     */
    @Test
    public void testShoudReturnNull() {
	Assert.assertEquals(null, ActionResource.fromString("aa"));
    }

    /**
     * Test shoud verify enum list.
     */
    @Test
    public void testShoudVerifyEnumList() {
	Assert.assertEquals(2, ActionResource.values().length);
    }

    /**
     * Test if action is add.
     */
    @Test
    public void testIfActionIsAdd() {
	final var action = UsersResourceRequest.builder().action(ActionResource.ADD).build();
	Assert.assertTrue(ActionResource.isAdd(action));
    }

    /**
     * Test if action is not add.
     */
    @Test
    public void testIfActionIsNotAdd() {
	final var action = UsersResourceRequest.builder().action(null).build();
	Assert.assertFalse(ActionResource.isAdd(action));
    }

    /**
     * Test if remove is add.
     */
    @Test
    public void testIfRemoveIsAdd() {
	final var action = UsersResourceRequest.builder().action(ActionResource.REMOVE).build();
	Assert.assertTrue(ActionResource.isRemove(action));
    }

    /**
     * Test if remove is not add.
     */
    @Test
    public void testIfRemoveIsNotAdd() {
	final var action = UsersResourceRequest.builder().action(null).build();
	Assert.assertFalse(ActionResource.isRemove(action));
    }

    /**
     * Test get name.
     */
    @Test
    public void testGetName() {
	Assert.assertEquals("Add", ActionResource.ADD.getName());
    }

}