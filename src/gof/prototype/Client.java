package gof.prototype;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

    public void sendMsg(){
        Message message = new Message();
        // ....
        try {
            Message anotherMsg = message.clone();
            anotherMsg.setBody(null);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
