package gof.bridge;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Client {

   public void doSome(){
       DBOperator operator = new DBMySQLOperator();
       DBLogger logger = new DBXMLLogger();

       logger.setOperator(operator);
       logger.log();
   }

}
