package data.pools;

import java.util.Arrays;
import java.util.List;

public class Pools {

    static List<Integer> mainPool = Arrays.asList(100, 20, 20, 5, 5, 5, 5, 5);

    static List<Integer> additionalPool = Arrays.asList(20, 10, 5);

    public static PoolSettings mainPoolSettings = new PoolSettings(
            mainPool, 1, 3);

    public static PoolSettings extraPoolSettings = new PoolSettings(
            additionalPool, 0, 0);

}
