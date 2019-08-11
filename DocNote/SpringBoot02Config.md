# 配置文件--ymal
## 1. 配置文件
SpringBoot 使用一个全局的配置文件，配置文件是固定的。
* application.properties
* application.yml

配置文件的作用是为了修改项目的默认配置
yaml 以数据为中心， 比 json、xml 更适合做配置文件

yaml实例:
```yaml
server:
  port: 8088
```

xml实例:
```xml
<server>
    <port>8088</port>
</server>
```