[https://www.hangge.com/blog/cache/detail_3157.html#:~:text=%E6%9E%84%E5%BB%BA%E4%B8%80%E4%B8%AA%20MongoDB%20%E7%9A%84%E5%88%86%E7%89%87%E9%9B%86%E7%BE%A4%EF%BC%8C%E9%9C%80%E8%A6%81%E4%B8%89%E4%B8%AA%E9%87%8D%E8%A6%81%E7%9A%84%E7%BB%84%E4%BB%B6%EF%BC%8C%E5%88%86%E5%88%AB%E6%98%AF%E5%88%86%E7%89%87%E6%9C%8D%E5%8A%A1%E5%99%A8%EF%BC%88%20Shard%20Server%20%EF%BC%89%E3%80%81%E9%85%8D%E7%BD%AE%E6%9C%8D%E5%8A%A1%E5%99%A8%EF%BC%88%20Config%20Server,Shard%20Server%20%EF%BC%9A%E6%AF%8F%E4%B8%AA%20Shard%20Server%20%E9%83%BD%E6%98%AF%E4%B8%80%E4%B8%AA%20mongod%20%E6%95%B0%E6%8D%AE%E5%BA%93%E5%AE%9E%E4%BE%8B%EF%BC%8C%E7%94%A8%E4%BA%8E%E5%AD%98%E5%82%A8%E5%AE%9E%E9%99%85%E7%9A%84%E6%95%B0%E6%8D%AE%E5%9D%97%E3%80%82]

## 副本
rs.initiate(cfg)
rs.status()
### config
cfg = {
_id : "configs",
members : [
{_id : 0, host : "192.168.11.32:24000" },
{_id : 1, host : "192.168.11.33:24000" },
{_id : 2, host : "192.168.11.35:24000" }
]
}

### shard1
./bin/mongod -f conf/shard1.conf

cfg = {
_id : "shard1",
members : [
{_id : 0, host : "192.168.11.32:24001", priority: 3},
{_id : 1, host : "192.168.11.33:24001", priority: 2},
{_id : 2, host : "192.168.11.35:24001", priority: 1}
]
}

### shard2
cfg = {
_id : "shard2",
members : [
{_id : 0, host : "192.168.11.32:24002", priority: 1},
{_id : 1, host : "192.168.11.33:24002", priority: 3},
{_id : 2, host : "192.168.11.35:24002", priority: 2}
]
};
rs.initiate(cfg);
rs.status();

### shard3
cfg = {
_id : "shard3",
members : [
{_id : 0, host : "192.168.11.32:24003", priority: 2},
{_id : 1, host : "192.168.11.33:24003", priority: 1},
{_id : 2, host : "192.168.11.35:24003", priority: 3}
]
};
rs.initiate(cfg);
rs.status();

### route server
sh.addShard("shard1/192.168.11.32:24001,192.168.11.33:24001,192.168.11.35:24001");
sh.addShard("shard2/192.168.11.32:24002,192.168.11.33:24002,192.168.11.35:24002");
sh.addShard("shard3/192.168.11.32:24003,192.168.11.33:24003,192.168.11.35:24003");