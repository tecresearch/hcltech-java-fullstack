package in.tecresearch.service;

import in.tecresearch.entity.User;
import in.tecresearch.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserService implements CommandLineRunner {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started...");
        start();
    }


    public  void start(){
        try {
            do{
                System.out.println("1:Insert user");
                System.out.println("2:Update user ");
                System.out.println("3:Delete user");
                System.out.println("4:Get single user via role");
                System.out.println("5:Get All user");
                System.out.println("Enter your choice");
                int ch;
                Scanner sc=new Scanner(System.in);
                ch=sc.nextInt();

                switch (ch){
                    case 1:
                        //    INSERT USER----------------------------------------
                        System.out.println("Enter your name and role:");
                        User user1=new User(1,sc.next(),sc.next());
                        boolean status=userRepository.insertUser(user1);
                        if(status){
                            System.out.println("User inserted successfully");

                        }else{
                            System.out.println("Failed to insert user");
                        }
                        break;
                    case 2:

                        //UPDATE USER----------------------------------------
                        System.out.println("Enter your name and role:");
                        User user2=new User(1,sc.next(),sc.next());
                        boolean status1=userRepository.updateUser(user2);
                        if(status1){
                            System.out.println("User updated");
                        }else{
                            System.out.println("Failed to update");
                        }
                        break;
                    case 3:
                        //DELETE USER----------------------------------------
                        boolean status2=userRepository.deleteUserByRole("SDE");
                        if(status2){
                            System.out.println("User deleted");
                        }else{
                            System.out.println("Failed to delete");
                        }
                        break;
                    case 4:
                        //SELECT SINGLE USER----------------------------------------
                        User userDb=userRepository.getUserByRole("SDE");
                        System.out.println(userDb);
                        break;
                    case 5:
                        //SELECT LIST USER----------------------------------------
                        List<User> users=userRepository.getAllUsers();
                        System.out.println(users);
                        for(User user:users){
                            System.out.println(user.getId());
                            System.out.println(user.getName());
                            System.out.println(user.getRole());
                            System.out.println("------------------------------------");
                        }
                        break;
                    default:
                        System.out.println("Invalid input");

                }


            }while(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
