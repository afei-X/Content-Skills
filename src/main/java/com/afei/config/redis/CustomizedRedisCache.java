//package com.afei.config.redis;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.cache.RedisCache;
//import org.springframework.data.redis.cache.RedisCacheElement;
//import org.springframework.data.redis.cache.RedisCacheKey;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.util.Assert;
//
///**
// * Description
// *
// * @author thinkpad
// * @version 1.0
// * Date                 Author			Version     Description
// * ------------------------------------------------------------------
// * 2018-8-9--13:44     suyin             1.0      Version
// */
//public class CustomizedRedisCache extends RedisCache {
//
//    private final RedisOperations redisOperations;
//
//    private final byte[] prefix;
//
//    public CustomizedRedisCache(String name, byte[] prefix, RedisOperations<? extends Object, ? extends Object> redisOperations, long expiration) {
//        super(name, prefix, redisOperations, expiration);
//        this.redisOperations = redisOperations;
//        this.prefix = prefix;
//    }
//
//    public CustomizedRedisCache(String name, byte[] prefix, RedisOperations<? extends Object, ? extends Object> redisOperations, long expiration, boolean allowNullValues) {
//        super(name, prefix, redisOperations, expiration, allowNullValues);
//        this.redisOperations = redisOperations;
//        this.prefix = prefix;
//    }
//
//    /**
//     * 重写父类的get函数。
//     * 父类的get方法，是先使用exists判断key是否存在，不存在返回null，存在再到redis缓存中去取值。这样会导致并发问题，
//     * 假如有一个请求调用了exists函数判断key存在，但是在下一时刻这个缓存过期了，或者被删掉了。
//     * 这时候再去缓存中获取值的时候返回的就是null了。
//     * 可以先获取缓存的值，再去判断key是否存在。
//     *
//     * @param cacheKey
//     * @return
//     */
//    @Override
//    public RedisCacheElement get(final RedisCacheKey cacheKey) {
//
//        Assert.notNull(cacheKey, "CacheKey must not be null!");
//
//        Object lookup = lookup(cacheKey);
//        if (lookup == null) {
//            return null;
//        }
//        RedisCacheElement redisCacheElement = new RedisCacheElement(cacheKey, fromStoreValue(lookup));
//        Boolean exists = (Boolean) redisOperations.execute(new RedisCallback<Boolean>() {
//            @Override
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                return connection.exists(cacheKey.getKeyBytes());
//            }
//        });
//
//        if (!exists.booleanValue()) {
//            return null;
//        }
//
//        return redisCacheElement;
//    }
//
//
//    /**
//     * 获取RedisCacheKey
//     *
//     * @param key
//     * @return
//     */
//    private RedisCacheKey getRedisCacheKey(Object key) {
//        return new RedisCacheKey(key).usePrefix(this.prefix)
//                .withKeySerializer(redisOperations.getKeySerializer());
//    }
//}
//
