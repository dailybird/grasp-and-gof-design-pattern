package gof.chainofresponsibility;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class LoginValidator extends Validator{

    public LoginValidator() {
        this.successor = new RoleValidator();
    }
}
