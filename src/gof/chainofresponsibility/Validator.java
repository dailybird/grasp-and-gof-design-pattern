package gof.chainofresponsibility;

/**
 *
 * Created by dailybird on 17/4/10.
 */
abstract public class Validator {
    protected Validator successor = null;

    public boolean validate(Object object){
        // 验证过程
        boolean isValid = false;
        if(isValid){
            return true;
        }else{
            if(this.successor != null){
                return this.successor.validate(object);
            }else{
                return false;
            }
        }
    }

    public void setSuccessor(Validator successor) {
        this.successor = successor;
    }
}

