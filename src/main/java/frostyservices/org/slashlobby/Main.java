package frostyservices.org.slashlobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import frostyservices.org.slashlobby.Commands.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public final class Main extends Plugin {

    private File file;
    @Override
    public void onEnable() {
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aLoading &eSlashLobby &b(Proxy Edition)&a!"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Lobby(this));
        file = new File(ProxyServer.getInstance().getPluginsFolder() + "/SlashLobby");
        file.mkdirs();
        file = new File(file + "/config.yml");
        generateConfigIfFileDoesntExist("config.yml", file);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aLoaded &eSlashLobby &b(Proxy Edition)&a!"));
    }

    private void generateConfigIfFileDoesntExist(String resourceName, File configFile) {
        if (configFile.exists()) return;
        try {
            getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aCreating &eSlashLobby &aconfiguration file!"));
            InputStream stream = Main.class.getClassLoader().getResourceAsStream(resourceName);
            if (stream == null) throw new IllegalStateException("Config file does not exist in resources directory!");
            Files.copy(stream, configFile.toPath());
            getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aCreated &eSlashLobby &aconfiguration file!"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&eSlashLobby &b(Proxy Edition) &chas disabled!"));
    }
}