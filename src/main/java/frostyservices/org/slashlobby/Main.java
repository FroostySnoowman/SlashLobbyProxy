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
                configuration.set("Server1", "lobby");
                configuration.set("Server2", "test");
                configuration.set("Server3", "lobby");
                configuration.set("Server4", "lobby");
                configuration.set("Server5", "lobby");
                configuration.set("Server6", "lobby");
                configuration.set("Server7", "lobby");
                configuration.set("Server8", "lobby");
                configuration.set("Server9", "lobby");
                configuration.set("Server10", "lobby");
                configuration.set("Linked1", "lobby");
                configuration.set("Linked2", "lobby");
                configuration.set("Linked3", "lobby");
                configuration.set("Linked4", "lobby");
                configuration.set("Linked5", "lobby");
                configuration.set("Linked6", "lobby");
                configuration.set("Linked7", "lobby");
                configuration.set("Linked8", "lobby");
                configuration.set("Linked9", "lobby");
                configuration.set("Linked10", "lobby");
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
