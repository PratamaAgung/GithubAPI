package test.model;

import com.company.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pratama Agung on 6/23/2017.
 */
public class UserTest {
    User myUser;
    @Before
    public void setup() {
        myUser = new User("agung", "http://agung.com");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("agung", myUser.getName());
    }

    @Test
    public void getAvatar() throws Exception {
        assertEquals("http://agung.com", myUser.getAvatar());
    }

}