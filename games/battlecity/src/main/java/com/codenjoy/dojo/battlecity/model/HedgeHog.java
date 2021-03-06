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

public class HedgeHog extends PointImpl implements State<Elements, Player> {

    private int lifeCount;
    private boolean mortal = true;

    public HedgeHog(int x, int y) {
        super(x, y);
    }

    public HedgeHog(Point point, int lifeCount) {
        super(point);
        this.lifeCount = lifeCount;
    }

    public HedgeHog(Point point){
        super(point);
        this.mortal = false;
    }

    @Override
    public Elements state(Player player, Object... alsoAtPoint) {
        return Elements.HEDGEHOG;
    }

    public void tick() {
        if(this.mortal) { // если смертный не статический Hedgehog
            lifeCount--;
        }
    }

    public boolean isAlive() {
        if(!mortal || lifeCount > 0) return true;
        return false;
    }
}

