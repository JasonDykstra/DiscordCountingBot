package goldace.countingBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Commands extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        //send myself a private message when the count reaches any multiple of 100 + 90 so i know its time to start sniping that 100
        if(event.getChannel().getName().contains("count")){
            if(args[0].matches("^[0-9]*$")) {
                User goldace = Main.jda.getUserById("hidden");
                if (Integer.parseInt(args[0]) % 100 == 90) {
                    String msg = "Get ready to snipe!";
                    sendPrivateMessage(goldace, msg, event);
                }
            }

        }

        if(event.getMessage().getContentRaw().equalsIgnoreCase("test")){
            event.getChannel().sendMessage("Worked").queue();
        }
    }



    public void sendPrivateMessage(User user, String msg, MessageReceivedEvent event){
        user.openPrivateChannel().queue((channel) -> channel.sendMessage(msg).queue());
    }
}
