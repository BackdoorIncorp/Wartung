package net.backdoorinc.wartung.commands;

import net.backdoorinc.wartung.Wartung;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class C_Wartungen extends Command {
    private Wartung wartung;

    public C_Wartungen(String name,Wartung wartung) {
        super(name);
        this.wartung = wartung;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer p = (ProxiedPlayer) commandSender;
        if(p.hasPermission("wartung.use")){
            if(strings.length == 0){
                if(wartung.data.wartungen == false){
                    wartung.data.wartungen = true;
                    p.sendMessage(wartung.data.PREFIX + "§7Die §cWartungsarbeiten §7wurden §aaktiviert§8.");
                } else {
                    wartung.data.wartungen = false;
                    p.sendMessage(wartung.data.PREFIX + "§7Die §cWartungsarbeiten §7wurden §cdeaktiviert§8.");
                }
            } else {
                commandSender.sendMessage(wartung.data.PREFIX + "§cKeine Argumente angeben!");
            }
        } else {
            p.sendMessage(wartung.data.PREFIX + "§cDazu hast du keine Rechte§8.");
        }
    }
}

