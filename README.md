# example-cloud

基于 Spring Cloud 的微服务项目。

## 模块结构

```
example-cloud
├── example-infra              # 基础设施
├── example-platform           # 平台服务（聚合模块）
│   ├── example-platform-gateway  # 网关
│   └── example-platform-system   # 系统服务
└── example-shared             # 公共模块（聚合模块）
    ├── example-shared-core        # 核心（含处理器链）
    ├── example-shared-log         # 日志
    ├── example-shared-web         # Web 异常处理
    └── example-shared-mybatisplus # MyBatis Plus 配置
```

## 技术栈

- **JDK** 25
- **Spring Boot** 3.5.15
- **Spring Cloud** 2025.0.3
- **MyBatis Plus** 3.5.17
- **Spring AI** 1.1.8
- **Knife4j** 5.0.11

## 中间件

### MySQL

```bash
docker run -d \
  -p 3306:3306 \
  -e TZ=Asia/Shanghai \
  -e MYSQL_ROOT_PASSWORD=Password@123 \
  mysql:8.4
```

## 构建

```bash
mvn clean package
```
