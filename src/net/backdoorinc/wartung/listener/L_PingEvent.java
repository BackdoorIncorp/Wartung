package net.backdoorinc.wartung.listener;

import com.mysql.fabric.Server;
import net.backdoorinc.wartung.Wartung;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.protocol.Protocol;

public class L_PingEvent implements Listener {

    private Wartung wartung;

    public L_PingEvent(Wartung wartung) {
        this.wartung = wartung;
    }

    @EventHandler
    public void onPing(ProxyPingEvent event) {
        /**
         * @param ping for setting the new Ping Message
         */
        ServerPing ping = event.getResponse();
        ServerPing.Players players = ping.getPlayers();
        ServerPing.Protocol protocol = ping.getVersion();

        TextComponent textComponent = new TextComponent("Your MOTD");
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"Your website"));


        if(wartung.data.wartungen) {
            ping.setVersion(new ServerPing.Protocol("Your Protocol",2));
            ping.setDescriptionComponent(textComponent);
            event.setResponse(ping);
        }else {
            ping.setVersion(new ServerPing.Protocol("Your Protocol",2));
            ping.setDescriptionComponent(textComponent);
            event.setResponse(ping);
        }
    }

}
