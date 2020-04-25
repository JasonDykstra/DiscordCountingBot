package goldace.countingBot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDA jda;
    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {
        String token = "Taken out so nobody hacks my bot";
        jda = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .addEventListeners(new Commands())
                .build();


    }
}
