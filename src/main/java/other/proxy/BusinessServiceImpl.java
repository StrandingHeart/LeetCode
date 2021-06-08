package other.proxy;

/**
 * @author zhangyong
 * Created on 2021-06-08
 */
public class BusinessServiceImpl implements BusinessService{
    @Override
    public int getUserId() {
        return 100;
    }

    @Override
    public final String getName() {
        return "this is my name";
    }
}
