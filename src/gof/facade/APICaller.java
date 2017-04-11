package gof.facade;

/**
 *
 * Created by dailybird on 17/4/10.
 */
public class APICaller {

    public Object call(){
        Object res = getOriginData();
        res = encryptData(res);
        res = compressData(res);
        return res;
    }

    private Object getOriginData(){
        return new Object();
    }

    private Object encryptData(Object originData){
        // 加密处理
        return originData;
    }

    private Object compressData(Object originData){
        // 压缩
        return originData;
    }

}
