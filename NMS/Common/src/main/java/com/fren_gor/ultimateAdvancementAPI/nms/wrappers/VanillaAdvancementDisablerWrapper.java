package com.fren_gor.ultimateAdvancementAPI.nms.wrappers;

import com.fren_gor.ultimateAdvancementAPI.nms.util.ReflectionUtil;
import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Class to disable vanilla advancements.
 */
public class VanillaAdvancementDisablerWrapper {

    private static Method method;

    static {
        var clazz = ReflectionUtil.getWrapperClass(VanillaAdvancementDisablerWrapper.class);
        assert clazz != null : "Wrapper class is null.";
        try {
            Class params[] = { boolean.class };
            method = clazz.getDeclaredMethod("disableVanillaAdvancements", params);
            Preconditions.checkArgument(Modifier.isPublic(method.getModifiers()), "Method disableVanillaAdvancements(boolean) is not public.");
            Preconditions.checkArgument(Modifier.isStatic(method.getModifiers()), "Method disableVanillaAdvancements(boolean) is not static.");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Disable vanilla advancement.
     *
     * @throws Exception If disabling goes wrong.
     */
    public static void disableVanillaAdvancements(boolean disableVanillaAdvancementsRecipes) throws Exception {
        method.invoke(null, disableVanillaAdvancementsRecipes);
    }
}
