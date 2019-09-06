package com.manager.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author JustOne
 * @create 2018-08-01  22:47
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = MyDruirdConfig.PACKAGE, sqlSessionFactoryRef = "sessionFactory")
public class MyDruirdConfig implements DbConfig {


    public static final String PACKAGE = "com.manager.*.dao.**";

    public static final String MAPPER = "classpath:com/manager/*/dao/*Mapper*.xml";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.testWhileIdle:true}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis:60000}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    /**
     * 指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个.<br/>
     * 注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串
     */
    @Value("${spring.datasource.testOnBorrow:true}")
    private boolean testOnBorrow;

    /**
     * 指明是否在归还到池中前进行检验<br/>
     * 注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串
     */
    @Value("${spring.datasource.testOnReturn:false}")
    private boolean testOnReturn;

    @Value("${spring.datasource.minEvictableIdleTimeMillis:300000}")
    private int minEvictableIdleTimeMillis;

    /**
     * 当开启时, 将为每个连接创建一个statement池,并且被方法创建的PreparedStatements将被缓存起来:
     */
    @Value("${spring.datasource.poolPreparedStatements:false}")
    private boolean poolPreparedStatements;

    /**
     * 不限制  statement池能够同时分配的打开的statements的最大数量,如果设置为0表示不限制
     */
    @Value("${spring.datasource.maxOpenPreparedStatements:10}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.defaultAutoCommit:false}")
    private boolean defaultAutoCommit;

    @Value("${spring.datasource.filters:stat}")
    private String filters;

    /**
     * 当建立新连接时被发送给JDBC驱动的连接参数
     */
    @Value("${spring.datasource.connectionProperties:druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000}")
    private String connectionProperties;

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }

    /**
     * 定义数据源
     * 注意@Primary注解表示：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "dataSource")
    @Primary
    @Override
    public DataSource dataSource() throws Exception {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(this.username);
        datasource.setPassword(this.password);

        datasource.setInitialSize(this.initialSize);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxActive(this.maxActive);
        datasource.setMaxWait(this.maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setValidationQuery(this.validationQuery);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setDefaultAutoCommit(this.defaultAutoCommit);
        datasource.setFilters(this.filters);
        datasource.setConnectionProperties(this.connectionProperties);
        return datasource;
    }

    /**
     * 定义session工厂
     * 注：ualifier的意思是合格者，通过这个标示，表明了哪个实现类才是我们所需要的，
     * 我们修改调用代码，添加@Qualifier注解，需要注意的是@Qualifier的参数名称必须为我们之前定义@Service注解的名称之一！
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "sessionFactory")
    @Primary
    @Override
    public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sessionFactory.setConfiguration(configuration);
        // 添加分页插件
        sessionFactory.setPlugins(new Interceptor[]{
                paginationInterceptor()
        });

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sessionFactory.setMapperLocations(resolver.getResources(MyDruirdConfig.MAPPER));
        return sessionFactory.getObject();
    }

    /**
     * 定义事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    @Override
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
