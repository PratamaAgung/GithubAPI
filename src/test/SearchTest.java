package test;

import com.company.Search;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pratama Agung on 6/23/2017.
 */
public class SearchTest {
    Search searcher;
    @Before
    public void setup(){
        searcher = new Search();
    }

    @Test
    public void urlUserBuilder() throws Exception {
        assertEquals("https://api.github.com/search/users?q=tom+in:login+followers:>1000+repos:>42",
                searcher.urlUserBuilder("tom", 0, true, 1001, true, 43));
    }

    @Test
    public void urlRepoBuilder() throws Exception {
        assertEquals("https://api.github.com/users/mojombo/repos", searcher.urlRepoBuilder("mojombo"));
    }
}