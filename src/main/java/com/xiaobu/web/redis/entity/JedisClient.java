package com.xiaobu.web.redis.entity;


import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.Pool;

/**
 * JedisClient api 添加了中文注释，便于工程师更方便使用，另外还原样保持了 Jedis api 的方法名称及使用方法，以便于仅仅通过查看
 * Redis 文档 即可快速掌握使用方法 Redis 命令参考: http://redisdoc.com/
 */
public class JedisClient {
    private final String name;
    private final JedisPool jedisPool;
    private final BinaryJedisCluster cluster;
    private final boolean isCluster;

    public BinaryJedisCluster getCluster(){
        return cluster;
    }

    public Pool<Jedis> getJedisPook(){
        return  jedisPool;
    }

    private final ThreadLocal<Jedis> threadLocalJedis = new ThreadLocal<Jedis>();

    public JedisClient(String name, JedisPool jedisPool, BinaryJedisCluster cluster, boolean isCluster) {
        this.name = name;
        this.jedisPool = jedisPool;
        this.cluster = cluster;
        this.isCluster = this.cluster !=null;
    }

    /**
     * 存放 key value 对到 redis 如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
     * 对于某个原本带有生存时间（TTL）的键来说， 当 SET 命令成功在这个键上执行时， 这个键原有的 TTL 将被清除。
     */
}
