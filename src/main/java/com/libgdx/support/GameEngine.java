package com.libgdx.support;

import com.badlogic.gdx.Game;

/**
 * 
 * @Title: GameEngine.java
 * 
 *         <pre>
 * 该类继承了Game类，是libGdx的程序入口
 *  compile files('lib/ojdbc-14.jar')
 *         </pre>
 * 
 * @author shimanqiang
 */
public abstract class GameEngine extends Game {
	GameEvent event;

	public GameEngine() {
		// this.event = new GameEventAdapter<>();
		// GameEngineManager.setGameEngine(this);
		this(null);
	}

	public GameEngine(GameEvent event) {
		if (event == null) {
			this.event = new GameEventAdapter<>();
		} else {
			this.event = event;
		}
		GameEngineManager.getInstance().setGameEngine(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		GameEngineManager.getInstance().destroy();
	}

	public GameEvent getEvent() {
		return event;
	}

}
