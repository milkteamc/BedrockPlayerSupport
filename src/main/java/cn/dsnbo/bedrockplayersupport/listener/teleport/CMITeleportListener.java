package cn.dsnbo.bedrockplayersupport.listener.teleport;

import cn.dsnbo.bedrockplayersupport.TeleportType;
import cn.dsnbo.bedrockplayersupport.util.Form;
import com.Zrips.CMI.Modules.tp.TpManager;
import com.Zrips.CMI.events.CMIPlayerTeleportRequestEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.UUID;

/**
 * @author DongShaoNB
 */
public class CMITeleportListener implements Listener {
    @EventHandler
    public void onCmiPlayerTeleportRequestEvent(CMIPlayerTeleportRequestEvent event) {
        TpManager.TpAction tpAction = event.getAction();
        Player requestor = event.getWhoOffers().getPlayer();
        Player receiver = event.getWhoAccepts().getPlayer();
        UUID teleportLocationPlayerUuid = receiver.getUniqueId();
        if (FloodgateApi.getInstance().isFloodgatePlayer(teleportLocationPlayerUuid)) {
            if (tpAction == TpManager.TpAction.tpa) {
                Form.openBedrockTeleportRequestMenu(TeleportType.Tpa, requestor, receiver);
            } else if (tpAction == TpManager.TpAction.tpahere) {
                Form.openBedrockTeleportRequestMenu(TeleportType.TpaHere, requestor, receiver);
            }
        }
    }
}
