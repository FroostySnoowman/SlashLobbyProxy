package frostyservices.org.slashlobby.Commands;

import frostyservices.org.slashlobby.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Lobby extends Command {

    private File file;
    private Configuration configuration;
    public Lobby(Main main) {
        super("Lobby");
    }


    public void execute(CommandSender sender, String[] args) {
        file = new File(ProxyServer.getInstance().getPluginsFolder() + "/SlashLobby");
        Boolean bool = file.mkdirs();
        file = new File(file + "/config.yml");
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            sender.sendMessage(new ComponentBuilder("An error occurred. Unable to read the configuration file!").color(ChatColor.RED).create());
            return;
        }
        if ((sender instanceof ProxiedPlayer)) {
            String server1 =  configuration.getString("Server1");
            String server2 =  configuration.getString("Server2");
            String server3 =  configuration.getString("Server3");
            String server4 =  configuration.getString("Server4");
            String server5 =  configuration.getString("Server5");
            String server6 =  configuration.getString("Server6");
            String server7 =  configuration.getString("Server7");
            String server8 =  configuration.getString("Server8");
            String server9 =  configuration.getString("Server9");
            String server10 =  configuration.getString("Server10");
            String linked1 =  configuration.getString("Linked1");
            String linked2 =  configuration.getString("Linked2");
            String linked3 =  configuration.getString("Linked3");
            String linked4 =  configuration.getString("Linked4");
            String linked5 =  configuration.getString("Linked5");
            String linked6 =  configuration.getString("Linked6");
            String linked7 =  configuration.getString("Linked7");
            String linked8 =  configuration.getString("Linked8");
            String linked9 =  configuration.getString("Linked9");
            String linked10 =  configuration.getString("Linked10");
            ProxiedPlayer p = (ProxiedPlayer) sender;
            //Server1 check
            if (p.getServer().getInfo().getName().equalsIgnoreCase(server1)) {
                p.sendMessage(new ComponentBuilder("Connecting you to " + linked1 + "!").color(ChatColor.GREEN).create());
                p.connect(ProxyServer.getInstance().getServerInfo(linked1));
            }
            if (p.getServer().getInfo().getName().equalsIgnoreCase(server2)) {
                p.sendMessage(new ComponentBuilder("Connecting you to " + linked2 + "!").color(ChatColor.GREEN).create());
                p.connect(ProxyServer.getInstance().getServerInfo(linked2));
            }
        } else {
            sender.sendMessage(new ComponentBuilder("Only players can use this command!").color(ChatColor.RED).create());
        }
    }
}
