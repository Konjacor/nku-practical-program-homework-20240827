# 项目部署指南

## 系统要求
- **Java Development Kit (JDK)**: 1.8
- **Maven**: 3.8.3
- **MySQL**: 数据库服务
- **Node.js & npm**: 用于Vue.js项目

## 后端部署步骤（Spring Boot）

### 1. Maven 设置
- 打开 IntelliJ IDEA 的 `Settings`（或 `Preferences`，取决于操作系统）。
- 导航至 `Build, Execution, Deployment` > `Build Tools` > `Maven`。
- 设置 `Maven home directory` 为 Maven 3.8.3 的安装路径。
- 设置 `User settings file` 指向您的 Maven `settings.xml` 文件。
- 设置 `Local repository` 为您的本地 Maven 仓库路径。

### 2. JDK 配置
- 确保项目使用的 SDK 为 JDK 1.8。
- 将项目语言级别设置为 8。

### 3. 数据库配置
- 安装并运行 MySQL 数据库服务。
- 创建名为 `xm-secondhand` 的数据库。

### 4. 导入依赖项
- 使用 Maven 导入项目依赖包，通常通过点击 `Import Changes` 或运行 `mvn install` 命令。

### 5. 启动 Spring Boot 应用
- 运行 `SpringbootApplication.java` 文件以启动后端服务。

---

## 前端部署步骤（Vue.js）

### 6. 安装环境依赖
- 打开终端，切换至 Vue.js 项目目录。
- 执行 `npm install` 命令以安装项目依赖。

### 7. 编译项目
- 在终端中运行 `npm run build` 命令以编译项目。

### 8. 运行开发服务器
- 在终端中执行 `npm run serve` 命令以启动开发服务器。
- 打开浏览器并访问 `http://localhost:8080`（或终端中显示的实际地址）以加载网页。

---

## 数据库初始化
- 执行项目目录中的 `xm-secondhand.sql` 文件以初始化数据库结构。

## 登录说明
以下为系统预设的登录凭据：

| 角色   | 账号   | 密码   |
| ------ | ------ | ------ |
| 管理员 | admin  | admin  |
| 用户   | aaa    | 123    |

成功启动 Spring Boot 和 Vue.js 后，请使用上述凭据登录系统。

---

请确保遵循上述步骤以确保项目正确部署和运行。如在部署过程中遇到任何问题，请参考项目的 `README.md` 文件或联系项目维护人员。
