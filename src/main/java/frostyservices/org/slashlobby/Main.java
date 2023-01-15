package frostyservices.org.slashlobby;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import frostyservices.org.slashlobby.Commands.*;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public final class Main extends Plugin {

    private File file;
    private Configuration configuration;
    @Override
    public void onEnable() {
        getLogger().info("SlashLobbyProxy has enabled!");
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Lobby(this));

        file = new File(ProxyServer.getInstance().getPluginsFolder() + "/SlashLobby");
        Boolean bool = file.mkdirs();
        file = new File(file + "/config.yml");
        try {
            if (!file.exists()) {
                file.createNewFile();
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                configuration.set("Server1", "lobby1");
                configuration.set("Server2", "lobby2");
                configuration.set("Server3", "lobby3");
                configuration.set("Server4", "lobby4");
                configuration.set("Server5", "lobby5");
                configuration.set("Server6", "lobby6");
                configuration.set("Server7", "lobby7");
                configuration.set("Server8", "lobby8");
                configuration.set("Server9", "lobby9");
                configuration.set("Server10", "lobby10");
                configuration.set("Linked1", "lobby1");
                configuration.set("Linked2", "lobby2");
                configuration.set("Linked3", "lobby3");
                configuration.set("Linked4", "lobby4");
                configuration.set("Linked5", "lobby5");
                configuration.set("Linked6", "lobby6");
                configuration.set("Linked7", "lobby7");
                configuration.set("Linked8", "lobby8");
                configuration.set("Linked9", "lobby9");
                configuration.set("Linked10", "lobby10");
            } else {
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            }
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("SlashLobbyProxy has disabled!");
    }
}
