package net.backdoorinc.wartung;

import lombok.Getter;
import net.backdoorinc.wartung.commands.C_Wartungen;
import net.backdoorinc.wartung.listener.L_Connect;
import net.backdoorinc.wartung.listener.L_PingEvent;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class Wartung extends Plugin {
    public Wartung wartung;
    public Data data;

    @Override
    public void onEnable() {
        this.wartung = wartung;

        BungeeCord.getInstance().getPluginManager().registerListener(this,new L_Connect(this));
        BungeeCord.getInstance().getPluginManager().registerListener(this,new L_PingEvent(this));
        BungeeCord.getInstance().getPluginManager().registerCommand(this,new C_Wartungen("wartung",this));

    }

    @Override
    public void onDisable() {


    }
}
