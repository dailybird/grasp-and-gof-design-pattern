package grasp.expert;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Controller {
    public String login(){
        User user = new User("username", "password");
        boolean canLogin = user.login();
        if(canLogin){
            return "www.website.com/index";
        }else{
            return "www.website.com/error.401.php";
        }

    }
}
