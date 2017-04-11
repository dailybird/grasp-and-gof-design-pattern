package gof.chainofresponsibility;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class RoleValidator extends Validator {

    public RoleValidator() {
        this.successor = new AvailableValidator();
    }
}
