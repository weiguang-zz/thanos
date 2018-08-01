package com.thanos.soulgem;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import java.io.IOException;
import org.junit.BeforeClass;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
public class IntegrationTestConfiguration {

//  private final static Integer MONGO_PORT = 12345;
//  private final static String MONGO_IP = "localhost";
//
//
//  @BeforeClass
//  public void startInMemoryMongoServer() throws IOException {
//    MongodExecutable mongodExecutable = null;
//    try {
//      MongodStarter starter = MongodStarter.getDefaultInstance();
//
//      IMongodConfig mongodConfig = new MongodConfigBuilder()
//          .version(Version.Main.PRODUCTION)
//          .net(new Net(MONGO_IP, MONGO_PORT, Network.localhostIsIPv6()))
//          .build();
//
//      mongodExecutable = starter.prepare(mongodConfig);
//      mongodExecutable.start();
//
//    } finally {
//      if (mongodExecutable != null)
//        mongodExecutable.stop();
//    }
//  }

}
