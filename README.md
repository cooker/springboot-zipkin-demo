# 安装zipkin
```shell
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```

# Rabbitmq 上报
https://github.com/openzipkin/zipkin/blob/master/zipkin-collector/rabbitmq

```shell
RABBIT_ADDRESSES=localhost:5672
RABBIT_PASSWORD=密码
RABBIT_USER=用户
```

# Es 存储
https://github.com/openzipkin/zipkin/tree/master/zipkin-server#elasticsearch-storage

```shell
STORAGE_TYPE=elasticsearch
ES_HOSTS=http://myhost:9200
ES_USERNAME=用户
ES_PASSWORD=密码
```
# 支持功能

- [x] feign 接口调用
- [x] 异步线程调用
- [x] @Async调用
- [x] Hystrix 接口 （cloud 2.x.0 版本）
- [x] rabbitMQ
- [x] 手动获取tarceId

# 额外属性
## Header 属性
`X-B3-TraceId`
## log MDC 属性
Notice the [`appname`,`traceId`,`spanId`,`exportable`] entries from the MDC: