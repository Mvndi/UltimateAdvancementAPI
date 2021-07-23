package com.fren_gor.ultimateAdvancementAPI.advancement;

import com.fren_gor.ultimateAdvancementAPI.AdvancementDisplay;
import com.fren_gor.ultimateAdvancementAPI.AdvancementFrameType;
import com.fren_gor.ultimateAdvancementAPI.database.DatabaseManager;
import com.fren_gor.ultimateAdvancementAPI.database.TeamProgression;
import net.md_5.bungee.api.chat.BaseComponent;
import net.minecraft.server.v1_15_R1.ChatComponentText;
import net.minecraft.server.v1_15_R1.Criterion;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static com.fren_gor.ultimateAdvancementAPI.util.AdvancementUtils.ADV_REWARDS;
import static com.fren_gor.ultimateAdvancementAPI.util.AdvancementUtils.getAdvancementCriteria;
import static com.fren_gor.ultimateAdvancementAPI.util.AdvancementUtils.getAdvancementRequirements;

public final class FakeAdvancement extends BaseAdvancement {

    private static final AtomicInteger FAKE_NUMBER = new AtomicInteger(1);

    private net.minecraft.server.v1_15_R1.Advancement mcAdvancement;

    public FakeAdvancement(@NotNull Advancement parent, float x, float y) {
        this(parent, new FakeAdvancementDisplay(Material.GRASS_BLOCK, "FakeAdvancement", AdvancementFrameType.TASK, x, y));
    }

    public FakeAdvancement(@NotNull Advancement parent, @NotNull FakeAdvancementDisplay display) {
        super("fakeadvancement._-.-_." + FAKE_NUMBER.getAndIncrement(), display, parent);
    }

    @Override
    @NotNull
    public FakeAdvancementDisplay getDisplay() {
        return (FakeAdvancementDisplay) super.getDisplay();
    }

    @Override
    @Contract("-> fail")
    public int getMaxCriteria() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public BaseComponent[] getAnnounceMessage(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotNull
    public net.minecraft.server.v1_15_R1.Advancement getMinecraftAdvancement() {
        if (mcAdvancement != null) {
            return mcAdvancement;
        }

        Map<String, Criterion> advCriteria = getAdvancementCriteria(maxCriteria);
        return mcAdvancement = new net.minecraft.server.v1_15_R1.Advancement(getMinecraftKey(), parent.getMinecraftAdvancement(), display.getMinecraftDisplay(this), ADV_REWARDS, advCriteria, getAdvancementRequirements(advCriteria));
    }

    @Override
    @Contract("_ -> fail")
    public void giveReward(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public boolean isGranted(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public boolean isGranted(@NotNull UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public boolean isGranted(@NotNull TeamProgression progression) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public int incrementTeamCriteria(@NotNull UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public int incrementTeamCriteria(@NotNull UUID uuid, boolean giveReward) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public int incrementTeamCriteria(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public int incrementTeamCriteria(@NotNull Player player, boolean giveReward) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public int incrementTeamCriteria(@NotNull UUID uuid, @Range(from = 0, to = Integer.MAX_VALUE) int increment) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _ -> fail")
    public int incrementTeamCriteria(@NotNull UUID uuid, @Range(from = 0, to = Integer.MAX_VALUE) int increment, boolean giveReward) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public int incrementTeamCriteria(@NotNull Player player, @Range(from = 0, to = Integer.MAX_VALUE) int increment) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _ -> fail")
    public int incrementTeamCriteria(@NotNull Player player, @Range(from = 0, to = Integer.MAX_VALUE) int increment, boolean giveReward) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _, _ -> fail")
    protected int incrementTeamCriteria(@NotNull UUID uuid, @Nullable Player player, @Range(from = 0, to = Integer.MAX_VALUE) int increment, boolean giveRewards) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public void setCriteriaTeamProgression(@NotNull UUID uuid, @Range(from = 0, to = Integer.MAX_VALUE) int criteria) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _ -> fail")
    public void setCriteriaTeamProgression(@NotNull UUID uuid, @Range(from = 0, to = Integer.MAX_VALUE) int criteria, boolean giveReward) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public void setCriteriaTeamProgression(@NotNull Player player, @Range(from = 0, to = Integer.MAX_VALUE) int criteria) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _ -> fail")
    public void setCriteriaTeamProgression(@NotNull Player player, @Range(from = 0, to = Integer.MAX_VALUE) int criteria, boolean giveReward) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _, _ -> fail")
    protected void setCriteriaTeamProgression(@NotNull UUID uuid, @Nullable Player player, @Range(from = 0, to = Integer.MAX_VALUE) int criteria, boolean giveRewards) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _, _, _, _, _, _ -> fail")
    protected void handlePlayer(@NotNull DatabaseManager ds, @Nullable TeamProgression pro, @NotNull UUID uuid, @Nullable Player player, int criteria, int old, boolean giveRewards) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public boolean isShownTo(Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public void onGrant(@NotNull Player player, boolean giveRewards) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public void grant(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_, _ -> fail")
    public void grant(@NotNull Player player, boolean giveRewards) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> fail")
    public void revoke(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getTeamCriteria(@NotNull Player player) {
        return 0;
    }

    @Override
    public int getTeamCriteria(@NotNull UUID uuid) {
        return 0;
    }

    @Override
    public int getTeamCriteria(@NotNull TeamProgression progression) {
        return 0;
    }

    @Override
    @Contract("_ -> fail")
    public void displayToastToPlayer(@NotNull Player player) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract("_ -> true")
    public boolean isVisible(@NotNull Player player) {
        return true;
    }

    @Override
    @Contract("_ -> true")
    public boolean isVisible(@NotNull UUID uuid) {
        return true;
    }

    // Since isVisible() returns true for every input we can use the super method
    /*@Override
    public void onUpdate(@NotNull UUID uuid, @NotNull Set<net.minecraft.server.v1_15_R1.Advancement> advancementList, @NotNull Map<MinecraftKey, AdvancementProgress> progresses, @NotNull TeamProgression teamProgression, @NotNull Set<MinecraftKey> added) {
        net.minecraft.server.v1_15_R1.Advancement adv = getMinecraftAdvancement();
        advancementList.add(adv);

        // Inlining of getAdvancementProgress()
        AdvancementProgress advPrg = new AdvancementProgress();
        advPrg.a(adv.getCriteria(), adv.i());

        MinecraftKey key = getMinecraftKey();
        added.add(key);
        progresses.put(key, advPrg);
    }*/

    public static final class FakeAdvancementDisplay extends AdvancementDisplay {

        public FakeAdvancementDisplay(@NotNull Material icon, @NotNull String title, @NotNull AdvancementFrameType frame, float x, float y) {
            super(icon, title, frame, false, false, x, y, Collections.emptyList());
        }

        public FakeAdvancementDisplay(@NotNull ItemStack icon, @NotNull String title, @NotNull AdvancementFrameType frame, float x, float y) {
            super(icon, title, frame, false, false, x, y, Collections.emptyList());
        }

        @Override
        @NotNull
        public net.minecraft.server.v1_15_R1.AdvancementDisplay getMinecraftDisplay(@NotNull Advancement advancement) {
            net.minecraft.server.v1_15_R1.AdvancementDisplay advDisplay = new net.minecraft.server.v1_15_R1.AdvancementDisplay(getNMSIcon(), new ChatComponentText(title), new ChatComponentText(compactDescription), null, frame.getMinecraftFrameType(), false, false, true);
            advDisplay.a(x, y);
            return advDisplay;
        }
    }
}
