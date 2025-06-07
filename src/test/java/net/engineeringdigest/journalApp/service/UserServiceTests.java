package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepo userRepo;

    //there are more annotations like beforeEach,beforeAll,afterEach,afterAll

//    @Disabled
//    @Test
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "vipul"
    })
    public void testFindByUserName(String name){

//        assertEquals(2,2+2);
        assertNotNull(userRepo.findByUserName(name));

    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,4",
            "3,3,9"
    })
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }
}
