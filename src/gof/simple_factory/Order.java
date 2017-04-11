package gof.simple_factory;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Order {
   private Object style;
   private Object body;
   private Object appendix;

    public Order(Object style, Object body, Object appendix) {
        this.style = style;
        this.body = body;
        this.appendix = appendix;
    }

    public void setStyle(Object style) {
        this.style = style;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void setAppendix(Object appendix) {
        this.appendix = appendix;
    }
}
