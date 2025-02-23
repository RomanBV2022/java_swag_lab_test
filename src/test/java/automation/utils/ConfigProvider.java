package automation.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config  = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("test.conf");
    }

    static  final String LOGIN = config.getString("loginUser.login");
    static final String PASSWORD = config.getString("loginUser.password");

}
