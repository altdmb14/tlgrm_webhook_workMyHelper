package ru.tlgrmbot.myhelperbot.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tlgrmbot.myhelperbot.MyHelperTelegramBot;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    @Bean
    public MyHelperTelegramBot MyTelegramBot() {
        MyHelperTelegramBot myHelperTelegramBot = new MyHelperTelegramBot();
        myHelperTelegramBot.setBotUserName(botUserName);
        myHelperTelegramBot.setBotToken(botToken);
        myHelperTelegramBot.setWebHookPath(webHookPath);

        return myHelperTelegramBot;
    }
}
