package goldace.countingBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Main.prefix + "stats")){

            //get the counting channel
            TextChannel channel = null;
            for(TextChannel t : Main.jda.getTextChannels()){
                if(t.getName().contains("count")) channel = t;
            }

            //get the message history of counting channel
            List<Message> messages = new ArrayList<Message>();
            MessageHistory history = channel.getHistory();
            int amount = 0;

            //amount = Integer.parseInt(history.getRetrievedHistory().get(0).getContentDisplay());
            System.out.println(amount);
            //have to do this weird thing with an array list because you can't assign a value to an integer
            //while in a lambda function unless it is declared final
            //ArrayList<Integer> amount = new ArrayList<Integer>();

//            channel.retrieveMessageById(channel.getLatestMessageId()).queue((message) -> {
//                System.out.println("adding this to list: " + Integer.parseInt(message.getContentDisplay()));
//                amount.add(Integer.parseInt(message.getContentDisplay()));
//            });

            //System.out.println("amount" + amount.get(0));

            //Make the embed for stats
            EmbedBuilder stats = new EmbedBuilder();
            stats.setTitle("Counting Stats");
            stats.addField("Test Title 1", "cool info", false);

            event.getChannel().sendMessage(stats.build()).queue();
        }

        if(args[0].equalsIgnoreCase("test")){
            event.getChannel().sendMessage("Worked").queue();
        }
    }
}
