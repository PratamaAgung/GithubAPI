package test.model;

import com.company.model.Repo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pratama Agung on 6/23/2017.
 */
public class RepoTest {
    Repo myRepo;

    @Before
    public void setup(){
        myRepo = new Repo("githubAPI", "ini repo github", "http://github.com");
    }


    @Test
    public void getName() throws Exception {
        assertEquals("githubAPI", myRepo.getName());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("ini repo github", myRepo.getDescription());
    }

    @Test
    public void getUrl() throws Exception {
        assertEquals("http://github.com", myRepo.getUrl());
    }

}