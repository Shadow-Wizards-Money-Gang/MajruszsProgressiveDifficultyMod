package com.majruszs_difficulty.events.attack_effects;

import com.majruszs_difficulty.ConfigHandler.Config;
import com.majruszs_difficulty.GameState;
import com.majruszs_difficulty.MajruszsHelper;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.potion.Effects;
import net.minecraft.world.Difficulty;

/** Making spider attacks have a chance to poison enemies. */
public class SpiderPoisonOnAttackEffect extends OnAttackEffectBase {
	public SpiderPoisonOnAttackEffect() {
		super( SpiderEntity.class, GameState.Mode.NORMAL, true, Effects.POISON );
	}

	@Override
	protected boolean isEnabled() {
		return !Config.isDisabled( Config.Features.SPIDER_POISON );
	}

	@Override
	protected double getChance() {
		return Config.getChance( Config.Chances.SPIDER_POISON );
	}

	@Override
	protected int getDurationInTicks( Difficulty difficulty ) {
		switch( difficulty ) {
			default:
				return 0;
			case NORMAL:
				return MajruszsHelper.secondsToTicks( 7.0 );
			case HARD:
				return MajruszsHelper.secondsToTicks( 15.0 );
		}
	}

	@Override
	protected int getAmplifier( Difficulty difficulty ) {
		return 0;
	}
}