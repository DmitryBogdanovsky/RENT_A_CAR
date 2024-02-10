package my.service;

import my.dto.user.UserDetailsDto;
import my.dto.user.UserRequestDto;
import my.exception.MyException;
import my.model.user.User;
import my.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Spy
    ModelMapper modelMapper = new ModelMapper();
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl targetObject;

    public UserServiceImplTest() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Test
    public void addNewUserShouldThrowOnDuplicateId() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(1);
        userRequestDto.setUserDetails(new UserDetailsDto());
        userRequestDto.getUserDetails().setPhoneNumber("+375291112233");

        // When
        when(userRepository.existsById(userRequestDto.getId()))
                .thenReturn(true);

        // Then
        assertThrows(MyException.class, () -> targetObject.addUser(userRequestDto));
    }


    @Test
    public void addNewUserShouldThrowOnDuplicateEmail() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(1);
        userRequestDto.setEmail("user@user.com");
        userRequestDto.setUserDetails(new UserDetailsDto());
        userRequestDto.getUserDetails().setPhoneNumber("+375291112233");

        // When
        when(userRepository.existsByEmail(userRequestDto.getEmail()))
                .thenReturn(true);

        // Then
        assertThrows(MyException.class, () -> targetObject.addUser(userRequestDto));
    }

    @Test
    public void updateUserShouldThrowWhenUserDoesNotExist() {

        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(1);

        // When
        when(userRepository.existsById(userRequestDto.getId()))
                .thenReturn(false);

        // Then
        Exception exception = assertThrows(MyException.class, () -> targetObject.updateUser(userRequestDto));
        assertEquals(exception.getMessage(), "User not found!: " + userRequestDto.getId());
    }

    @Test
    public void updateUserCallDao() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(1);

        // When
        when(userRepository.existsById(userRequestDto.getId()))
                .thenReturn(true);
        when(userRepository.save(any())).thenReturn(new User());
        targetObject.updateUser(userRequestDto);

        // Then
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(argument.capture());
        assertEquals(userRequestDto.getId(), argument.getValue().getId());
    }


    @Test
    public void addNewUserShouldThrowOnDuplicatePhoneNumber() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(1);
        userRequestDto.setEmail("user@user.com");
        userRequestDto.setUserDetails(new UserDetailsDto());
        userRequestDto.getUserDetails().setPhoneNumber("+375291112233");

        // When
        when(userRepository.existsByUserDetails_PhoneNumber(userRequestDto.getUserDetails().getPhoneNumber()))
                .thenReturn(true);

        // Then
        assertThrows(MyException.class, () -> targetObject.addUser(userRequestDto));
    }

    @Test
    public void addNewUserShouldCallUserDao() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(1);
        userRequestDto.setEmail("user@user.com");
        userRequestDto.setPassword("password");
        userRequestDto.setUserDetails(new UserDetailsDto());
        userRequestDto.getUserDetails().setPhoneNumber("+375291112233");

        // When
        when(userRepository.save(any())).thenReturn(new User());
        targetObject.addUser(userRequestDto);

        // Then
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(argument.capture());
        assertEquals(argument.getValue().getId(), userRequestDto.getId());
        assertEquals(argument.getValue().getEmail(), userRequestDto.getEmail());
        assertEquals(argument.getValue().getUserDetails().getPhoneNumber(), userRequestDto.getUserDetails().getPhoneNumber());
    }

    @Test
    public void deleteUserShouldThrowWhenUserDoesNotExist() {
        // Given
        int id = 1;

        // When
        when(userRepository.existsById(id))
                .thenReturn(false);

        // Then
        assertThrows(MyException.class, () -> targetObject.deleteUser(id));
    }

    @Test
    public void deleteUserShouldCallDao() {
        // Given
       Integer id = 1;

        // When
        when(userRepository.existsById(id))
                .thenReturn(true);
        targetObject.deleteUser(id);

        // Then
        ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
        verify(userRepository).deleteById(argument.capture());
        assertEquals(argument.getValue(), id);
    }
}
