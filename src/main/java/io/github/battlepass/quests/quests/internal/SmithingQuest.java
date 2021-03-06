package io.github.battlepass.quests.quests.internal;

import io.github.battlepass.BattlePlugin;
import io.github.battlepass.quests.service.base.QuestContainer;

public class SmithingQuest extends QuestContainer {

    public SmithingQuest(BattlePlugin plugin) {
        Player player = (Player) source;
            if(!player.hasPermission("battlepass.wither")) return;
        super(plugin);
    }
}
