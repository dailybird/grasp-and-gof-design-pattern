package grasp.expert;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class User {
    private String username;
    private String passsword;

    public User(String username, String passsword) {
        this.username = username;
        this.passsword = passsword;
    }

    public boolean login(){
        if(this.username.equals("foo") && this.passsword.equals("bar")){
            return true;
        }else{
            return false;
        }
    }
}
