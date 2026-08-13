# middleware

本地开发所需的中间件，每个中间件独立目录，可单独启动，互不依赖。

## 目录结构

```
middleware
├── mysql/compose.yaml   # MySQL 8.4
├── redis/compose.yaml   # Redis 8
└── nacos/compose.yaml   # Nacos 3.2.3
```

## 服务清单

| 服务  | 镜像                      | 端口                        | 默认凭据             | 用途           |
|-------|---------------------------|-----------------------------|----------------------|----------------|
| MySQL | mysql:8.4                 | 3306                        | root / Password@123  | 数据存储       |
| Redis | redis:8                   | 6379                        | 密码 Password@123    | 缓存           |
| Nacos | nacos/nacos-server:v3.2.3 | 7848（控制台）/ 8848 / 9848 | 首次启动后自行初始化 | 注册与配置中心 |

## docker run 单独运行

每个中间件用一条命令独立启动：

```bash
docker run -d --name mysql \
  -p 3306:3306 \
  -e TZ=Asia/Shanghai \
  -e MYSQL_ROOT_PASSWORD=Password@123 \
  mysql:8.4
```

```bash
docker run -d --name redis \
  -p 6379:6379 \
  redis:8 \
  redis-server --requirepass Password@123
```

```bash
docker run -d --name nacos \
  -p 7848:8080 -p 8848:8848 -p 9848:9848 \
  -e MODE=standalone \
  -e FUNCTION_MODE=microservice \
  -e NACOS_AUTH_TOKEN=SL85c2q9AyZWbTutOt+QrF7WeCONXeYb8IwvIN5wkKI= \
  -e NACOS_AUTH_IDENTITY_KEY=NACOS_AUTH_IDENTITY_KEY \
  -e NACOS_AUTH_IDENTITY_VALUE=eb27213d39e0764c3f7f36afd73cc024 \
  nacos/nacos-server:v3.2.3
```
