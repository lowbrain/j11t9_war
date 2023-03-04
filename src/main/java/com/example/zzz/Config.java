package com.example.zzz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {
    private static Config config = new Config();

    private final Logger log = LogManager.getLogger(Config.class);

    private final String a;

    private final String b;

    private final String c;

    private final String d;

    private final String e;

    private Config() {
        try (InputStream in = this.getClass().getResourceAsStream("Config.properties")) {
            Properties props = new Properties();
            Optional<String> value;

            props.load(in);

            value = Optional.ofNullable(props.getProperty("zzz.a"));
            this.a = value.isPresent() ? value.get() : "";

            value = Optional.ofNullable(props.getProperty("zzz.b"));
            this.b = value.isPresent() ? value.get() : "";

            value = Optional.ofNullable(props.getProperty("zzz.c"));
            this.c = value.isPresent() ? value.get() : "";

            value = Optional.ofNullable(props.getProperty("zzz.d"));
            this.d = value.isPresent() ? value.get() : "";

            value = Optional.ofNullable(props.getProperty("zzz.e"));
            this.e = value.isPresent() ? value.get() : "";
        } catch (IOException e) {
            throw new RuntimeException("AppSetting.propertiesの読み込みに失敗しました。", e);
        }

        log.info(this);
    }

    public static Config getInstance() {
        return config;
    }

    public String getA() {
        return this.a;
    }

    public String getB() {
        return this.b;
    }

    public String getC() {
        return this.c;
    }

    public String getD() {
        return this.d;
    }

    public String getE() {
        return this.e;
    }

    @Override
    public String toString() {
        return "Config [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + "]";
    }
}
