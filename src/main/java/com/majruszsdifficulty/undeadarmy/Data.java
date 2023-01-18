package com.majruszsdifficulty.undeadarmy;

import com.mlib.nbt.NBTHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

public class Data {
	public final BlockPos positionToAttack;
	public final Direction direction;
	public Phase phase;
	public int phaseTicksLeft;
	public int ticksActive;
	public int ticksInactive;
	public int currentWave;

	public Data( BlockPos positionToAttack, Direction direction ) {
		this.positionToAttack = positionToAttack;
		this.direction = direction;
		this.phase = Phase.CREATED;
		this.phaseTicksLeft = 0;
		this.ticksActive = 0;
		this.ticksInactive = 0;
		this.currentWave = 0;
	}

	public Data( CompoundTag nbt ) {
		this.positionToAttack = NBTHelper.loadBlockPos( nbt, Keys.POSITION );
		this.direction = Direction.read( nbt );
		this.phase = Phase.read( nbt );
		this.phaseTicksLeft = nbt.getInt( Keys.PHASE_TICKS_LEFT );
		this.ticksActive = nbt.getInt( Keys.TICKS_ACTIVE );
		this.ticksInactive = nbt.getInt( Keys.TICKS_INACTIVE );
		this.currentWave = nbt.getInt( Keys.CURRENT_WAVE );
	}

	public CompoundTag write( CompoundTag nbt ) {
		NBTHelper.saveBlockPos( nbt, Keys.POSITION, this.positionToAttack );
		this.direction.write( nbt );
		this.phase.write( nbt );
		nbt.putInt( Keys.PHASE_TICKS_LEFT, this.phaseTicksLeft );
		nbt.putInt( Keys.TICKS_ACTIVE, this.ticksActive );
		nbt.putInt( Keys.TICKS_INACTIVE, this.ticksInactive );
		nbt.putInt( Keys.CURRENT_WAVE, this.currentWave );

		return nbt;
	}

	public void setPhase( Phase phase, int ticksLeft ) {
		this.phase = phase;
		this.phaseTicksLeft = ticksLeft;
	}

	public void setPhase( Phase phase ) {
		this.setPhase( phase, 0 );
	}
}
