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

import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;
import com.codenjoy.dojo.services.State;
import com.codenjoy.dojo.services.Tickable;

public class MedKitBonus extends PointImpl implements Tickable, State<Elements, Player> {

    private final static int BONUS_LIVES = 1;

    private int lifeCycle;

    public MedKitBonus(Point p, int lifeTime) {
        super(p);

        lifeCycle = lifeTime;
    }

    public boolean isAlive() {
        return lifeCycle > 0;
    }

    @Override
    public Elements state(Player player, Object... alsoAtPoint) {
        return Elements.MEDKIT;
    }

    @Override
    public void tick() {
        lifeCycle--;
    }

    public int getBonusLives() {
        return BONUS_LIVES;
    }

    public void destroy() {
        lifeCycle = 0;
    }
}
