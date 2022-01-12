package io.github.battlepass.registry.quest;

import io.github.battlepass.quests.service.base.QuestContainer;
import io.github.battlepass.registry.quest.object.PluginVersion;
import me.hyfe.simplespigot.annotations.NotNull;
import me.hyfe.simplespigot.registry.Registry;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface QuestRegistry extends Registry {

    /**
     * This will return the hooks that are <b>currently</b> enabled. Due to the late hook system,
     * this should not be depended upon as a full list at start.
     *
     * @return The hooks currently enabled
     */
    @NotNull
    Set<String> getRegisteredHooks();

    /**
     * @return The hooks explicitly disabled via the settings.yml value
     */
    @NotNull
    List<String> getDisabledHooks();

    /**
     * This does not check simply if the hook is not registered, it checks whether it's explicitly
     * disabled via the settings.yml. To see if a hook is registered, see {@link QuestRegistry#getRegisteredHooks}
     *
     * @param plugin The identifier name of the plugin - should be what it is called in game.
     * @return Whether the hook is specified disabled
     */
    default boolean isHookDisabled(String plugin) {
        return this.getDisabledHooks().contains(plugin.toLowerCase());
    }

    /**
     * Initializes a quest as well as registers it as a Bukkit listener.
     * If your class is not a bukkit listener, please initialize the class manually
     */
    void quest(Instantiator<QuestContainer>... instantiators);

}
