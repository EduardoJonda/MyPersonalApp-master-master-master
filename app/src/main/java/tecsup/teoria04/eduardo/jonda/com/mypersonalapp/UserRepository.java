package tecsup.teoria04.eduardo.jonda.com.mypersonalapp;

import android.util.Log;

import com.orm.SugarRecord;

import java.util.List;

import tecsup.teoria04.eduardo.jonda.com.mypersonalapp.models.User;

public class UserRepository {

    private static final String TAG = Main2ActivityRegistrar.class.getSimpleName();
    public static List<User> users = SugarRecord.listAll(User.class);
//
//    public static List<User> users = new ArrayList<>();

//    static{  //id, username, passward, nombre
//        users.add(new User(100, "user01", "1234", "Anonymoues 01"));
//        users.add(new User(200, "user02", "1234", "Anonymoues 02"));
//        users.add(new User(300, "user03", "1234", "Anonymoues 03"));
//    }


    public static User login(String username, String password){
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static User getUser(String username){
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

//    public static User Registro(String username, String password, String nombre){
//        users.add(new User(++i, username, password, nombre ));
//        return null;
//    }

    public static User create(String username, String password, String nombre){
        User user = new User(username, nombre,password);
        Log.d(TAG, "LLEGO"+user);
        SugarRecord.save(user);
        return user;
    }


}
