package gof.prototype;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Message implements Cloneable{
    // 通用头部
    private Object commonHeader = null;
    // 通用尾部
    private Object commonFooter = null;
    // 定制主体
    private Object body;

    @Override
    protected Message clone() throws CloneNotSupportedException {
        Message message = (Message) super.clone();
        // 如果头部和尾部的对象创建过程需要深拷贝，则需要特殊处理这段代码
        message.commonHeader = new Object();
        message.commonFooter = new Object();
        return message;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
