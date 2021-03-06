package com.codenjoy.dojo.battlecity.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.services.settings.Parameter;

public class Ammunition {

    private int ammoCount;
    private Parameter<Integer> initialAmmoCount;

    public Ammunition(Parameter<Integer> initialAmmoCount) {
        this.ammoCount = initialAmmoCount.getValue();
        this.initialAmmoCount = initialAmmoCount;
    }

    public void replenishAmmo(int bonusAmmo){
        ammoCount += bonusAmmo;
    }

    public void ammoAfterShotDecrement(){
        ammoCount--;
    }

    public int getAmmoCount() {
        return ammoCount;
    }

    public void setAmmoCount(int ammoCount) {
        this.ammoCount = ammoCount;
    }

    public boolean enoughAmmo(){
       return ammoCount > 0; 
    }


    public void refreshAmmo() {
        ammoCount = initialAmmoCount.getValue();
    }
}
