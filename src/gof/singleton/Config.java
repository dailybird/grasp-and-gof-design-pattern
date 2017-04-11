package gof.singleton;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class Config {
    private static Config config = null;

    // 私有化构造方法
    private Config() {}

    /**
     * 当对象为空时创建后返回
     * 反之直接返回
     * @return
     */
    public static Config getConfig(){
        if(Config.config == null){
           Config.config = Config.createConfig();
           return Config.getConfig();
        }else{
            return Config.config;
        }
    }

    /**
     * 如果对象的创建过程比较复杂，可以单独抽离一个 createConfig 方法
     * 当然也可以把创建过程直接写在 getConfig 方法之中
     * @return
     */
    private static Config createConfig(){
        return new Config();
    }

}
