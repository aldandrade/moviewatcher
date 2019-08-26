package com.movie.watcher.watcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class WatcherApplicationTests {
	@Autowired
	private TestEntityManager entityManager;
	//@Autowired
	//private MovieDAO movieDAO;
	@Test
	public void contextLoads() {

	}

}
