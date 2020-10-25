package net.backdoorinc.wartung.listener;

import net.backdoorinc.wartung.Wartung;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class L_Connect implements Listener {

    private Wartung wartung;

    public L_Connect(Wartung wartung) {
        this.wartung = wartung;
    }

    @EventHandler
    public void onConnect(PreLoginEvent event) {
        if(wartung.data.wartungen) {
            if(event.getConnection().getName().equalsIgnoreCase("NAMES")) {
                event.setCancelled(false);
            }else {
                event.setCancelled(true);
            }
        }
    }

}
