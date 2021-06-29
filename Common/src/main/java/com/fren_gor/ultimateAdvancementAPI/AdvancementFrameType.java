package com.fren_gor.ultimateAdvancementAPI;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public enum AdvancementFrameType {

    TASK(net.minecraft.server.v1_15_R1.AdvancementFrameType.TASK, ChatColor.GREEN, "advancement"),
    CHALLENGE(net.minecraft.server.v1_15_R1.AdvancementFrameType.CHALLENGE, ChatColor.DARK_PURPLE, "challenge"),
    GOAL(net.minecraft.server.v1_15_R1.AdvancementFrameType.GOAL, ChatColor.GREEN, "advancement");

    @Getter
    private final net.minecraft.server.v1_15_R1.AdvancementFrameType minecraftFrameType;
    @Getter
    private final ChatColor color;
    @Getter
    private final String chatText;

    @NotNull
    public static AdvancementFrameType fromNMS(@NotNull net.minecraft.server.v1_15_R1.AdvancementFrameType nms) {
        for (AdvancementFrameType a : values()) {
            if (a.minecraftFrameType == nms) {
                return a;
            }
        }
        // This should never run
        throw new IllegalArgumentException(nms.name() + " isn't a valid enum constant.");
    }

}