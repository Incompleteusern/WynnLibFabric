package io.github.nbcss.wynnlib.abilities.display

import io.github.nbcss.wynnlib.abilities.effects.AbilityEffect
import io.github.nbcss.wynnlib.abilities.properties.legacy.ChargeProperty
import io.github.nbcss.wynnlib.i18n.Translations
import io.github.nbcss.wynnlib.utils.Symbol
import io.github.nbcss.wynnlib.utils.signed
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object ChargesTooltip: EffectTooltip {
    override fun get(effect: AbilityEffect): List<Text> {
        if (effect is ChargeProperty){
            return listOf(Symbol.CHARGE.asText().append(" ")
                .append(Translations.TOOLTIP_ABILITY_CHARGES.formatted(Formatting.GRAY).append(": "))
                .append(LiteralText(effect.getCharges().toString()).formatted(Formatting.WHITE)))
        }
        return emptyList()
    }

    object Modifier: EffectTooltip {
        override fun get(effect: AbilityEffect): List<Text> {
            if (effect is ChargeProperty){
                val color = if (effect.getCharges() < 0) Formatting.RED else Formatting.WHITE
                return listOf(Symbol.CHARGE.asText().append(" ")
                    .append(Translations.TOOLTIP_ABILITY_CHARGES.formatted(Formatting.GRAY).append(": "))
                    .append(LiteralText(signed(effect.getCharges())).formatted(color)))
            }
            return emptyList()
        }
    }
}