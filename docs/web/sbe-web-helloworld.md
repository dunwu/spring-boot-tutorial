# SpringBoot 教程之第一个 Web 工程

## 创建项目

通过 `SPRING INITIALIZR` 工具产生基础项目

1. 访问：`http://start.spring.io/`
2. 选择构建工具`Maven Project`、Spring Boot 版本 `1.5.10` 以及一些工程基本信息，可参考下图所示：

![](http://dunwu.test.upcdn.net/snap/start.spring.io.png)

3. 点击`Generate Project`下载项目压缩包
4. 解压压缩包，包中已是一个完整的项目。

### Intellij 中使用 SPRING INITIALIZR

如果你使用 Intellij 作为 IDE，那么你可以直接使用 SPRING INITIALIZR，参考下图操作：

![](http://dunwu.test.upcdn.net/snap/intellij-spring-initializr.gif)

## 项目说明

**重要文件**

- `src/main/java` 路径下的 `Chapter1Application` 类 ：程序入口
- `src/main/resources` 路径下的 `application.properties` ：项目配置文件
- `src/test/java` 路径下的 `Chapter01ApplicationTests` ：程序测试入口

**pom.xml**

pom 中指定 parent 为以下内容，表示此项目继承了 `spring-boot-starter-parent` 的 maven 配置（主要是指定了常用依赖、插件的版本）。

```xml
<parent>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-parent</artifactId>
 <version>1.5.10.RELEASE</version>
 <relativePath/> <!-- lookup parent from repository -->
</parent>
```

此外，pom 中默认引入两个依赖包，和一个插件。

```xml
<dependencies>
 <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
 </dependency>

 <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
 </dependency>
</dependencies>

<build>
 <plugins>
  <plugin>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-maven-plugin</artifactId>
  </plugin>
 </plugins>
</build>
```

- `spring-boot-starter-web`：核心模块，包括自动配置支持、日志和 YAML。
- `spring-boot-starter-test`：测试模块，包括 JUnit、Hamcrest、Mockito。
- `spring-boot-maven-plugin`：spring boot 插件， 提供了一系列 spring boot 相关的 maven 操作。
  - `spring-boot:build-info`，生成 Actuator 使用的构建信息文件 build-info.properties
  - `spring-boot:repackage`，默认 goal。在 mvn package 之后，再次打包可执行的 jar/war，同时保留 mvn package 生成的 jar/war 为.origin
  - `spring-boot:run`，运行 Spring Boot 应用
  - `spring-boot:start`，在 mvn integration-test 阶段，进行 Spring Boot 应用生命周期的管理
  - `spring-boot:stop`，在 mvn integration-test 阶段，进行 Spring Boot 应用生命周期的管理

## 编写 REST 服务

- 创建 `package` ，名为 `io.github.zp.springboot.chapter1.web`（根据项目情况修改）
- 创建 `HelloController` 类，内容如下：

```java
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}
```

- 启动主程序 `XXXApplication`，打开浏览器访问`http://localhost:8080/hello` ，可以看到页面输出`Hello World`

## 编写单元测试用例

在 `XXXApplicationTests` 类中编写一个简单的单元测试来模拟 HTTP 请求，具体如下：

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class Chapter01ApplicationTests {

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}

}

```

使用`MockServletContext`来构建一个空的`WebApplicationContext`，这样我们创建的`HelloController`就可以在`@Before`函数中创建并传递到`MockMvcBuilders.standaloneSetup（）`函数中。

- 注意引入下面内容，让`status`、`content`、`equalTo`函数可用

```java
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
```

至此已完成目标，通过 Maven 构建了一个空白 Spring Boot 项目，再通过引入 web 模块实现了一个简单的请求处理。
