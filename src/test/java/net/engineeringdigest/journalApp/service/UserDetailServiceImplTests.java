package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import static org.mockito.Mockito.*;
public class UserDetailServiceImplTests {
    @InjectMocks
    private UserDetailServiceImpl userDetailService;

    @Mock
    private UserRepo userRepo;

    @Test
    void loadUsrByUserNameTest(){
        UserDetails vipul = userDetailService.loadUserByUsername("vipul");

    }
}
