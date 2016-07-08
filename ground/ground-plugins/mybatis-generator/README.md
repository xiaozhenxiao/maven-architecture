
    <plugin>
        <groupId>com.hanyun.platform.ground.plugins</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.0.0-SNAPSHOT</version>
        <configuration>
            <overwrite>true</overwrite>
            <verbose>true</verbose>
        </configuration>
        <dependencies>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.36</version>
            </dependency>
        </dependencies>
    </plugin>

