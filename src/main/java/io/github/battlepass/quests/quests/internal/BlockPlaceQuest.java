package io.github.battlepass.quests.quests.internal;

import io.github.battlepass.BattlePlugin;
import io.github.battlepass.quests.service.base.QuestContainer;
import me.hyfe.simplespigot.version.ServerVersion;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceQuest extends QuestContainer {

    public BlockPlaceQuest(BattlePlugin plugin) {
        super(plugin);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
            if(!player.hasPermission("battlepass.wither")) return;
        Block block = event.getBlock();

        if (block.getType() == Material.FIRE || (
                ServerVersion.getVersion().getVersionId() >= ServerVersion.MC1_16_R1.getVersionId() && block.getType() == Material.SOUL_FIRE)
        ) return;
        this.executionBuilder("block-place")
                .player(player)
                .root(block)
                .progressSingle()
                .buildAndExecute();
    }
}
