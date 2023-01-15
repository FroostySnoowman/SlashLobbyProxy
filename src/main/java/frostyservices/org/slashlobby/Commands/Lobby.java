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
            String printout =  configuration.getString("Server1");
            sender.sendMessage(new ComponentBuilder("Test" + printout).color(ChatColor.BLUE).create());
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if (p.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {
                p.sendMessage(new ComponentBuilder("You are already connected to the lobby!").color(ChatColor.RED).create());
            } else {
                p.sendMessage(new ComponentBuilder("Connecting you to the lobby!").color(ChatColor.GREEN).create());
                p.connect(ProxyServer.getInstance().getServerInfo("lobby"));
            }
        } else {
            sender.sendMessage(new ComponentBuilder("Only players can use this command!").color(ChatColor.RED).create());
        }
    }
}
