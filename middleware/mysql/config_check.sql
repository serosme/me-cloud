-- ================================================================
-- MySQL 关键配置检查脚本
-- mysql -u root -p -e "SOURCE config_check.sql"
-- docker exec -i mysql mysql -u root -p -e "$(cat config_check.sql)"
-- ================================================================

-- 1. 检查客户端连接相关字符集
SHOW VARIABLES LIKE 'character_set%';

-- 2. 检查 secure_file_priv 设置
SHOW VARIABLES LIKE 'secure_file_priv';

-- 3. 检查默认存储引擎
SHOW VARIABLES LIKE 'default_storage_engine';

-- 4. 检查是否启用本地文件加载功能
SHOW GLOBAL VARIABLES LIKE 'local_infile';

-- 5. 检查时区设置（防止时间数据问题）
SHOW VARIABLES LIKE '%time_zone%';

-- 6. 检查 SQL 模式（严格模式推荐）
SHOW VARIABLES LIKE 'sql_mode';
